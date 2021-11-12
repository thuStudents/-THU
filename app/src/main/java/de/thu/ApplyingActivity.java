package de.thu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class ApplyingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_applying);
        TextView txt = findViewById(R.id.applyInfo);
        txt.setMovementMethod(new ScrollingMovementMethod());
    }
}