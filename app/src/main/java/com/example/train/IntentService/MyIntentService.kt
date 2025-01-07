package com.example.train.IntentService

import android.app.IntentService
import android.content.Context
import android.content.Intent
import android.util.Log

class MyIntentService : IntentService("MyIntentService") {

    override fun onHandleIntent(intent: Intent?) {
        when (intent?.action) {
            ACTION_DOWNLOAD -> {
                val url = intent.getStringExtra(EXTRA_URL)
                handleDownload(url)
            }
            else -> {
                Log.d(TAG, "Không có hành động nào được xử lý.")
            }
        }
    }

    private fun handleDownload(url: String?) {
        Log.d(TAG, "Bắt đầu tải xuống từ: $url")
        // Thực hiện công việc tải xuống hoặc xử lý
        Thread.sleep(3000) // Giả lập tải xuống mất 3 giây
        Log.d(TAG, "Tải xuống hoàn tất: $url")
    }

    companion object {
        const val ACTION_DOWNLOAD = "com.example.intentservice.action.DOWNLOAD"
        const val EXTRA_URL = "com.example.intentservice.extra.URL"
        private const val TAG = "MyIntentService"

        fun startDownload(context: Context, url: String) {
            val intent = Intent(context, MyIntentService::class.java).apply {
                action = ACTION_DOWNLOAD
                putExtra(EXTRA_URL, url)
            }
            context.startService(intent)
        }
    }
}
