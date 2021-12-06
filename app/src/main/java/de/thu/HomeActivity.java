package de.thu;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;
import android.view.View;
import android.view.View.OnClickListener;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.Timer;
import java.util.TimerTask;

public class HomeActivity extends AppCompatActivity {

    ImageView home, add, find;


    RecyclerView event_rec_view;
    AutoScrollAdapter autoScrollAdapter;
    LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_homepage);

        event_rec_view = findViewById(R.id.event_rec_view);
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

        ImageView schoolInfoImageView=(ImageView)findViewById(R.id.schoolInfoImageView);
        ImageView cityInfoImageView=(ImageView)findViewById(R.id.cityInfoImageView);
        ImageView forumImageView=(ImageView)findViewById(R.id.forumImageView);
        ImageView newsEventsImageView=(ImageView)findViewById(R.id.newsEventsImageView);

        schoolInfoImageView.setOnClickListener(new OnClickListener(){
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext()
                        , HochschuleInfoActivity.class));
                overridePendingTransition(0,0);

            }});

        cityInfoImageView.setOnClickListener(new OnClickListener(){
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext()
                        , UlmInformationActivity.class));
                overridePendingTransition(0,0);

            }});

        forumImageView.setOnClickListener(new OnClickListener(){
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext()
                        , ForumActivity.class));
                overridePendingTransition(0,0);

            }});

        newsEventsImageView.setOnClickListener(new OnClickListener(){
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext()
                        , NewsEventActivity.class));
                overridePendingTransition(0,0);

            }});
/*        cityInfoImageView.setOnClickListener(this);
        forumImageView.setOnClickListener(this);
        newsEventsImageView.setOnClickListener(this);*/

        setRV();

    }

    private void setRV() {
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        event_rec_view.setLayoutManager(layoutManager);
        autoScrollAdapter = new AutoScrollAdapter(this);
        event_rec_view.setAdapter(autoScrollAdapter);

        LinearSnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(event_rec_view);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if(layoutManager.findLastCompletelyVisibleItemPosition() < (autoScrollAdapter.getItemCount() - 1)){
                    layoutManager.smoothScrollToPosition(event_rec_view, new RecyclerView.State(), layoutManager.findLastCompletelyVisibleItemPosition() + 1);
                }else{
                    layoutManager.smoothScrollToPosition(event_rec_view, new RecyclerView.State(), 0);
                }
            }

        },0, 3000);

    }
}