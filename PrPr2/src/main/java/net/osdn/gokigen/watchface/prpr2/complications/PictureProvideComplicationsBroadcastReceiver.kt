package net.osdn.gokigen.watchface.prpr2.complications

import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.wear.watchface.complications.datasource.ComplicationDataSourceUpdateRequester
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class PictureProvideComplicationsBroadcastReceiver : BroadcastReceiver()
{
    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)

    override fun onReceive(context: Context, intent: Intent?)
    {
        // Log.v(TAG, "onReceive() : $intent")

        val extras = intent?.extras ?: return
        val dataSource = extras.getParcelable<ComponentName>(EXTRA_DATA_SOURCE_COMPONENT) ?: return
        val complicationId = extras.getInt(EXTRA_COMPLICATION_ID)

        val result = goAsync()
        scope.launch {
            try
            {
                val complicationDataSourceUpdateRequester =
                    ComplicationDataSourceUpdateRequester.create(
                        context = context,
                        complicationDataSourceComponent = dataSource
                    )
                complicationDataSourceUpdateRequester.requestUpdate(complicationId)
                Log.v(TAG, "complicationDataSourceUpdateRequester.requestUpdate($complicationId)")
            }
            finally
            {
                result.finish()
            }
        }
    }

    companion object
    {
        private val TAG = PictureProvideComplicationsBroadcastReceiver::class.java.simpleName

        private const val EXTRA_DATA_SOURCE_COMPONENT =
            "net.osdn.gokigen.watchface.prpr2.complications.action.DATA_SOURCE_COMPONENT"

        private const val EXTRA_COMPLICATION_ID =
            "net.osdn.gokigen.watchface.prpr2.complications.action.COMPLICATION_ID"

        fun getIntent(
            context: Context,
            dataSource: ComponentName,
            complicationId: Int
        ): PendingIntent {
            val intent = Intent(context, PictureProvideComplicationsBroadcastReceiver::class.java)
            intent.putExtra(EXTRA_DATA_SOURCE_COMPONENT, dataSource)
            intent.putExtra(EXTRA_COMPLICATION_ID, complicationId)
            return PendingIntent.getBroadcast(
                context,
                complicationId,
                intent,
                PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
            )
        }
    }
}
