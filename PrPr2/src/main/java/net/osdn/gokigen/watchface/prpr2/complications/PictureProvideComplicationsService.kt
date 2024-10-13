package net.osdn.gokigen.watchface.prpr2.complications

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
                return (getSmallImageComplicationData(true))
            }
            return (getPhotoImageComplicationData(true))
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
            if (request.complicationType == ComplicationType.SMALL_IMAGE)
            {
                return (getSmallImageComplicationData())
            }
            return (getPhotoImageComplicationData())
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

    private fun getSmallImageComplicationData(isPreview: Boolean = false): ComplicationData
    {
        return (SmallImageComplicationData.Builder(
            smallImage = SmallImage.Builder(Icon.createWithResource(this, provider.getDrawable()), SmallImageType.ICON).build(),
            contentDescription = PlainComplicationText.Builder(
                text = if (isPreview) { getText(R.string.small_image_preview )} else { getText(R.string.small_image) }
            ).build()
        ).build())
    }

    private fun getPhotoImageComplicationData(isPreview: Boolean = false): ComplicationData
    {
        return (PhotoImageComplicationData.Builder(
            photoImage = Icon.createWithResource(this, provider.getDrawable()),
            contentDescription = PlainComplicationText.Builder(
                text = if (isPreview) { getText(R.string.photo_image_preview )} else { getText(R.string.photo_image) }
            ).build()
        ).build())
    }

    companion object
    {
        private val TAG = PictureProvideComplicationsService::class.java.simpleName
    }
}

