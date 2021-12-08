package de.thu;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

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

        cafeLocations.add(new CafeItems("Coffee Fellows", "56", R.drawable.residences));
        cafeLocations.add(new CafeItems("Starbucks", "6535", R.drawable.restaurants));
        cafeLocations.add(new CafeItems("Cafe Largo", "423756239562938", R.drawable.cinemas));
        cafeLocations.add(new CafeItems("Cafe Stella", "423756239562938", R.drawable.cinemas));
        cafeLocations.add(new CafeItems("Confiserie Cafe Tröglen", "423756239562938", R.drawable.cinemas));

    }

    private void initRecyclerView(){
        adapter = new CafeAdapter(cafeLocations);
        cafe.setAdapter(adapter);

    }


}