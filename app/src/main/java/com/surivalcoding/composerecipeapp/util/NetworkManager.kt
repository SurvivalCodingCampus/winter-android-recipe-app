package com.surivalcoding.composerecipeapp.util

import android.net.ConnectivityManager
import android.net.Network
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject


// 네트워크 상태 체크 Manager
class NetworkManager @Inject constructor(
    private val connectivityManager: ConnectivityManager
) {
    private val _isConnected = MutableStateFlow(false)
    val isConnected = _isConnected.asStateFlow()


    // Network 상태 callback
    private val networkCallback = object : ConnectivityManager.NetworkCallback() {
        override fun onAvailable(network: Network) {
            _isConnected.value = true
        }

        override fun onLost(network: Network) {
            _isConnected.value = false
        }
    }

    // 콜백 등록
    fun registerNetworkCallback() {
        connectivityManager.registerDefaultNetworkCallback(networkCallback)
    }

    // 콜백 해제
    fun unRegisterNetworkCallback() {
        connectivityManager.unregisterNetworkCallback(networkCallback)
    }
}