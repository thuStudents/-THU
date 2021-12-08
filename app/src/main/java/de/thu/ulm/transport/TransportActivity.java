package de.thu.ulm.transport;

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
        means.add(new TransportItems("Semester Tickets", "All students from THU can buy a semester ticket.\n\nYou will have to present your student ID or certificate of enrollment when purchasing. \n\nThe ticket costs 133.00€ per semester. \n \nSemester tickets are issued for the following periods: \nSummer semester: March 1st to August 31st \nWinter semester: September 1st to September 28th / 29th February \n \nThe tickets are available at: \nTicket office at the Prittwitzstraße cafeteria \nSWU Offices \nHabtbahnhof Ulm", R.drawable.semestertickets));
        means.add(new TransportItems("Offers for students without a semester ticket", "From 6 p.m. and all day on weekends students can travel for free. \n\nFree travel between Uni Süd and THU stops. \n\nStudents living in Ulm can receive one free semester ticket by presenting their residence certificate at SWU. ", R.drawable.nosemesterticket));
        means.add(new TransportItems("Night Buses", "Night buses run in Ulm and Neu-Ulm on the nights before Saturday and Sunday and public holidays.\n\nThese buses are free for students on presentation of their student ID.", R.drawable.bus));

        TransportAdapter adapter=new TransportAdapter(this);
        adapter.setContacts(means);

        transportBRecView.setAdapter(adapter);
        transportBRecView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        //transportBRecView.setLayoutManager(new GridLayoutManager(this, 2));
    }
}