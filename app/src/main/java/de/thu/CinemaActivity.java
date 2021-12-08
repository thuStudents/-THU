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

public class CinemaActivity extends AppCompatActivity {

    private RecyclerView cinemaRecView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview);

        cinemaRecView =findViewById(R.id.RecView);

        //Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        //TextView textView = (TextView)toolbar.findViewById(R.id.txt_toolbar);
        //textView.setText("Clubs");

        TextView title = findViewById(R.id.title);
        title.setText("Movies");

        ArrayList<CinemaItems> cinemaItems = new ArrayList<>();
        cinemaItems.add(new CinemaItems("Xinedome", "Am Lederhof 1, 89073 Ulm",R.drawable.rulesclub));
        cinemaItems.add(new CinemaItems("Cineplex Dietrich", "Marlene-Dietrich-Straße 11, 89231 Neu-Ulm",R.drawable.rulesclub));

        CinemaAdapter adapter=new CinemaAdapter(this);
        adapter.setContacts(cinemaItems);

        cinemaRecView.setAdapter(adapter);
        cinemaRecView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
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