package de.thu;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class BankingActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView bank;
    ArrayList<BankItems> bankLocations = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banking);

        bank = findViewById(R.id.recycler_bank);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.home);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.find:
                        if(WelcomeActivity.signedAsGuest!=true){
                            startActivity(new Intent(getApplicationContext()
                                    , Profile.class));
                        } else {
                            Toast.makeText(BankingActivity.this, "You are not Logged In", Toast.LENGTH_SHORT).show();
                        }
                        return true;
                    case R.id.add:
                        if(WelcomeActivity.signedAsGuest!=true){
                            startActivity(new Intent(getApplicationContext()
                                    , PostActivity.class));
                            overridePendingTransition(0,0);
                        } else {
                            Toast.makeText(BankingActivity.this, "You are not Logged In", Toast.LENGTH_SHORT).show();
                        }
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


        initData();
        initRecyclerView();


    }



    private void initData() {

        bank.setHasFixedSize(true);

        bankLocations.add(new BankItems("Volksbank Ulm", "0731 1830", "volksbank_ulm@email.de", "Frauenstraße 60, 89073 Ulm", R.drawable.vr_bank));
        bankLocations.add(new BankItems("Volksbank Neu-Ulm", "0731 970030", "volksbank_neu_ulm@email.de", "Ludwigstraße 1, 89231 Neu-Ulm", R.drawable.vr_bank));
        bankLocations.add(new BankItems("Sparkasse Ulm", "0128 746353", "sparkasse_ulm@email.de", "Hauptstraße 2, 89071 Ulm",R.drawable.sparkasse));
        bankLocations.add(new BankItems("Sparkasse Neu-Ulm", "0364 743733", "sparkasse_neu_ulm@thu.de", "Schulstraße 7, 89231 Neu-Ulm", R.drawable.sparkasse));
        bankLocations.add(new BankItems("Postbank", "0645 749658", "postbank@email.de", "Dorfstraße 43, 89073 Ulm", R.drawable.postbank));
        bankLocations.add(new BankItems("Commerzbank", "0745 836386", "commerzbank@email.de", "Gartenstraße 6, 89072 Ulm", R.drawable.commerzbank));
        bankLocations.add(new BankItems("Deutsche Bank", "0364 374538", "deutsche_bank@email.de", "Bahnhofstraße 8, 89073 Ulm", R.drawable.deutschebank));

    }

    private void initRecyclerView() {
        adapter = new BankAdapter(bankLocations);
        bank.setAdapter(adapter);

    }
}