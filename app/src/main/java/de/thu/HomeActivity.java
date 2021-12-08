package de.thu;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    ImageView home, add, find;
    BottomNavigationView bottomNavigationView;
    RecyclerView.Adapter adapter;
    RecyclerView latest_updates;
    //LinearLayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_homepage_activity);


        //hooks
        latest_updates=findViewById(R.id.latest_updates);

        latest_updates();

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
                        Toast.makeText(HomeActivity.this, "Home", Toast.LENGTH_SHORT).show();
                        return true;
                }

                return false;
            }
        });

        ImageView schoolInfoImageView=(ImageView)findViewById(R.id.HP_school);
        ImageView cityInfoImageView=(ImageView)findViewById(R.id.HP_city);
        ImageView forumImageView=(ImageView)findViewById(R.id.HP_forum);
        ImageView newsEventsImageView=(ImageView)findViewById(R.id.HP_news);

        schoolInfoImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext()
                        , HochschuleGeneralActivity.class));
                overridePendingTransition(0,0);

            }
        });

        cityInfoImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext()
                        , UlmInformationActivity.class));
                overridePendingTransition(0,0);

            }
        });

        forumImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext()
                        , ForumActivity.class));
                overridePendingTransition(0,0);

            }
        });

        newsEventsImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this, "News and Events", Toast.LENGTH_SHORT).show();

            }
        });



    }
        private void latest_updates(){


        //recyclerview only loads the cards visible to user
        latest_updates.setHasFixedSize(true);
        latest_updates.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

            ArrayList<LatestUpdatesItems> latestUpdatesLocations = new ArrayList<>();

            latestUpdatesLocations.add(new LatestUpdatesItems(R.drawable.evenmorenews, "Tash laptop broke", "Tash fell on her ass because of the snow and her laptop broke."));
            latestUpdatesLocations.add(new LatestUpdatesItems(R.drawable.morenews, "Top 3 Restaurants", "Tash kitchen, Noodles with eggs"));
            latestUpdatesLocations.add(new LatestUpdatesItems(R.drawable.clubs, "Alpitish", "It's a thing"));
            latestUpdatesLocations.add(new LatestUpdatesItems(R.drawable.restaurants, "Covid and Restrictions ", "Covid"));

            adapter = new LatestUpdatesAdapter(latestUpdatesLocations);
            latest_updates.setAdapter(adapter);

        }
}
