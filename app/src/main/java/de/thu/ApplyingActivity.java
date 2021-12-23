package de.thu;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class ApplyingActivity extends YouTubeBaseActivity {

    String api_key = "AIzaSyCSOYp9m9btLTfCBHi6sZUblS3HG1wWLOM";
    YouTubePlayerView ytPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_applying);

        // Get reference to the view of Video player
        ytPlayer = findViewById(R.id.ytPlayerApplying);

        ytPlayer.initialize(api_key, new YouTubePlayer.OnInitializedListener() {
                  @Override  //handle play and pause here
                  public void onInitializationSuccess( YouTubePlayer.Provider provider,
                         YouTubePlayer youTubePlayer, boolean b) {
                             youTubePlayer.cueVideo("otST6JiexIQ");
                         }
                  @Override
                  public void onInitializationFailure(YouTubePlayer.Provider provider,
                                                      YouTubeInitializationResult youTubeInitializationResult) {
                      Toast.makeText(getApplicationContext(), "Video Player Failed", Toast.LENGTH_SHORT).show();
                  }
        });



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
    }

}