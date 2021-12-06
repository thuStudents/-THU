package de.thu;

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

public class HochschuleInfoActivity extends AppCompatActivity {
    ListView hochschuleMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hochschule_info);

        hochschuleMenu = findViewById(R.id.hochschuleMenu);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

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

        ArrayList<String> hsumenuList = new ArrayList<>();

        hsumenuList.add("My University");
        hsumenuList.add("My Studies");

        ArrayAdapter<String> hsumenuAdapter = new ArrayAdapter<>(
                this,
                R.layout.list_element_layout,
                hsumenuList
        );

        hochschuleMenu.setAdapter(hsumenuAdapter);

        hochschuleMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent;
                switch (position) {
                    case 0: // THU
                        intent = new Intent(HochschuleInfoActivity.this, HochschuleGeneralActivity.class);
                        startActivity(intent);
                        break;
                    case 1: // my uni
                        intent = new Intent(HochschuleInfoActivity.this, MyStudiesActivity.class);
                        startActivity(intent);
                        break;
                    default:
                        break;
                }
            }
        });


    }
}