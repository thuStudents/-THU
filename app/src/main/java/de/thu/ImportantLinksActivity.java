package de.thu;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class ImportantLinksActivity extends AppCompatActivity {
    TextView viewLink, viewLink1, viewLink2, viewLink3, viewLink4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_important_links);


        /**
         * Several text views are initialized from the layout.
         * For each text view a click listener was set.
         * In case the text view was clicked an Intent is created which redirects the user to the corresponding website.
         */
        viewLink = findViewById(R.id.thuWebsiteLink);
            viewLink1 = findViewById(R.id.verwaltungLink);
            viewLink2 = findViewById(R.id.lsfLink);
            viewLink3 = findViewById(R.id.webmailLink);
            viewLink4 = findViewById(R.id.publicFolderLink);

            viewLink.setOnClickListener(new View.OnClickListener(){
                public void onClick(View view) {

                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://studium.hs-ulm.de"));

                    //Set flag
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                    //START ACTIVITY
                    startActivity(intent);
                }});
            viewLink1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {

                Intent intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.verwaltung.hs-ulm.de/studieren/rds?state=user&type=0"));

                //Set flag
                intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                //START ACTIVITY
                startActivity(intent1);
            }});
        viewLink2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {

                Intent intent2 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://lsf.verwaltung.hs-ulm.de/"));


                //Set flag
                intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                //START ACTIVITY
                startActivity(intent2);
            }});

        viewLink3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {

                Intent intent3 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://webmail.hs-ulm.de/"));

                //Set flag
                intent3.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                //START ACTIVITY
                startActivity(intent3);
            }});
        viewLink.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {

                Intent intent4 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://fs.hs-ulm.de/public/"));


                //Set flag
                intent4.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                //START ACTIVITY
                startActivity(intent4);
            }});

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelected(false);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.find:
                        if (WelcomeActivity.signedAsGuest != true) {
                            startActivity(new Intent(getApplicationContext()
                                    , Profile.class));
                        } else {
                            Toast.makeText(ImportantLinksActivity.this, "You are not Logged In", Toast.LENGTH_SHORT).show();
                        }
                        return true;
                    case R.id.add:
                        if (WelcomeActivity.signedAsGuest != true) {
                            startActivity(new Intent(getApplicationContext()
                                    , PostActivity.class));
                            overridePendingTransition(0, 0);
                        } else {
                            Toast.makeText(ImportantLinksActivity.this, "You are not Logged In", Toast.LENGTH_SHORT).show();
                        }
                        return true;
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext()
                                , HomeActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                }

                return false;
            }
        });



    }
}
