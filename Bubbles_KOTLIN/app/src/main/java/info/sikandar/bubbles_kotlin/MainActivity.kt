package info.sikandar.bubbles_kotlin

import android.annotation.SuppressLint
import android.app.Notification
import android.app.Notification.BubbleMetadata
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.graphics.drawable.Icon
import android.os.Bundle
import android.widget.RemoteViews
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var notificationManager : NotificationManager
    lateinit var notificationChannel : NotificationChannel
    lateinit var builder : Notification.Builder
    private val channelId = "com.example.vicky.notificationexample"
    private val description = "Test notification"

    @SuppressLint("NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        btn_notify.setOnClickListener {

            val intent = Intent(this,BubbleActivity::class.java)
            val pendingIntent = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT)

            val bubbleData = BubbleMetadata.Builder()
                .setDesiredHeight(600)
                .setIcon(
                    Icon.createWithResource(
                        this@MainActivity,
                        R.drawable.ic_launcher_foreground
                    )
                )
                .setIntent(pendingIntent)
                .build()

            builder = Notification.Builder(this@MainActivity, channelId)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setBubbleMetadata(bubbleData)

            notificationManager.createNotificationChannel(notificationChannel)
            notificationManager.notify(1, builder.build())

//            val contentView = RemoteViews(packageName,R.layout.notification_layout)
//            contentView.setTextViewText(R.id.tv_title,"CodeAndroid")
//            contentView.setTextViewText(R.id.tv_content,"Text notification")
//
//                notificationChannel = NotificationChannel(channelId,description,NotificationManager.IMPORTANCE_HIGH)
//                notificationChannel.enableLights(true)
//                notificationChannel.lightColor = Color.GREEN
//                notificationChannel.enableVibration(false)
//                notificationManager.createNotificationChannel(notificationChannel)
//
//                builder = Notification.Builder(this,channelId)
//                    .setContent(contentView)
//                    .setSmallIcon(R.drawable.ic_launcher_background)
//                    .setLargeIcon(BitmapFactory.decodeResource(this.resources,R.drawable.ic_launcher_foreground))
//                    .setContentIntent(pendingIntent)


//  ----------------------------------------------------------------------------------




//                val target = Intent(this, BubbleActivity::class.java)

//                val bubbleIntent = PendingIntent.getActivity(this@MainActivity,0,target,PendingIntent.FLAG_UPDATE_CURRENT /* flags */)


//                builder = Notification.Builder(this@MainActivity, channel.getId())
//                    .setSmallIcon(R.drawable.ic_message)
//                    .setBubbleMetadata(bubbleData)

//  ----------------------------------------------------------------------------------

        }

    }
}