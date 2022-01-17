package de.thu;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;

public class NewPostNotifier {

    private static final int NOTIFICATION_ID = 123;
    private static String CHANNEL_ID = "currency_channel";
    private static String CHANNEL_DESCRIPTION = "Currency Refreshed Notifier";
    NotificationCompat.Builder notificationBuilder;
    NotificationManager notificationManager;

        public NewPostNotifier(Context context) {
            notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                NotificationChannel notificationChannel = notificationManager.getNotificationChannel("stopwatch_channel");
                if (notificationChannel == null) {
                    notificationChannel = new NotificationChannel(CHANNEL_ID,
                            CHANNEL_DESCRIPTION,
                            NotificationManager.IMPORTANCE_DEFAULT);
                    notificationManager.createNotificationChannel(notificationChannel);
                }
            }
            notificationBuilder = new NotificationCompat.Builder(context, CHANNEL_ID)
                    .setSmallIcon(R.drawable.ic_baseline_textsms_24)
                    .setContentTitle("Your Posted Something!")
                    .setAutoCancel(true);

            Intent resultIntent = new Intent(context, MainActivity.class);
            resultIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            PendingIntent resultPendingIntent = PendingIntent.getActivity(context, 0, resultIntent, 0);
            notificationBuilder.setContentIntent(resultPendingIntent);
        }
        public void showNotification() {
            notificationManager.notify(NOTIFICATION_ID, notificationBuilder.build());
        }
        public void removeNotification() {
            notificationManager.cancel(NOTIFICATION_ID);
        }
}
