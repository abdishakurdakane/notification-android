package com.shakuurdev.notifation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
   NotificationManagerCompat notificationManagerCompat;
   Notification notification;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            // create channnel
            NotificationChannel channel = new NotificationChannel("mych","mychannel", NotificationManager.IMPORTANCE_DEFAULT);
            // register the channel
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,"mych")
               .setSmallIcon(android.R.drawable.stat_notify_chat)
                .setContentTitle("first notifation")
                .setContentText("thiss the body of the message");

        notification = builder.build();
        notificationManagerCompat = NotificationManagerCompat.from(this);



    }

    public void push(View view) {
        notificationManagerCompat.notify(1,notification);
    }
}