package de.thu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class MyStudiesActivity extends AppCompatActivity {
    ListView myStudiesMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_studies);
        myStudiesMenu = findViewById(R.id.myStudiesMenu);

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

        ArrayList<String> mystudiesmenuList = new ArrayList<>();

        mystudiesmenuList.add("Timetable");
        mystudiesmenuList.add("To-Do List");
        mystudiesmenuList.add("Calendar");
        mystudiesmenuList.add("Subjects   ??");


        ArrayAdapter<String> hsumenuAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                mystudiesmenuList
        );

        myStudiesMenu.setAdapter(hsumenuAdapter);

        myStudiesMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent;
                switch (position) {
                    case 0: // THU
//                        intent = new Intent(MyStudiesActivity.this, HochschuleGeneralActivity.class);
//                        startActivity(intent);
                        break;
                    case 1: // my to do
                        intent = new Intent(MyStudiesActivity.this, ToDoActivity.class);
                        startActivity(intent);
                        break;
                    default:
                        break;
                }
            }
        });

    }
}