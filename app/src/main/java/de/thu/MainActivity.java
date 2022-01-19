package de.thu;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * This is the first activity of the app. The starting activity.
         * Here we check if the user is already logged in from the last time it run the app.
         * If yes the user is directly sent to the homepage.
         * If not, the user is required to log in, register or continue as guest.
         * This activity shows a simple Starting App Activity Layout.
         * A timer is scheduled for 2 seconds.
         * This activity shows for 2 seconds and then redirects the user to the corresponding activity.
         */

        FirebaseUser mUser = FirebaseAuth.getInstance().getCurrentUser();
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                if( mUser == null) {
                    /**Intent flags used to clear the back stack so the user can not go back to this activity with the back button.
                     */
                     Intent intent = new Intent(MainActivity.this, WelcomeActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }else{
                    /**Intent flags used to clear the back stack so the user can not go back to this activity with the back button.
                     */
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
            }
        }, 2000);
    }
}
