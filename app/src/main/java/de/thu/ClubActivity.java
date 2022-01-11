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

        funRecView =findViewById(R.id.RecView);

        //Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        //TextView textView = (TextView)toolbar.findViewById(R.id.txt_toolbar);
        //textView.setText("Clubs");

        TextView title = findViewById(R.id.title);
        title.setText("Clubs");

        ArrayList<ClubItems> funitem = new ArrayList<>();
        funitem.add(new ClubItems("Rules" ,R.drawable.rulesclub, " Frauenstraße 29, 89073 Ulm"));
        funitem.add(new ClubItems("Theatro", R.drawable.theatroclub, "Hirschstraße 12/1, 89073 Ulm"));
        funitem.add(new ClubItems("Gleis44", R.drawable.gleis44club, "Schillerstraße 44, 89077 Ulm"));
        funitem.add(new ClubItems("Cabaret Club Eden", R.drawable.edenclub, "Karlstraße 71, 89073 Ulm"));
        funitem.add(new ClubItems("M-Club", R.drawable.mclub, "Lautenberg 1, 89073 Ulm"));

        ClubAdapter adapter=new ClubAdapter(this);
        adapter.setContacts(funitem);

        funRecView.setAdapter(adapter);
        funRecView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        //funRecView.setLayoutManager(new GridLayoutManager(this, 2));

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