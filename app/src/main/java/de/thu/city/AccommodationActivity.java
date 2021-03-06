package de.thu.city;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import de.thu.HomeActivity;
import de.thu.forum.PostActivity;
import de.thu.profile.Profile;
import de.thu.R;
import de.thu.WelcomeActivity;

public class AccommodationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accommodation);

        /**
         * BOTTOM NAVIGATION
         * find the bottom navigation bar by ID and mark home as selected as if it was tapped.
         * set an on click listener for the three buttons of the BOTTOM NAV BAR that starts the corresponding intent
         */
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.find:
                        if(WelcomeActivity.signedAsGuest!=true){
                            startActivity(new Intent(getApplicationContext()
                                    , Profile.class));
                        } else {
                            Toast.makeText(AccommodationActivity.this, "You are not Logged In", Toast.LENGTH_SHORT).show();
                        }
                        return true;
                    case R.id.add:
                        if(WelcomeActivity.signedAsGuest!=true){
                            startActivity(new Intent(getApplicationContext()
                                    , PostActivity.class));
                            overridePendingTransition(0,0);
                        } else {
                            Toast.makeText(AccommodationActivity.this, "You are not Logged In", Toast.LENGTH_SHORT).show();
                        }
                        return true;
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext()
                                , HomeActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }

                return false;
            }
        });

        /**
         * RESIDENTIAL BUILDING AND PRIVATE ROOM IMAGES
         * find the images by ID and set an on click listener
         * The on click listner starts the corresponding intent
         */

        ImageView resbul_imageView = findViewById(R.id.private_rooms_image);
        ImageView privroom_imageView = findViewById(R.id.shared_room_image);

        resbul_imageView.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext()
                        , RensidentialBuildingsActivity.class));
                overridePendingTransition(0,0);
            }});

        privroom_imageView.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext()
                        , PrivateBuildingActivity.class));
                overridePendingTransition(0,0);
            }});



    }
}