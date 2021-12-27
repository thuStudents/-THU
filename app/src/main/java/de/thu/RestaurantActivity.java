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

public class RestaurantActivity extends AppCompatActivity {

    private RecyclerView restaurantRecView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview);

        restaurantRecView =findViewById(R.id.RecView);

        //Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        //TextView textView = (TextView)toolbar.findViewById(R.id.txt_toolbar);
        //textView.setText("Clubs");

        TextView title = findViewById(R.id.title);
        title.setText("Restaurants");

        ArrayList<RestaurantItems> restaurantItems = new ArrayList<>();

        restaurantItems.add(new RestaurantItems("Barfüßer die Hausbrauerei Ulm", "Marktpl. 18, 89073 Ulm", R.drawable.barfusser_ulm));
        restaurantItems.add(new RestaurantItems("Choclet", "Am Lederhof 1, 89073 Ulm", R.drawable.choclet));
        restaurantItems.add(new RestaurantItems("QMUH Ulm", "Hans-und-Sophie-Scholl-Platz 1, 89073 Ulm",R.drawable.citykebab));
        restaurantItems.add(new RestaurantItems("Buddha Kitchen", "Lautenberg 1, 89073 Ulm",R.drawable.buddhakitchen));
        restaurantItems.add(new RestaurantItems("City Kebab", "Glöcklerstraße 4, 89073 Ulm",R.drawable.qmuh));

        RestaurantAdapter adapter=new RestaurantAdapter(this);
        adapter.setContacts(restaurantItems);

        restaurantRecView.setAdapter(adapter);
        restaurantRecView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
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