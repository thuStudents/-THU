package de.thu;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class BarActivity extends AppCompatActivity {

    private RecyclerView barRecView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview);

        /**
         * instantiate the Bar recycle view with the corresponding ID
         */
        barRecView =findViewById(R.id.RecView);

        /**
         * Activity name displayed in the toolbar is set
         */
        TextView title = findViewById(R.id.title);
        title.setText("Bars");

        /**
         * We need to create an array list to contain all the Bars
         * For each bar the data is added manually
         * Each bar has a Name, address and icon
         */
        ArrayList<BarItems> barItems = new ArrayList<>();
        barItems.add(new BarItems("Big City Lounge", "Marktpl. 18, 89073 Ulm",R.drawable.bigcitylounge));
        barItems.add(new BarItems("X-Lounge", "Am Lederhof 1, 89073 Ulm",R.drawable.xlounge));
        barItems.add(new BarItems("Billbar", "Hans-und-Sophie-Scholl-Platz 1, 89073 Ulm",R.drawable.billbar));
        barItems.add(new BarItems("Kelly's Irish Pub", "Lautenberg 1, 89073 Ulm",R.drawable.kells));
        barItems.add(new BarItems("Sahara", "Glöcklerstraße 4, 89073 Ulm",R.drawable.sahara));
        barItems.add(new BarItems("Shibar", "Frauenstraße 23, 89073 Ulm",R.drawable.shibar));
        barItems.add(new BarItems("Sassy Shisha & Cocktail Bar", "Neue Str. 43, 89073 Ulm",R.drawable.sassy));

        /**
         * create adapter istance and set the data
         */
        BarAdapter adapter=new BarAdapter(this);
        adapter.setContacts(barItems);

        /**
         * set the adapter to the recycler view
         */
        barRecView.setAdapter(adapter);

        /**
         * set a Layout Manager for the Recycler View
         * pass a Linear Layout Manager which displayes the items in the recycler view in a Linear fashion
         * make the layout VERTICAL
         */
        barRecView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        /**
         * BOTTOM NAVIGATION
         * find the bottom navigation bar by ID and mark find as selected as if it was tapped.
         * set an on click listener for the three buttons of the BOTTOM NAV that starts the corresponding intent
         */
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.find);
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