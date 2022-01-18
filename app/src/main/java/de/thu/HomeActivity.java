package de.thu;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
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

    BottomNavigationView bottomNavigationView;
    AutoScrollAdapter autoScrollAdapter;
    RecyclerView latest_updates;
    LinearLayoutManager layoutManager;
    LinearLayout forumBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_homepage_activity);

        /**
         * instantiate view for image slideshow
         */
        latest_updates=findViewById(R.id.latest_updates);
        latest_updates();

        /**
         * BOTTOM NAVIGATION
         * find the bottom navigation bar by ID and mark find as selected as if it was tapped.
         * set an on click listener for the three buttons of the BOTTOM NAV that starts the corresponding intent
         */
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

        /**
         * istantiate the five buttons
         * set an on Click Listener for each wich will start the corresponding Intent
         */
        ImageView schoolInfoImageView= findViewById(R.id.HP_school);
        ImageView cityInfoImageView= findViewById(R.id.HP_city);
        ImageView forumImageView= findViewById(R.id.HP_Forum);
        ImageView newsEventsImageView= findViewById(R.id.HP_news);
        ImageView myStudiesImageView = findViewById(R.id.HP_my_studies);
        forumBtn = findViewById(R.id.ll_forum);

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

        newsEventsImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext()
                        , NewsEventActivity.class));
                overridePendingTransition(0,0);
            }
        });

        myStudiesImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext()
                        , MyStudiesActivity.class));
                overridePendingTransition(0,0);
            }
        });
    }

    /**
     * set the AutoScroll Adapter
      */
    private void latest_updates(){

        /**
         * set a Layout Manager for the Recycler View
         * pass a Linear Layout Manager which displayes the items in the recycler view in a Linear fashion
         * make the layout HORIZONTAL
         */
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        latest_updates.setLayoutManager(layoutManager);

        /**
         * create adapter istance
         */
        autoScrollAdapter = new AutoScrollAdapter(this);

        /**
         * set the adapter to the recycler view
         */
        latest_updates.setAdapter(autoScrollAdapter);

        /**
         * snapping any child view of the RecyclerView.
         */
        LinearSnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(latest_updates);

        /**
         * create a new Timer
         */
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            /**
             *
             */
            public void run() {
                /**
                 * findLastCompletelyVisibleItemPosition() gives the position of the last element loaded in the RecyclerView
                 * if it still hasn't reached the end display the next image
                 * if it's reached the end display the first picture again
                 * the scroll occurs every 3 seconds
                 */
                if (layoutManager.findLastCompletelyVisibleItemPosition() < (autoScrollAdapter.getItemCount() -1)){
                    layoutManager.smoothScrollToPosition(latest_updates, new RecyclerView.State(), layoutManager.findLastCompletelyVisibleItemPosition()+1);
                    } else
                        layoutManager.smoothScrollToPosition(latest_updates, new RecyclerView.State(), 0);
                    }
            },0,3000);

        }
}
