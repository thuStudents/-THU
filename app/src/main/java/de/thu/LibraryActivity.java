package de.thu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class LibraryActivity extends AppCompatActivity {
    View view;

    TextView viewLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
        viewLink = findViewById(R.id.textLibrary3Link);

        viewLink.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://bsz.ibs-bw.de/aDISWeb/app?service=direct/0/Home/$DirectLink&sp=SOPAC32"));

                //Set flag
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                //START ACTIVITY
                startActivity(intent);


            }});

    }
}






