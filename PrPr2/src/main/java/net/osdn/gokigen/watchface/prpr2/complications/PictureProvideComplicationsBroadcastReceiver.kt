package net.osdn.gokigen.watchface.prpr2.complications

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

class PictureProvideComplicationsBroadcastReceiver : BroadcastReceiver()
{
    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)


    override fun onReceive(context: Context?, intent: Intent?)
    {
        try
        {
            // -----

        }
        catch (e: Exception)
        {
            e.printStackTrace()
        }
    }

    companion object {
        private val TAG = PictureProvideComplicationsBroadcastReceiver::class.java.simpleName
    }
}
