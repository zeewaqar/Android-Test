package info.sikandar.bubblesjava;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button createBubble;

    Notification.Builder builder;
    NotificationManager notificationManager;
    NotificationChannel channel;

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createBubble = findViewById(R.id.createBubble);

        notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        CharSequence name = "Bubble Notification Channel";
        String description = " Made for Software Engineering Project";
        int importance = NotificationManager.IMPORTANCE_HIGH;

        channel = new NotificationChannel("1", name, importance);
        channel.setDescription(description);
        channel.setAllowBubbles(true);

        createBubble.setOnClickListener(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.createBubble:

                Intent target = new Intent(this, BubbleActivity.class);

                PendingIntent bubbleIntent =
                        PendingIntent.getActivity(MainActivity.this, 0, target, PendingIntent.FLAG_UPDATE_CURRENT /* flags */);

                Notification.BubbleMetadata bubbleData =
                        new Notification.BubbleMetadata.Builder()
                                .setDesiredHeight(600)
                                .setIcon(Icon.createWithResource(MainActivity.this, R.drawable.bubble_icon_background))
                                .setIntent(bubbleIntent)
                                .build();

                builder = new Notification.Builder(MainActivity.this, channel.getId())
                        .setSmallIcon(R.drawable.bubble_icon_circle)
                        .setBubbleMetadata(bubbleData);

                notificationManager.createNotificationChannel(channel);
                notificationManager.notify(1, builder.build());
                break;

        }

    }
}