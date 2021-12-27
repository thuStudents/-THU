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

public class HochschuleGeneralActivity extends AppCompatActivity {
    ListView hochschuleGeneralMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hochschule_general);
        hochschuleGeneralMenu = findViewById(R.id.hochschuleGeneralMenu);
        
        ArrayList<String> hsumenuGeneralList = new ArrayList<>();

        hsumenuGeneralList.add("Offered Courses✓");
        hsumenuGeneralList.add("Applying✓");
        hsumenuGeneralList.add("Offices✓");
        hsumenuGeneralList.add("Library✓");
        hsumenuGeneralList.add("Cafeteria & Mensa✓");

        ArrayAdapter<String> hsumenuGeneralAdapter = new ArrayAdapter<>(
                this,
                R.layout.list_element_layout,
                hsumenuGeneralList
        );

        hochschuleGeneralMenu.setAdapter(hsumenuGeneralAdapter);

        hochschuleGeneralMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent;
                switch(position){
                    case 0: // offered courses
                        intent = new Intent(HochschuleGeneralActivity.this, OfferedCoursesActivity.class);
                        startActivity(intent);
                        break;
                    case 1: // applying
                        intent = new Intent(HochschuleGeneralActivity.this, ApplyingActivity.class);
                        startActivity(intent);
                        break;
                    case 2: // offices
                        intent = new Intent(HochschuleGeneralActivity.this, OfficesActivity.class);
                        startActivity(intent);
                        break;
                    case 3: // Library
                        intent = new Intent(HochschuleGeneralActivity.this, LibraryActivity.class);
                        startActivity(intent);
                        break;
                    case 4: // Cafeteria & Mensa
                        intent = new Intent(HochschuleGeneralActivity.this, CafeteriaMensaActivity.class);
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