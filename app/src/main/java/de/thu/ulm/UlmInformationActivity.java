package de.thu.ulm;

import static android.R.layout.simple_list_item_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

import de.thu.HomeActivity;
import de.thu.PostActivity;
import de.thu.Profile;
import de.thu.R;
import de.thu.ulm.accomodation.AccommodationActivity;
import de.thu.ulm.banking.BankingActivity;
import de.thu.ulm.cafe.CafeActivity;
import de.thu.ulm.legal.LegalAdviceActivity;
import de.thu.ulm.map.CityMapActivity;
import de.thu.ulm.market.MarketsActivity;
import de.thu.ulm.night.NightLifeActivity;
import de.thu.ulm.transport.TransportActivity;

public class UlmInformationActivity extends AppCompatActivity {
    ListView ulmMenu;
    BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ulm_information);
        ulmMenu = findViewById(R.id.ulmInfoMenu);

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
                simple_list_item_1,
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