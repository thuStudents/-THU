package de.thu;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

import de.thu.HomeActivity;
import de.thu.PostActivity;
import de.thu.Profile;
import de.thu.R;
import de.thu.adapters.TransportAdapter;

public class TransportActivity extends AppCompatActivity {

    private RecyclerView transportBRecView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_transport);

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

        transportBRecView =findViewById(R.id.transport_recview);

        ArrayList<TransportItems> means = new ArrayList<>();
        means.add(new TransportItems("Buses and Trams", "Discover Ulm thanks to it's developed public transport system", R.drawable.bus));
        means.add(new TransportItems("Trains", "Take advantage of the connections to many destinations in and outside Germany", R.drawable.train));
        //means.add(new TransportItems("Trams", "Get to your destinations fast thanks to Ulms' tram system", R.drawable.tram));


        TransportAdapter adapter=new TransportAdapter(this);
        adapter.setContacts(means);

        transportBRecView.setAdapter(adapter);
        //transportBRecView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        transportBRecView.setLayoutManager(new GridLayoutManager(this, 2));
    }
}