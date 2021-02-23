package com.example.servicebroadcastbinding.service

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class DataBroadcastReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Log.d(DataRequestService.TAG, "onReceive: ")
    }
}