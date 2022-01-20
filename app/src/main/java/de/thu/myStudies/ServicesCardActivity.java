package de.thu.myStudies;

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
import de.thu.R;
import de.thu.forum.PostActivity;
import de.thu.profile.Profile;

public class ServicesCardActivity extends AppCompatActivity {
    ListView servicesMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services_card);

        servicesMenu = findViewById(R.id.serivcesMenu);

        /**
         * Created an arraylist with strings.
         * Each list entry represents a subtopic.
         * Created an Array adapter which adapts the string array to the list view.
         * A specific layout is set for each array element.
         * onItemClickListener is set for the list.
         * Each list entry when clicked redirects the user to the corresponding activity.
         */

        ArrayList<String> servicesList = new ArrayList<>();

        servicesList.add("Connect to VPN");
        servicesList.add("Validate Student ID");
        servicesList.add("Recharge Student ID");
        servicesList.add("Printing Credit");
        servicesList.add("Printing");

        ArrayAdapter<String> servicesAdapter = new ArrayAdapter<>(
                this,
                R.layout.list_element_layout,
                servicesList
        );

        servicesMenu.setAdapter(servicesAdapter);

        servicesMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent;
                switch(position){
                    case 0:  //vpn
                        intent = new Intent(ServicesCardActivity.this, ConnectToVPN_Activity.class);
                        startActivity(intent);
                        break;
                    case 1: //validate
                        intent = new Intent(ServicesCardActivity.this, ValidateCardActivity.class);
                        startActivity(intent);
                        break;
                    case 2: //recharge
                        intent = new Intent(ServicesCardActivity.this, RechargeCardActivity.class);
                        startActivity(intent);
                        break;
                    case 3: //recharge print credit
                        intent = new Intent(ServicesCardActivity.this, PrintingCreditActivity.class);
                        startActivity(intent);
                        break;
                    case 4: //printing
                        intent = new Intent(ServicesCardActivity.this, PrintingActivity.class);
                        startActivity(intent);
                        break;
                    default:
                        break;
                }
            }
        });


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

    }


}