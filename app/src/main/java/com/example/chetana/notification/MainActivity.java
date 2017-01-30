package com.example.chetana.notification;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    NotificationCompat.Builder notification;

    private static final int uniqueId = 46544;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notification = new NotificationCompat.Builder(this);
        notification.setAutoCancel(true);
    }


   public void sendNotification(View view){

       // build the notification
       notification.setSmallIcon(R.mipmap.ic_launcher);
       notification.setTicker("This is the ticker");
       notification.setWhen(System.currentTimeMillis());
       notification.setContentTitle("There is the title");
       notification.setContentText("This is the conetent text");

       Intent intent = new Intent(this, MainActivity.class);

       PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
       notification.setContentIntent(pendingIntent);

       // builds a notification and issues it

       NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
       notificationManager.notify(uniqueId,notification.build());
   }

}
