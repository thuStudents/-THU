package de.thu.ulm.cafe;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

import de.thu.HomeActivity;
import de.thu.PostActivity;
import de.thu.Profile;
import de.thu.R;

public class CafeActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView cafe;
    ArrayList<CafeItems> cafeLocations = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cafe);

        cafe = findViewById(R.id.recycler_cafe);

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

        initData();
        initRecyclerView();


    }

    private void initData(){

        cafe.setHasFixedSize(true);

        cafeLocations.add(new CafeItems("Coffee Fellows", "Monday\nTuesday\nWednesday\nThursday\nFriday\nSaturday\nSunday", R.drawable.coffee_fellows, "Neue Str. 85, 89073 Ulm", "7:30am-9:00pm \n7:30am-9:00pm \n7:30am-9:00pm \n7:30am-9:00pm \n7:30am-9:00pm \n7:30am-9:00pm \n9:00am-9:00pm"));
        cafeLocations.add(new CafeItems("Starbucks", "Monday\nTuesday\nWednesday\nThursday\nFriday\nSaturday\nSunday", R.drawable.starbucks, "Münsterplatz 16, 89073 Ulm", "9:00am-9:00pm \n9:00am-9:00pm \n9:00am-9:00pm \n9:00am-9:00pm \n9:00am-9:00pm \n9:00am-9:00pm \n9:00am-9:00pm"));
        cafeLocations.add(new CafeItems("Cafe Largo", "Monday\nTuesday\nWednesday\nThursday\nFriday\nSaturday\nSunday", R.drawable.cafe_largo, "Breite G. 5, 89073 Ulm", "8:00am-1:00am \n8:00am-1:00am \n8:00am-1:00am \n8:00am-1:00am \n8:00am-1:00am \n8:00am-1:00am \nClosed"));
        cafeLocations.add(new CafeItems("Cafe Stella", "Monday\nTuesday\nWednesday\nThursday\nFriday\nSaturday\nSunday", R.drawable.cafe_stella, "Dreiköniggasse 11, 89073 Ulm", "9:00am-1:00am \n9:00am-1:00am \n9:00am-1:00am \n9:00am-1:00am \n9:00am-1:00am \n9:00am-1:00am \nClosed"));
        cafeLocations.add(new CafeItems("Confiserie Cafe Tröglen", "Monday\nTuesday\nWednesday\nThursday\nFriday\nSaturday\nSunday", R.drawable.cofiserie, " Münsterplatz 5, 89073 Ulm", "7:30am-9:00pm \n7:30am-9:00pm \n7:30am-9:00pm \n7:30am-9:00pm \n7:30am-9:00pm \n7:30am-9:00pm \nClosed"));

    }

    private void initRecyclerView(){
        adapter = new CafeAdapter(cafeLocations);
        cafe.setAdapter(adapter);

    }


}