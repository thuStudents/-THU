package de.thu.myStudies;

import androidx.annotation.NonNull;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import de.thu.HomeActivity;
import de.thu.profile.Profile;
import de.thu.R;
import de.thu.forum.PostActivity;

public class PrintingCreditActivity extends YouTubeBaseActivity {

    String api_key_recharge = "AIzaSyASoBKftbQKh1IWuEVQnuwXMfBbOJOz4hs";
    YouTubePlayerView ytPlayerPrintCredit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_printing_credit);

        /**
         * How to add printing credit to your card video
         * The video was recorded and edited by us.
         * Get reference to the view of video player
         * Here the youtube player is initialized using the api key.
         * Two methods are declared. Depending on initialization success one of them is called.
         * If the initialization was not successful, a toast message is shown to the user.
         * In case the initialization was successful, cueVideo method is called with the video id.
         * cueVideo method loads the specified video's thumbnail and prepares the player to play the video,
         * but does not download any of the video stream until play() is called.
         * play() is automatically called when the user plays the video.
         */
        ytPlayerPrintCredit = findViewById(R.id.ytPlayerPrintCreditCard);
        ytPlayerPrintCredit.initialize(api_key_recharge, new YouTubePlayer.OnInitializedListener() {
            @Override  //handle play and pause here
            public void onInitializationSuccess( YouTubePlayer.Provider provider,
                                                 YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.cueVideo("y1Brs4Ue5Wo");
            }
            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider,
                                                YouTubeInitializationResult youTubeInitializationResult) {
                Toast.makeText(getApplicationContext(), "Video Player Failed", Toast.LENGTH_SHORT).show();
            }
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
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