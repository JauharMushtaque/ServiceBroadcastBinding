package com.example.servicebroadcastbinding.service

import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.*
import android.util.Log


class DataRequestService: Service() {
//    var looper= application.mainLooper
    val looper by lazy{
        application.mainLooper
    }
    val mServiceHandler by lazy{
        ServiceHandler(looper)
    }
//    var context=applicationContext
    companion object{
        val TAG = "JAUHAR"
    }
    override fun onBind(intent: Intent?): IBinder? {
        TODO("Not yet implemented")
    }

    class ServiceHandler(looper: Looper): Handler(){

        override fun handleMessage(msg: Message) {
            Log.d(TAG, "handleMessage: ")
            var bundle = msg.data
            var receiver: PendingIntent? = bundle.getParcelable("receiver")
            // Perform the operation associated with PendingIntent
            try {
                var intent = Intent()
                var bundle = Bundle()
                intent.putExtras(bundle)
                receiver?.send(0)
            }catch (e: PendingIntent.CanceledException){
                e.printStackTrace();
            }

        }

    }

    override fun onStart(intent: Intent?, startId: Int) {
        val bundle = intent!!.extras

        val msg: Message = mServiceHandler.obtainMessage()
        msg.data = bundle
        mServiceHandler.sendMessage(msg)
    }
}