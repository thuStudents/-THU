package de.thu;

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

import de.thu.adapters.ClubAdapter;

public class ClubActivity extends AppCompatActivity {

    private RecyclerView funRecView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview);

        /**
         * instantiate the Club recycle view with the corresponding ID
         */
        funRecView =findViewById(R.id.RecView);

        /**
         * Activity name displayed in the toolbar is set
         */
        TextView title = findViewById(R.id.title);
        title.setText("Clubs");

        /**
         * We need to create an array list to contain all the Clubs
         * For each club the data is added manually
         * Each club has a Name, address and icon
         */
        ArrayList<ClubItems> funitem = new ArrayList<>();
        funitem.add(new ClubItems("Rules" ,R.drawable.rulesclub, " Frauenstraße 29, 89073 Ulm"));
        funitem.add(new ClubItems("Theatro", R.drawable.theatroclub, "Hirschstraße 12/1, 89073 Ulm"));
        funitem.add(new ClubItems("Gleis44", R.drawable.gleis44club, "Schillerstraße 44, 89077 Ulm"));
        funitem.add(new ClubItems("Cabaret Club Eden", R.drawable.edenclub, "Karlstraße 71, 89073 Ulm"));
        funitem.add(new ClubItems("M-Club", R.drawable.mclub, "Lautenberg 1, 89073 Ulm"));

        /**
         * create adapter istance and set the data
         */
        ClubAdapter adapter=new ClubAdapter(this);
        adapter.setContacts(funitem);

        /**
         * set the adapter to the recycler view
         */
        funRecView.setAdapter(adapter);
        /**
         * set a Layout Manager for the Recycler View
         * pass a Linear Layout Manager which displayes the items in the recycler view in a Linear fashion
         * make the layout VERTICAL
         */
        funRecView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

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
                switch (item.getItemId()) {
                    case R.id.find:
                        if (WelcomeActivity.signedAsGuest != true) {
                            startActivity(new Intent(getApplicationContext()
                                    , Profile.class));
                        } else {
                            Toast.makeText(ClubActivity.this, "You are not Logged In", Toast.LENGTH_SHORT).show();
                        }
                        return true;
                    case R.id.add:
                        if (WelcomeActivity.signedAsGuest != true) {
                            startActivity(new Intent(getApplicationContext()
                                    , PostActivity.class));
                            overridePendingTransition(0, 0);
                        } else {
                            Toast.makeText(ClubActivity.this, "You are not Logged In", Toast.LENGTH_SHORT).show();
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