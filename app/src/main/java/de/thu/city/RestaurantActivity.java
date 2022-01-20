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
import de.thu.R;
import de.thu.WelcomeActivity;
import de.thu.forum.PostActivity;
import de.thu.profile.Profile;

public class RestaurantActivity extends AppCompatActivity {

    private RecyclerView restaurantRecView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview);

        restaurantRecView =findViewById(R.id.RecView);

        TextView title = findViewById(R.id.title);
        title.setText("Restaurants");


        /**
         * We need to create an array list to contain all the Restaurants
         * For each Restaurant the data is added manually
         * Each Restaurant has a Name, address and icon
         */
        ArrayList<RestaurantItems> restaurantItems = new ArrayList<>();

        restaurantItems.add(new RestaurantItems("Barfüßer die Hausbrauerei Ulm", "Marktpl. 18, 89073 Ulm", R.drawable.barfusser_ulm));
        restaurantItems.add(new RestaurantItems("Choclet", "Am Lederhof 1, 89073 Ulm", R.drawable.choclet));
        restaurantItems.add(new RestaurantItems("QMUH Ulm", "Hans-und-Sophie-Scholl-Platz 1, 89073 Ulm",R.drawable.citykebab));
        restaurantItems.add(new RestaurantItems("Buddha Kitchen", "Lautenberg 1, 89073 Ulm",R.drawable.buddhakitchen));
        restaurantItems.add(new RestaurantItems("City Kebab", "Glöcklerstraße 4, 89073 Ulm",R.drawable.qmuh));

        /**
         * create adapter istance and set the data
         */
        RestaurantAdapter adapter=new RestaurantAdapter(this);
        adapter.setContacts(restaurantItems);

        /**
         * set the adapter to the recycler view
         */
        restaurantRecView.setAdapter(adapter);

        /**
         * set a Layout Manager for the Recycler View
         * pass a Linear Layout Manager which displayes the items in the recycler view in a Linear fashion
         * make the layout VERTICAL
         */
        restaurantRecView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

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
                            Toast.makeText(RestaurantActivity.this, "You are not Logged In", Toast.LENGTH_SHORT).show();
                        }
                        return true;
                    case R.id.add:
                        if (WelcomeActivity.signedAsGuest != true) {
                            startActivity(new Intent(getApplicationContext()
                                    , PostActivity.class));
                            overridePendingTransition(0, 0);
                        } else {
                            Toast.makeText(RestaurantActivity.this, "You are not Logged In", Toast.LENGTH_SHORT).show();
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