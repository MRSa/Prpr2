package net.osdn.gokigen.watchface.prpr2.complications

import android.app.PendingIntent
import android.content.ComponentName
import android.graphics.drawable.Icon
import android.util.Log
import androidx.wear.watchface.complications.data.ComplicationData
import androidx.wear.watchface.complications.data.ComplicationType
import androidx.wear.watchface.complications.data.NoDataComplicationData
import androidx.wear.watchface.complications.data.PhotoImageComplicationData
import androidx.wear.watchface.complications.data.PlainComplicationText
import androidx.wear.watchface.complications.data.SmallImage
import androidx.wear.watchface.complications.data.SmallImageComplicationData
import androidx.wear.watchface.complications.data.SmallImageType
import androidx.wear.watchface.complications.datasource.ComplicationRequest
import androidx.wear.watchface.complications.datasource.SuspendingComplicationDataSourceService

class PictureProvideComplicationsService : SuspendingComplicationDataSourceService()
{
    private val provider = DrawableResourceProvider()


    override fun getPreviewData(type: ComplicationType): ComplicationData
    {
        try
        {
            Log.v(TAG, "onComplicationRequest(): ${type} ")
            if ((type != ComplicationType.PHOTO_IMAGE)&&(type != ComplicationType.SMALL_IMAGE))
            {
                return NoDataComplicationData()
            }
            if (type == ComplicationType.SMALL_IMAGE)
            {
                return (getSmallImageComplicationData(null, true))
            }
            return (getPhotoImageComplicationData(null, true))
        }
        catch (e: Exception)
        {
            e.printStackTrace()
        }
        return (NoDataComplicationData())
    }

    override suspend fun onComplicationRequest(request: ComplicationRequest): ComplicationData
    {
        try
        {
            Log.v(TAG, "onComplicationRequest(): ${request.complicationType} : ${request.complicationInstanceId} (${request.immediateResponseRequired})")
            if ((request.complicationType != ComplicationType.PHOTO_IMAGE)&&(request.complicationType != ComplicationType.SMALL_IMAGE))
            {
                return NoDataComplicationData()
            }

            val pictureProvideIntent = PictureProvideComplicationsBroadcastReceiver.getIntent(
                context = this,
                dataSource =  ComponentName(this, javaClass),
                complicationId = request.complicationInstanceId
            )



            if (request.complicationType == ComplicationType.SMALL_IMAGE)
            {
                return (getSmallImageComplicationData(pictureProvideIntent))
            }
            return (getPhotoImageComplicationData(pictureProvideIntent))
        }
        catch (e: Exception)
        {
            e.printStackTrace()
        }
        return (NoDataComplicationData())
    }

    override fun onStartImmediateComplicationRequests(complicationInstanceId: Int)
    {
        Log.d(TAG, "onStartImmediateComplicationRequests(): $complicationInstanceId")
    }

    override fun onComplicationActivated(complicationInstanceId: Int, type: ComplicationType)
    {
        Log.d(TAG, "onComplicationActivated(): $complicationInstanceId")
    }


    override fun onComplicationDeactivated(complicationInstanceId: Int)
    {
        Log.d(TAG, "onComplicationDeactivated(): $complicationInstanceId")
    }

    private fun getSmallImageComplicationData(pendingIntent: PendingIntent?, isPreview: Boolean = false): ComplicationData
    {
        return (SmallImageComplicationData.Builder(
            smallImage = SmallImage.Builder(Icon.createWithResource(this, provider.getDrawable()), SmallImageType.ICON).build(),
            contentDescription = PlainComplicationText.Builder(
                text = if (isPreview) { getText(R.string.small_image_preview )} else { getText(R.string.small_image) }
            ).build()
        ).setTapAction(pendingIntent)
            .build())
    }

    private fun getPhotoImageComplicationData(pendingIntent: PendingIntent?, isPreview: Boolean = false): ComplicationData
    {
        return (PhotoImageComplicationData.Builder(
            photoImage = Icon.createWithResource(this, provider.getDrawable()),
            contentDescription = PlainComplicationText.Builder(
                text = if (isPreview) { getText(R.string.photo_image_preview )} else { getText(R.string.photo_image) }
            ).build()
        ).setTapAction(pendingIntent)
            .build())
    }

    companion object
    {
        private val TAG = PictureProvideComplicationsService::class.java.simpleName
    }
}
