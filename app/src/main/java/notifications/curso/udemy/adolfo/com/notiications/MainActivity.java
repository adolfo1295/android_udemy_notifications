package notifications.curso.udemy.adolfo.com.notiications;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;

/**
 * Notificaciones
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void createNotification(View v){
        //se crea un intent, que sera la mochila de llevar los datos a la sig activity
        Intent intent = new Intent(this, NotificationActivity.class);
        Intent accion1 = new Intent(this, NotificationActivity.class);
        accion1.putExtra("saludo","Hola humano!!");
        //este pendingintent se colocara dentro de la notificacion para manejar lo que haga al darle click
        //dentro de el ira el intent que creamos anteriormente
        //PendingIntent.getActivity (context,requestcode,intent,flags)
        PendingIntent mPendingIntent = PendingIntent.getActivity(this,1,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        PendingIntent mPendingIntent1 = PendingIntent.getActivity(this,1,accion1,PendingIntent.FLAG_UPDATE_CURRENT);
        //esto es para crear una notificacion
        NotificationCompat.Builder mBuilder = (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                //se le da un icono
                .setSmallIcon(R.drawable.ic_moto)
                //titulo
                .setContentTitle("mi notificacion")
                //texto o contenido d ela notificacion
                .setContentText("creaste tu primer notificacion!!")
                //aqui se coloca el pendingintent que mencionamos anteroormente
                .setContentIntent(mPendingIntent)
                //al darle click a la notificacion, se cancelara automaticamente
                .setAutoCancel(true)
                //se añade una accion, cabe destacar que en andorid 7.0 y superior ya no mostrara iconos
                .addAction(R.drawable.ic_moto,"Saludo",mPendingIntent1)
                //esto es para que vibre por default, haga un sonido por default y aparezca en la pantallaa
                .setDefaults(Notification.DEFAULT_ALL)
                //esto es para darle prioridad a la notificacion
                .setPriority(Notification.PRIORITY_MAX);
        mBuilder.setAutoCancel(true);
        //con esto se cambia el color d ela notificacion
        mBuilder.setColor(ContextCompat.getColor(getApplicationContext(),R.color.colorAccent));
        // Sets an ID for the notification
        int mNotificationId = 1;
        // Gets an instance of the NotificationManager service
        NotificationManager mNotifyMgr = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        // Builds the notification and issues it.
        mNotifyMgr.notify(mNotificationId, mBuilder.build());
    }

}
