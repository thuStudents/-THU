package de.thu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

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

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signedAsGuest = false;
                startActivity(new Intent(getApplicationContext()
                        , LoginActivity.class));
                overridePendingTransition(0,0);

            }
        });

        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signedAsGuest = false;
                startActivity(new Intent(getApplicationContext()
                        , RegisterActivity.class));
                overridePendingTransition(0,0);
            }
        });

        guest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //SET GUEST RESTRICTIONS
                signedAsGuest = true;
                startActivity(new Intent(getApplicationContext()
                        , HomeActivity.class));
                overridePendingTransition(0,0);

            }
        });
    }
}