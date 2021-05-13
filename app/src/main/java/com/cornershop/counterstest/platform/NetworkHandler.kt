package com.cornershop.counterstest.platform

import android.content.Context
import android.content.Context.CONNECTIVITY_SERVICE
import android.net.ConnectivityManager
import android.os.Build
import android.os.Build.VERSION_CODES.M
import com.cornershop.counterstest.config.NetworkStatus

class NetworkHandler(private val context: Context) : NetworkStatus {

    override fun isConnected(): Boolean =
        (context.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager).let { connectivityManager ->
            if (Build.VERSION.SDK_INT >= M) {
                connectivityManager.activeNetwork != null
            } else {
                @Suppress("DEPRECATION")
                connectivityManager.activeNetworkInfo?.isConnected ?: return false
            }
        }
}

