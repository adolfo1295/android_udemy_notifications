package notifications.curso.udemy.adolfo.com.notiications;

import android.app.NotificationManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class NotificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        if (getIntent().getExtras()!=null){
            String dato = getIntent().getExtras().getString("saludo",null);
            Toast.makeText(this, dato, Toast.LENGTH_SHORT).show();
        }
        //al abrir la nueva actividad se vuelve a llamar a un notificationmanager
        //para remover las notificaciones
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.cancel(1);
    }
}
