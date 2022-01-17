package de.thu;

import static android.R.layout.simple_list_item_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class UlmInformationActivity extends AppCompatActivity {
    ListView ulmMenu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ulm_information);
        ulmMenu = findViewById(R.id.ulmInfoMenu);

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
                            Toast.makeText(UlmInformationActivity.this, "You are not Logged In", Toast.LENGTH_SHORT).show();
                        }
                        return true;
                    case R.id.add:
                        if (WelcomeActivity.signedAsGuest != true) {
                            startActivity(new Intent(getApplicationContext()
                                    , PostActivity.class));
                            overridePendingTransition(0, 0);
                        } else {
                            Toast.makeText(UlmInformationActivity.this, "You are not Logged In", Toast.LENGTH_SHORT).show();
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

        ArrayList<String> ulmMenuList = new ArrayList<>();
        ulmMenuList.add("Accommodation");
        ulmMenuList.add("Banking");
        ulmMenuList.add("City Map");
        ulmMenuList.add("Legal Advice");
        ulmMenuList.add("Transport");
        ulmMenuList.add("Markets");
        ulmMenuList.add("Café");
        ulmMenuList.add("The Fun Part");

        ArrayAdapter<String> ulmMenuAdapter = new ArrayAdapter<>(
                this,
                R.layout.list_element_layout,
                ulmMenuList
        );

        ulmMenu.setAdapter(ulmMenuAdapter);

        ulmMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent;
                switch(position){
                    case 0: // Accommodation
                        intent = new Intent(UlmInformationActivity.this, AccommodationActivity.class);
                        startActivity(intent);
                        break;
                    case 1: // Banking
                        intent = new Intent(UlmInformationActivity.this, BankingActivity.class);
                        startActivity(intent);
                        break;
                    case 2: // City Map
                        intent = new Intent(UlmInformationActivity.this, CityMapActivity.class);
                        startActivity(intent);
                        break;
                    case 3: // Legal Advice
                        intent = new Intent(UlmInformationActivity.this, LegalAdviceActivity.class);
                        startActivity(intent);
                        break;
                    case 4: // Transport
                        intent = new Intent(UlmInformationActivity.this, TransportActivity.class);
                        startActivity(intent);
                        break;
                    case 5: // Markets
                        intent = new Intent(UlmInformationActivity.this, MarketsActivity.class);
                        startActivity(intent);
                        break;
                    case 6: // Café
                        intent = new Intent(UlmInformationActivity.this, CafeActivity.class);
                        startActivity(intent);
                        break;
                    case 7: // Night Life
                        intent = new Intent(UlmInformationActivity.this, NightLifeActivity.class);
                        startActivity(intent);
                        break;
                    default:
                        break;
                }
            }
        });
    }
}