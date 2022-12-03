package com.app.firebasedemo
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService: FirebaseMessagingService() {
    override fun onNewToken(token: String) {
        super.onNewToken(token)

        val refreshToken = FirebaseMessaging.getInstance().token

        Log.e("refresh token", refreshToken.toString())

    }

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)

        showNotification(message.notification?.title.toString(), message.notification?.body.toString())

    }

    fun showNotification(title: String, message: String){
        val builder = NotificationCompat.Builder(this,"text-notif")
            .setContentTitle(title)
            .setContentText(message)

        val manager =NotificationManagerCompat.from(this)
        manager.notify(6602,builder.build())

    }
}