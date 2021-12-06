package de.thu;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

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


        initData();
        initRecyclerView();


    }



    private void initData() {

        bank.setHasFixedSize(true);

        bankLocations.add(new BankItems("Volksbank Ulm", "0731 1830", "volksbank_ulm@email.de", "Frauenstraße 60, 89073 Ulm", R.drawable.vr_bank));
        bankLocations.add(new BankItems("Volksbank Neu-Ulm", "0731 970030", "volksbank_neu_ulm@email.de", "Ludwigstraße 1, 89231 Neu-Ulm", R.drawable.vr_bank));
        bankLocations.add(new BankItems("Sparkasse Ulm", "This is my bank", "This duhwd dwuig wqudihw dwqudqh wduqh d", "some more text",R.drawable.gutenbergstr));
        bankLocations.add(new BankItems("Sparkasse Neu-Ulm", "This is my bank", "This duhwd dwuig wqudihw dwqudqh wduqh d", "some more text", R.drawable.common_google_signin_btn_icon_dark_focused));
        bankLocations.add(new BankItems("Postbank", "This is my bank", "This duhwd dwuig wqudihw dwqudqh wduqh d", "some more text", R.drawable.common_google_signin_btn_icon_dark_focused));
        bankLocations.add(new BankItems("Commerzbank", "This is my bank", "This duhwd dwuig wqudihw dwqudqh wduqh d", "some more text", R.drawable.common_google_signin_btn_icon_dark_focused));
        bankLocations.add(new BankItems("Deutsche Bank", "This is my bank", "This duhwd dwuig wqudihw dwqudqh wduqh d", "some more text", R.drawable.common_google_signin_btn_icon_dark_focused));
        bankLocations.add(new BankItems("HypoVereinsbank", "This is my bank", "This duhwd dwuig wqudihw dwqudqh wduqh d", "some more text", R.drawable.common_google_signin_btn_icon_dark_focused));

    }

    private void initRecyclerView() {
        adapter = new BankAdapter(bankLocations);
        bank.setAdapter(adapter);

    }
}