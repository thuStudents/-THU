package de.thu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toast.makeText(MainActivity.this, "Firebase Connection Success",Toast.LENGTH_LONG).show();
      //Intent intent = new Intent(this, LoginActivity.class);
    //startActivity(intent);

        Intent intent = new Intent(this, UlmInformationActivity.class);
       startActivity(intent);
    }
}