package ual.tp.tp1;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;


public class AirPlaneReceiver extends BroadcastReceiver {
    public AirPlaneReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        sendNotification(context);

    }

    private void sendNotification(Context ctx) {
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(ctx)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle(ctx.getString(R.string.app_name))
                        .setContentText("Hello World!");
// Creates an explicit intent for an Activity in your app
        PendingIntent wakeIntent = PendingIntent.getActivity(ctx, 0,
                new Intent(ctx, LauncherActivity.class), 0);

        mBuilder.setContentIntent(wakeIntent);
        NotificationManager mNotificationManager =
                (NotificationManager) ctx.getSystemService(Context.NOTIFICATION_SERVICE);
// mId allows you to update the notification later on.
        mNotificationManager.notify(1, mBuilder.build());
    }

}
