package de.thu;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

import de.thu.adapters.NightLifeAdapter;

public class NightLifeActivity extends AppCompatActivity {

    private RecyclerView nightRecView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_night);

        nightRecView =findViewById(R.id.night_recview);

        /**
         * We need to create an array list to contain all the Night Life activities
         * For each activity the data is added manually
         */
        ArrayList<NightLifeItems> nightitem = new ArrayList<>();
        nightitem.add(new NightLifeItems("Clubs", R.drawable.clubs));
        nightitem.add(new NightLifeItems("Bars", R.drawable.bars));
        nightitem.add(new NightLifeItems("Cinemas", R.drawable.cinemas));
        nightitem.add(new NightLifeItems("Restaurants", R.drawable.restaurants));

        /**
         * create adapter istance and set the data
         */
        NightLifeAdapter adapter=new NightLifeAdapter(this);
        adapter.setContacts(nightitem);

        /**
         * set the adapter to the recycler view
         */
        nightRecView.setAdapter(adapter);
        /**
         * set a Layout Manager for the Recycler View
         * pass a Grid Layout Manager which displayes the items in the recycler view in a Grid fashion
         */
        nightRecView.setLayoutManager(new GridLayoutManager(this, 2));

        /**
         * BOTTOM NAVIGATION
         * set an on click listener for the three buttons of the BOTTOM NAV that starts the corresponding intent
         */
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelected(false);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.find:
                        if (WelcomeActivity.signedAsGuest != true) {
                            startActivity(new Intent(getApplicationContext()
                                    , Profile.class));
                        } else {
                            Toast.makeText(NightLifeActivity.this, "You are not Logged In", Toast.LENGTH_SHORT).show();
                        }
                        return true;
                    case R.id.add:
                        if (WelcomeActivity.signedAsGuest != true) {
                            startActivity(new Intent(getApplicationContext()
                                    , PostActivity.class));
                            overridePendingTransition(0, 0);
                        } else {
                            Toast.makeText(NightLifeActivity.this, "You are not Logged In", Toast.LENGTH_SHORT).show();
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





    }
}