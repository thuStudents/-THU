package de.thu;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class CafeActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView cafe;
    /**
     * We need to create an array list to contain all the Cafes
     */
    ArrayList<CafeItems> cafeLocations = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cafe);

        /**
         * instantiate the Cafe recycle view with the corresponding ID
         */
        cafe = findViewById(R.id.recycler_cafe);

        /**
         * BOTTOM NAVIGATION
         * find the bottom navigation car by ID and mark home as selected as if it was tapped.
         * set an on click listener for the three buttons of the BOTTOM NAV BAR that starts the corresponding intent
         */
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
                            Toast.makeText(CafeActivity.this, "You are not Logged In", Toast.LENGTH_SHORT).show();
                        }
                        return true;
                    case R.id.add:
                        if(WelcomeActivity.signedAsGuest!=true){
                            startActivity(new Intent(getApplicationContext()
                                    , PostActivity.class));
                            overridePendingTransition(0,0);
                        } else {
                            Toast.makeText(CafeActivity.this, "You are not Logged In", Toast.LENGTH_SHORT).show();
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

        initData();
        initRecyclerView();


    }

    private void initData(){

        /**
         * setHasFixedSize to true when changing the contents of the adapter
         * does not change it's height or width
         */
        cafe.setHasFixedSize(true);

        /**
         * For each cafe the data is added manually
         * Each cafe has a Name, dayes of the week, address, opening hours to the corresponding week day and an icon
         */
        cafeLocations.add(new CafeItems("Coffee Fellows", "Monday\nTuesday\nWednesday\nThursday\nFriday\nSaturday\nSunday", R.drawable.coffee_fellows, "Neue Str. 85, 89073 Ulm", "7:30am-9:00pm \n7:30am-9:00pm \n7:30am-9:00pm \n7:30am-9:00pm \n7:30am-9:00pm \n7:30am-9:00pm \n9:00am-9:00pm"));
        cafeLocations.add(new CafeItems("Starbucks", "Monday\nTuesday\nWednesday\nThursday\nFriday\nSaturday\nSunday", R.drawable.starbucks, "Münsterplatz 16, 89073 Ulm", "9:00am-9:00pm \n9:00am-9:00pm \n9:00am-9:00pm \n9:00am-9:00pm \n9:00am-9:00pm \n9:00am-9:00pm \n9:00am-9:00pm"));
        cafeLocations.add(new CafeItems("Cafe Largo", "Monday\nTuesday\nWednesday\nThursday\nFriday\nSaturday\nSunday", R.drawable.cafe_largo, "Breite G. 5, 89073 Ulm", "8:00am-1:00am \n8:00am-1:00am \n8:00am-1:00am \n8:00am-1:00am \n8:00am-1:00am \n8:00am-1:00am \nClosed"));
        cafeLocations.add(new CafeItems("Cafe Stella", "Monday\nTuesday\nWednesday\nThursday\nFriday\nSaturday\nSunday", R.drawable.cafe_stella, "Dreiköniggasse 11, 89073 Ulm", "9:00am-1:00am \n9:00am-1:00am \n9:00am-1:00am \n9:00am-1:00am \n9:00am-1:00am \n9:00am-1:00am \nClosed"));
        cafeLocations.add(new CafeItems("Confiserie Cafe Tröglen", "Monday\nTuesday\nWednesday\nThursday\nFriday\nSaturday\nSunday", R.drawable.cofiserie, " Münsterplatz 5, 89073 Ulm", "7:30am-9:00pm \n7:30am-9:00pm \n7:30am-9:00pm \n7:30am-9:00pm \n7:30am-9:00pm \n7:30am-9:00pm \nClosed"));

    }

    private void initRecyclerView(){
        /**
         * create the Recycler view adapter and set the data
         */
        adapter = new CafeAdapter(cafeLocations);
        /**
         * set the adapter to the recycler view
         */
        cafe.setAdapter(adapter);

    }


}