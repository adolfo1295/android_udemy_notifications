package notifications.curso.udemy.adolfo.com.notiications;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void createNotification(View v){
        Intent intent = new Intent();
        intent.setClass(this,NotificationActivity.class);
        PendingIntent mPendingIntent = PendingIntent.getActivity(this,001,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Builder mBuilder = (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_moto)
                .setContentTitle("mi notificacion")
                .setContentText("creaste tu primer notificacion!!")
                .setContentIntent(mPendingIntent)
                .setAutoCancel(true)
                .setPriority(Notification.PRIORITY_MAX);
        // Sets an ID for the notification
        int mNotificationId = 001;
        // Gets an instance of the NotificationManager service
        NotificationManager mNotifyMgr = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        // Builds the notification and issues it.
        mNotifyMgr.notify(mNotificationId, mBuilder.build());
    }


    public void buttonClicked(View v){
        //build notification
        Intent intent = new Intent();
        intent.setClass(this,NotificationActivity.class);
        PendingIntent mPendingIntent = PendingIntent.getActivity(this,001,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Builder builder =
                (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.ic_moto)
                        .setContentTitle("Ping Notification")
                        .setContentText("Tomorrow will be your birthday.")
                        .setAutoCancel(true)
                        .setDefaults(Notification.DEFAULT_ALL) // must requires VIBRATE permission
                        .setPriority(NotificationCompat.PRIORITY_HIGH) //must give priority to High, Max which will considered as heads-up notification
                        .addAction(R.drawable.ic_moto,"accion 2",mPendingIntent)
                        .addAction(R.mipmap.ic_launcher,"Titulo",mPendingIntent);

        // Gets an instance of the NotificationManager service
        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        //to post your notification to the notification bar with a id. If a notification with same id already exists, it will get replaced with updated information.
        notificationManager.notify(0, builder.build());
    }

}
