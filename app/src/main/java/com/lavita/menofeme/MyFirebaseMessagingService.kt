package com.lavita.menofeme

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.widget.RemoteViews
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.lavita.menofeme.view.Principal
import com.lavita.menofeme.view.ui.questionarios.MenqolFragment

const val channelId = "notification_channel"
const val channelName = "com.lavita.menofeme"

class MyFirebaseMessagingService : FirebaseMessagingService() {

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        if(remoteMessage.notification != null){
            generateNotification(remoteMessage.notification!!.title!!, remoteMessage.notification!!.body!!)
        }
    }

    @SuppressLint("RemoteViewLayout")
    fun getRemoteView(titulo: String,mensagem: String): RemoteViews{
        val remoteView = RemoteViews("com.lavita.menofeme", R.layout.notification)
        remoteView.setTextViewText(R.id.titulo,titulo)
        remoteView.setTextViewText(R.id.mensagem,mensagem)
        remoteView.setImageViewResource(R.id.app_logo, R.drawable.ic_menstruacao)

        return remoteView
    }

    fun generateNotification(titulo: String, mensagem: String){
        val intent = Intent(this, Principal::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)

        val pendingIntent = PendingIntent.getActivity(
            this,
            0,
            intent,
            PendingIntent.FLAG_ONE_SHOT or PendingIntent.FLAG_IMMUTABLE
        )

        var builder: NotificationCompat.Builder = NotificationCompat.Builder(applicationContext, channelId)
            .setSmallIcon(R.drawable.ic_menstruacao)
            .setAutoCancel(true)
            .setVibrate(longArrayOf(1000,1000,1000,1000))
            .setOnlyAlertOnce(true)
            .setContentIntent(pendingIntent)

        builder = builder.setContent(getRemoteView(titulo,mensagem))

        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val notificationChannel = NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_HIGH)
            notificationManager.createNotificationChannel(notificationChannel)
        }

        notificationManager.notify(0,builder.build())

    }


}