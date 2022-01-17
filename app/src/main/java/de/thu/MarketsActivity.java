package de.thu;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MarketsActivity extends AppCompatActivity {
    TextView address1;
    TextView address2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_markets);
        address1 = findViewById(R.id.market_location);
        address2 = findViewById(R.id.market_location_n);

        address1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.it/maps/search/"+ address1.getText()));
                startActivity(browserIntent);
            }
        });

        address2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.it/maps/search/"+ address2.getText()));
                startActivity(browserIntent);
            }
        });
    }
}