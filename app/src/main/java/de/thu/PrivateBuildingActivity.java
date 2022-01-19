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

import de.thu.adapters.PrivateBAdapter;

public class PrivateBuildingActivity extends AppCompatActivity {

    private RecyclerView privateBRecView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview);

        TextView PR_title = (TextView)findViewById(R.id.title);
        PR_title.setText("Find your Private Room");

        privateBRecView =findViewById(R.id.RecView);

        /**
         * We need to create an array list to contain all the Private rooms
         * For each private room the data is added manually
         * Each Private room has a Name, price and icon and address
         */
        ArrayList<PrivateBItems> contacts = new ArrayList<>();
        contacts.add(new PrivateBItems("ILive Campus Village", R.drawable.ilive, "21 - 24 m2: € 510\n\n26 - 33 m2: € 590", "Von-Hünefeld-Straße 28 89231 Neu-Ulm"));
        contacts.add(new PrivateBItems("UniApart", R.drawable.uniapart, "22.5 m2: € 479\n\n33.5 m2: € 589", "Memminger Str. 33, 89231 Neu-Ulm"));
        contacts.add(new PrivateBItems("Links from Studierendenwerk", R.drawable.studierendenwerk, "", "DAILY UPDATED PRIVATE ROOM INDEX"));

        /**
         * create adapter istance and set the data
         */
        PrivateBAdapter adapter=new PrivateBAdapter(this);
        adapter.setContacts(contacts);

        /**
         * set the adapter to the recycler view
         */
        privateBRecView.setAdapter(adapter);
        /**
         * set a Layout Manager for the Recycler View
         * pass a Linear Layout Manager which displayes the items in the recycler view in a Linear fashion
         * make the layout VERTICAL
         */
        privateBRecView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        /**
         * BOTTOM NAVIGATION
         * find the bottom navigation bar by ID and mark find as selected as if it was tapped.
         */
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelected(false);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.find:
                        if (WelcomeActivity.signedAsGuest != true) {
                            startActivity(new Intent(getApplicationContext()
                                    , Profile.class));
                        } else {
                            Toast.makeText(PrivateBuildingActivity.this, "You are not Logged In", Toast.LENGTH_SHORT).show();
                        }
                        return true;
                    case R.id.add:
                        if (WelcomeActivity.signedAsGuest != true) {
                            startActivity(new Intent(getApplicationContext()
                                    , PostActivity.class));
                            overridePendingTransition(0, 0);
                        } else {
                            Toast.makeText(PrivateBuildingActivity.this, "You are not Logged In", Toast.LENGTH_SHORT).show();
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