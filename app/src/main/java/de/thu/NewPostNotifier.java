package de.thu;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;

public class NewPostNotifier {

    private static final int NOTIFICATION_ID = 123;
    private static String CHANNEL_ID = "post_channel";
    private static String CHANNEL_DESCRIPTION = "Posted Notifier";
    NotificationCompat.Builder notificationBuilder;
    NotificationManager notificationManager;

    /**
     * Here a notifier is constructed. The System services are used to create a notification channel.
     * Then a new notification is built. The notification data is set.
     * If the notification is clicked the user is redirected to the corresponding activity which caused the notification.
     * So far the user is only notified when his post was added to the forum.
     * @param context
     */
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
                    .setContentTitle("Your post was added successfully !!!")
                    .setAutoCancel(true);

            Intent resultIntent = new Intent(context, MainActivity.class);
            resultIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            PendingIntent resultPendingIntent = PendingIntent.getActivity(context, 0, resultIntent, 0);
            notificationBuilder.setContentIntent(resultPendingIntent);
        }

    /**
     * This method shows the notification.
     */
    public void showNotification() {
            notificationManager.notify(NOTIFICATION_ID, notificationBuilder.build());
        }
}
