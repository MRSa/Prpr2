package net.osdn.gokigen.watchface.prpr2.complications

import android.graphics.drawable.Icon
import android.util.Log
import androidx.wear.watchface.complications.data.ComplicationData
import androidx.wear.watchface.complications.data.ComplicationType
import androidx.wear.watchface.complications.data.NoDataComplicationData
import androidx.wear.watchface.complications.data.PhotoImageComplicationData
import androidx.wear.watchface.complications.data.PlainComplicationText
import androidx.wear.watchface.complications.datasource.ComplicationRequest
import androidx.wear.watchface.complications.datasource.SuspendingComplicationDataSourceService

class PictureProvideComplicationsService : SuspendingComplicationDataSourceService()
{
    private val provider = DrawableResourceProvider()

    override fun getPreviewData(type: ComplicationType): ComplicationData
    {
        return (getComplicationData( true))
    }

    override suspend fun onComplicationRequest(request: ComplicationRequest): ComplicationData
    {
        try
        {
            Log.v(TAG, "onComplicationRequest(): ${request.complicationType} : ${request.complicationInstanceId}")
            if (request.complicationType != ComplicationType.PHOTO_IMAGE)
            {
                return NoDataComplicationData()
            }
            return (getComplicationData())
        }
        catch (e: Exception)
        {
            e.printStackTrace()
        }
        return (NoDataComplicationData())
    }

    override fun onComplicationActivated(complicationInstanceId: Int, type: ComplicationType)
    {
        Log.d(TAG, "onComplicationActivated(): $complicationInstanceId")
    }


    override fun onComplicationDeactivated(complicationInstanceId: Int)
    {
        Log.d(TAG, "onComplicationDeactivated(): $complicationInstanceId")
    }

    private fun getComplicationData(isPreview: Boolean = false): ComplicationData
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

