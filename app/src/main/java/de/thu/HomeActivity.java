package de.thu;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
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
    Button login;
    //LinearLayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_homepage_activity);

        //hooks
        latest_updates=findViewById(R.id.latest_updates);
        login = findViewById(R.id.buttonLoginHomepage);

        if(WelcomeActivity.signedAsGuest){

            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(getApplicationContext()
                            , LoginActivity.class));
                    overridePendingTransition(0,0);
                }
            });
        } else {
            login.setVisibility(View.INVISIBLE);
        }


        latest_updates();

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
                        Toast.makeText(HomeActivity.this, "You are not Logged In", Toast.LENGTH_SHORT).show();
                        }
                        return true;
                    case R.id.add:
                        if(WelcomeActivity.signedAsGuest!=true){
                            startActivity(new Intent(getApplicationContext()
                                    , PostActivity.class));
                            overridePendingTransition(0,0);
                        } else {
                            Toast.makeText(HomeActivity.this, "You are not Logged In", Toast.LENGTH_SHORT).show();
                        }
                        return true;
                    case R.id.home:
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
                        , HochschuleInfoActivity.class));
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
                if(WelcomeActivity.signedAsGuest){
                    Toast.makeText(HomeActivity.this, "You are not Logged In", Toast.LENGTH_SHORT).show();
                }else {
                    startActivity(new Intent(getApplicationContext()
                            , ForumActivity.class));
                    overridePendingTransition(0,0);
                }
            }
        });

        newsEventsImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(WelcomeActivity.signedAsGuest){
                    Toast.makeText(HomeActivity.this, "You are not Logged In", Toast.LENGTH_SHORT).show();
                }else {
                    startActivity(new Intent(getApplicationContext()
                            , NewsEventActivity.class));
                    overridePendingTransition(0, 0);
                }
            }
        });



    }
        private void latest_updates(){


        //recyclerview only loads the cards visible to user
        latest_updates.setHasFixedSize(true);
        latest_updates.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

            ArrayList<LatestUpdatesItems> latestUpdatesLocations = new ArrayList<>();

            latestUpdatesLocations.add(new LatestUpdatesItems(R.drawable.morenews, "Top 3 Restaurants", "??????"));
            latestUpdatesLocations.add(new LatestUpdatesItems(R.drawable.clubs, "!!", "!!"));
            latestUpdatesLocations.add(new LatestUpdatesItems(R.drawable.restaurants, "Covid and Restrictions ", "Covid"));

            adapter = new LatestUpdatesAdapter(latestUpdatesLocations);
            latest_updates.setAdapter(adapter);

        }
}
