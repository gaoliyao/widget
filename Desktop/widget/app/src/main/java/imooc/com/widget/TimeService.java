package imooc.com.widget;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.RemoteViews;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by MAC on 15/10/28.
 */
public class TimeService extends Service {
    private Timer timer;
    private SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm");
    @Override
    public IBinder onBind(Intent arg0){
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                updateViews();
            }
        }, 0, 1000);
    }


    private void updateViews(){
        String time=sdf.format(new Date());
        RemoteViews rv=new RemoteViews(getPackageName(),R.layout.new_app_widget);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        timer=null;

    }
}
