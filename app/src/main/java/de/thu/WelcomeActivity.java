package de.thu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import de.thu.profile.LoginActivity;
import de.thu.profile.RegisterActivity;

public class WelcomeActivity extends AppCompatActivity {
    Button loginBtn, signupBtn;
    TextView guest;
    public static boolean signedAsGuest = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        loginBtn = findViewById(R.id.buttonLoginWelcome);
        signupBtn = findViewById(R.id.buttonSignupWelcome);
        guest = findViewById(R.id.guestTextClickable);

        /**
         * Here the handling for 2 buttons and 1 clickable text view are implemented.
         * In the welcoming page, the user is required to login, sign up or continue as a guest.
         * The login and signup buttons simply redirect the user to the corresponding activities.
         * The guest text redirects the user to the homepage.
         * Considering the user is a guest some parts of the app are not accessible for them.
         * This is implemented by maintaining a variable which is true in case the user is a guest.
         * The parts of the app the guest is not allowed to access,
         * first check if the user is a guest through this variable, then show the content.
         */

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signedAsGuest = false;
                //Intent flags used to clear the back stack so the user can not go back to this activity with the back button
                Intent intent = new Intent(WelcomeActivity.this, LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signedAsGuest = false;
                //Intent flags used to clear the back stack so the user can not go back to this activity with the back button
                Intent intent = new Intent(WelcomeActivity.this, RegisterActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        guest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //SET GUEST RESTRICTIONS
                signedAsGuest = true;
                //Intent flags used to clear the back stack so the user can not go back to this activity with the back button
                Intent intent = new Intent(WelcomeActivity.this, HomeActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);

            }
        });
    }
}