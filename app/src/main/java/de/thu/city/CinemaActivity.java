package de.thu.city;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

import de.thu.HomeActivity;
import de.thu.forum.PostActivity;
import de.thu.profile.Profile;
import de.thu.R;
import de.thu.WelcomeActivity;

public class CinemaActivity extends AppCompatActivity {

    private RecyclerView cinemaRecView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview);

        /**
         * instantiate the Cinema recycle view with the corresponding ID
         */
        cinemaRecView =findViewById(R.id.RecView);

        /**
         * Activity name displayed in the toolbar is set
         */
        TextView title = findViewById(R.id.title);
        title.setText("Movies");

        /**
         * We need to create an array list to contain all the Cinemas
         * For each cinema the data is added manually
         * Each cinea has a Name, address and icon
         */
        ArrayList<CinemaItems> cinemaItems = new ArrayList<>();
        cinemaItems.add(new CinemaItems("Xinedome", "Am Lederhof 1, 89073 Ulm",R.drawable.xinedome));
        cinemaItems.add(new CinemaItems("Cineplex Dietrich", "Marlene-Dietrich-Straße 11, 89231 Neu-Ulm",R.drawable.cineplex));

        /**
         * create adapter istance and set the data
         */
        CinemaAdapter adapter=new CinemaAdapter(this);
        adapter.setContacts(cinemaItems);

        /**
         * set the adapter to the recycler view
         */
        cinemaRecView.setAdapter(adapter);
        /**
         * set a Layout Manager for the Recycler View
         * pass a Linear Layout Manager which displayes the items in the recycler view in a Linear fashion
         * make the layout VERTICAL
         */
        cinemaRecView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        /**
         * BOTTOM NAVIGATION
         * find the bottom navigation bar by ID and mark find as selected as if it was tapped.
         * set an on click listener for the three buttons of the BOTTOM NAV BAR that starts the corresponding intent
         */
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.find);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.find:
                        if(WelcomeActivity.signedAsGuest!=true){
                            startActivity(new Intent(getApplicationContext()
                                    , Profile.class));
                        } else {
                            Toast.makeText(CinemaActivity.this, "You are not Logged In", Toast.LENGTH_SHORT).show();
                        }
                        return true;
                    case R.id.add:
                        if(WelcomeActivity.signedAsGuest!=true){
                            startActivity(new Intent(getApplicationContext()
                                    , PostActivity.class));
                            overridePendingTransition(0,0);
                        } else {
                            Toast.makeText(CinemaActivity.this, "You are not Logged In", Toast.LENGTH_SHORT).show();
                        }
                        return true;
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext()
                                , HomeActivity.class));
                        overridePendingTransition(0,0);
                        return true;                }

                return false;
            }
        });

    }
}