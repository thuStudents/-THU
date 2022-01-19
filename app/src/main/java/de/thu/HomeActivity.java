package de.thu;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.Timer;
import java.util.TimerTask;

import de.thu.adapters.AutoScrollAdapter;

public class HomeActivity extends AppCompatActivity {

    RelativeLayout login;

    BottomNavigationView bottomNavigationView;

    AutoScrollAdapter autoScrollAdapter;
    RecyclerView latest_updates;
    LinearLayoutManager layoutManager;
    LinearLayout forumBtn;
    RelativeLayout school, mystudies, news,city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_homepage_activity);

        login = findViewById(R.id.buttonLoginHomepage);

        latest_updates=findViewById(R.id.latest_updates);
        latest_updates();
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.find:
                        if (WelcomeActivity.signedAsGuest != true) {
                            startActivity(new Intent(getApplicationContext()
                                    , Profile.class));
                        } else {
                            Toast.makeText(HomeActivity.this, "You are not Logged In", Toast.LENGTH_SHORT).show();
                        }
                        return true;
                    case R.id.add:
                        if (WelcomeActivity.signedAsGuest != true) {
                            startActivity(new Intent(getApplicationContext()
                                    , PostActivity.class));
                            overridePendingTransition(0, 0);
                        } else {
                            Toast.makeText(HomeActivity.this, "You are not Logged In", Toast.LENGTH_SHORT).show();
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

         school = findViewById(R.id.hochschuleBtn);
         city = findViewById(R.id.cityBtn);
         news = findViewById(R.id.newsBtn);
         mystudies = findViewById(R.id.mystudiesBtn);
         forumBtn = findViewById(R.id.forumButton);

        /**
         * The log in button is shown only if the user continued as guest.
         * First is checked if the user is a guest and it handles the button click.
         * Then if the user is not a guest, it hides the log in button
         */
        if(WelcomeActivity.signedAsGuest){
            forumBtn.setBackgroundResource(R.drawable.card_grey);
            mystudies.setBackgroundResource(R.drawable.card_grey);
            news.setBackgroundResource(R.drawable.card_grey);
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
            forumBtn.setBackgroundResource(R.drawable.card_2);
            mystudies.setBackgroundResource(R.drawable.card_2);
            news.setBackgroundResource(R.drawable.card_2);

        }

        school.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext()
                        , HochschuleGeneralActivity.class));
                overridePendingTransition(0,0);

            }
        });

        city.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext()
                        , UlmInformationActivity.class));
                overridePendingTransition(0,0);

            }
        });

        forumBtn.setOnClickListener(new View.OnClickListener() {
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

        news.setOnClickListener(new View.OnClickListener() {
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

        mystudies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(WelcomeActivity.signedAsGuest){
                    Toast.makeText(HomeActivity.this, "You are not Logged In", Toast.LENGTH_SHORT).show();
                }else {
                    startActivity(new Intent(getApplicationContext()
                            , MyStudiesActivity.class));
                    overridePendingTransition(0,0);
                }
            }
        });

    }
        private void latest_updates(){

        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        latest_updates.setLayoutManager(layoutManager);
        autoScrollAdapter = new AutoScrollAdapter(this);
        latest_updates.setAdapter(autoScrollAdapter);
         LinearSnapHelper snapHelper = new LinearSnapHelper();
         snapHelper.attachToRecyclerView(latest_updates);

            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    if (layoutManager.findLastCompletelyVisibleItemPosition() < (autoScrollAdapter.getItemCount() -1)){
                        layoutManager.smoothScrollToPosition(latest_updates, new RecyclerView.State(), layoutManager.findLastCompletelyVisibleItemPosition()+1);
                    } else
                        layoutManager.smoothScrollToPosition(latest_updates, new RecyclerView.State(), 0);
                    }
            },0,3000);

        }
}
