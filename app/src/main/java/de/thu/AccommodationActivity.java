package de.thu;

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

public class AccommodationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accommodation);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.find:
                        startActivity(new Intent(getApplicationContext()
                                , Profile.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.add:
                        startActivity(new Intent(getApplicationContext()
                                , PostActivity.class));
                        overridePendingTransition(0,0);
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