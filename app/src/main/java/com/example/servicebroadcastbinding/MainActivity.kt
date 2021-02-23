package com.example.servicebroadcastbinding

import android.app.PendingIntent
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.servicebroadcastbinding.service.DataBroadcastReceiver
import com.example.servicebroadcastbinding.service.DataRequestService

class MainActivity : AppCompatActivity() {
    companion object{
    val TAG = "JAUHAR"
}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "this.mainLooper: ${this.mainLooper}")
    }

    fun getDataFromServiceByBroadcastReceiver(view: View) {
        Log.d(TAG, "this.mainLooper: ${this.mainLooper}")
        var serviceIntent = Intent(this, DataRequestService::class.java)
        //this is the intent that will be broadcasted by service.
        var broadcastReceiverIntent = Intent(this, DataBroadcastReceiver::class.java)
        //create pending intent for broadcasting the DataBroadcastReceiver
        var pIntent = PendingIntent.getBroadcast(this, 0, broadcastReceiverIntent, 0)
        var bundle = Bundle()
        bundle.putParcelable("receiver", pIntent)
        //we want to start our service (for handling our time-consuming operation)
        serviceIntent.putExtras(bundle)
        startService(serviceIntent)
    }
}