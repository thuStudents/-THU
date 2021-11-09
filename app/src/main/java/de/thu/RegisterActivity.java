package de.thu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{
    TextView alreadyHaveAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        alreadyHaveAccount = findViewById(R.id.alreadyHaveAccount);
        alreadyHaveAccount.setOnClickListener(this);
    }
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.alreadyHaveAccount:
                Intent alreadyHaveAccount = new Intent(this, LoginActivity.class);
                startActivity(alreadyHaveAccount);
                break;
            default:
                break;
        }

    }

}