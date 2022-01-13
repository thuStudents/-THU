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

import de.thu.adapters.PrivateBAdapter;

public class PrivateBuildingActivity extends AppCompatActivity {

    private RecyclerView privateBRecView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview);


        //Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        TextView PR_title = (TextView)findViewById(R.id.title);
        PR_title.setText("Find your Private Room");



        privateBRecView =findViewById(R.id.RecView);

        ArrayList<PrivateBItems> contacts = new ArrayList<>();
        contacts.add(new PrivateBItems("ILive Campus Village", R.drawable.ilive, "21 - 24 m2: € 510\n\n26 - 33 m2: € 590", "Von-Hünefeld-Straße 28 89231 Neu-Ulm"));
        contacts.add(new PrivateBItems("UniApart", R.drawable.uniapart, "22.5 m2: € 479\n\n33.5 m2: € 589", "Memminger Str. 33, 89231 Neu-Ulm"));
        contacts.add(new PrivateBItems("Links from Studierendenwerk", R.drawable.studierendenwerk, "", "DAILY UPDATED PRIVATE ROOM INDEX"));

        PrivateBAdapter adapter=new PrivateBAdapter(this);
        adapter.setContacts(contacts);

        privateBRecView.setAdapter(adapter);
        privateBRecView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

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