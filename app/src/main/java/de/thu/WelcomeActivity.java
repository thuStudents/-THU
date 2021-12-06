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
//                Intent intent = new Intent(WelcomeActivity.this, LoginActivity.class);
//                startActivity(intent);
                startActivity(new Intent(getApplicationContext()
                        , LoginActivity.class));
                overridePendingTransition(0,0);

            }
        });

        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(WelcomeActivity.this, RegisterActivity.class);
//                startActivity(intent);
                startActivity(new Intent(getApplicationContext()
                        , RegisterActivity.class));
                overridePendingTransition(0,0);
            }
        });

        guest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //SET GUEST RESTRICTIONS
//                Intent intent = new Intent(WelcomeActivity.this, HomeActivity.class);
//                startActivity(intent);
                startActivity(new Intent(getApplicationContext()
                        , HochschuleGeneralActivity.class));
                overridePendingTransition(0,0);

            }
        });
    }
}