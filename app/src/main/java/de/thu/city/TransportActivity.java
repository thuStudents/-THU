package de.thu.city;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

import de.thu.HomeActivity;
import de.thu.R;
import de.thu.WelcomeActivity;
import de.thu.city.adapters.TransportAdapter;
import de.thu.forum.PostActivity;
import de.thu.profile.Profile;

public class TransportActivity extends AppCompatActivity {

    private RecyclerView transportBRecView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_transport);

        /**
         * BOTTOM NAVIGATION
         * set an on click listener for the three buttons of the BOTTOM NAV that starts the corresponding intent
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
                            Toast.makeText(TransportActivity.this, "You are not Logged In", Toast.LENGTH_SHORT).show();
                        }
                        return true;
                    case R.id.add:
                        if (WelcomeActivity.signedAsGuest != true) {
                            startActivity(new Intent(getApplicationContext()
                                    , PostActivity.class));
                            overridePendingTransition(0, 0);
                        } else {
                            Toast.makeText(TransportActivity.this, "You are not Logged In", Toast.LENGTH_SHORT).show();
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
        transportBRecView =findViewById(R.id.transport_recview);

        /**
         * We need to create an array list to contain all the Transport post
         * For each post the data is added manually
         * Each post has a Title, description and icon
         */
        ArrayList<TransportItems> means = new ArrayList<>();
        means.add(new TransportItems("Time-Tables", "Discover the city thanks to the DING local public transport", R.drawable.ding));
        means.add(new TransportItems("Semester Tickets", "All students from THU can buy a semester ticket.\n\nYou will have to present your student ID or certificate of enrollment when purchasing. \n\nThe ticket costs 133.00??? per semester. \n \nSemester tickets are issued for the following periods: \nSummer semester: March 1st to August 31st \nWinter semester: September 1st to September 28th / 29th February \n \nThe tickets are available at: \nTicket office at the Prittwitzstra??e cafeteria \nSWU Offices \nHabtbahnhof Ulm", R.drawable.semestertickets));
        means.add(new TransportItems("Offers for students without a semester ticket", "From 6 p.m. and all day on weekends students can travel for free. \n\nFree travel between Uni S??d and THU stops. \n\nStudents living in Ulm can receive one free semester ticket by presenting their residence certificate at SWU. ", R.drawable.nosemesterticket));
        means.add(new TransportItems("Night Buses", "Night buses run in Ulm and Neu-Ulm on the nights before Saturday and Sunday and public holidays.\n\nThese buses are free for students on presentation of their student ID.", R.drawable.bus));

        /**
         * create adapter istance and set the data
         */
        TransportAdapter adapter=new TransportAdapter(this);
        adapter.setContacts(means);

        /**
         * set the adapter to the recycler view
         */
        transportBRecView.setAdapter(adapter);
        /**
         * set a Layout Manager for the Recycler View
         * pass a Linear Layout Manager which displayes the items in the recycler view in a Linear fashion
         * make the layout VERTICAL
         */
        transportBRecView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }
}