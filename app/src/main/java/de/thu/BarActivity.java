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

        barRecView =findViewById(R.id.RecView);

        //Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        //TextView textView = (TextView)toolbar.findViewById(R.id.txt_toolbar);
        //textView.setText("Clubs");

        TextView title = findViewById(R.id.title);
        title.setText("Bars");

        ArrayList<BarItems> barItems = new ArrayList<>();
        barItems.add(new BarItems("Big City Lounge", "Marktpl. 18, 89073 Ulm",R.drawable.bigcitylounge));
        barItems.add(new BarItems("X-Lounge", "Am Lederhof 1, 89073 Ulm",R.drawable.xlounge));
        barItems.add(new BarItems("Billbar", "Hans-und-Sophie-Scholl-Platz 1, 89073 Ulm",R.drawable.billbar));
        barItems.add(new BarItems("Kelly's Irish Pub", "Lautenberg 1, 89073 Ulm",R.drawable.kells));
        barItems.add(new BarItems("Sahara", "Glöcklerstraße 4, 89073 Ulm",R.drawable.sahara));
        barItems.add(new BarItems("Shibar", "Frauenstraße 23, 89073 Ulm",R.drawable.shibar));
        barItems.add(new BarItems("Sassy Shisha & Cocktail Bar", "Neue Str. 43, 89073 Ulm",R.drawable.sassy));

        BarAdapter adapter=new BarAdapter(this);
        adapter.setContacts(barItems);

        barRecView.setAdapter(adapter);
        barRecView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        //funRecView.setLayoutManager(new GridLayoutManager(this, 2));

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