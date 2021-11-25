package de.thu;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class NightLifeActivity extends AppCompatActivity {

    private RecyclerView nightRecView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview);

        nightRecView =findViewById(R.id.RecView);


        /*
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        TextView textView = (TextView)toolbar.findViewById(R.id.txt_toolbar);
        textView.setText("The Fun Part");

         */

        ArrayList<NightLifeItems> nightitem = new ArrayList<>();
        nightitem.add(new NightLifeItems("Clubs", "Go clubbing its cool", R.drawable.clubs));
        nightitem.add(new NightLifeItems("Bars", "Also Bars are cool", R.drawable.bars));
        nightitem.add(new NightLifeItems("Cinemas", "Also Cinemas are cool", R.drawable.cinemas));
        nightitem.add(new NightLifeItems("Restaurants", "Also Restaurants are cool", R.drawable.restaurants));


        NightLifeAdapter adapter=new NightLifeAdapter(this);
        adapter.setContacts(nightitem);

        nightRecView.setAdapter(adapter);
        nightRecView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        //nightRecView.setLayoutManager(new LinearLayoutManager(this));

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