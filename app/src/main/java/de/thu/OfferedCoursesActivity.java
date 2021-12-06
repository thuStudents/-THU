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
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class OfferedCoursesActivity extends AppCompatActivity {
    ListView offeredCoursesMenu;
    TextView computerScienceText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offered_courses);

//        offeredCoursesMenu = findViewById(R.id.offeredCoursesMenu);
//
//        ArrayList<String> offeredCoursesList = new ArrayList<>();
//
//        offeredCoursesList.add("Computer Science");
//        offeredCoursesList.add("Energy Information Management");
//        offeredCoursesList.add("Intelligent Systems");
//        offeredCoursesList.add("International Energy Economics");
//        offeredCoursesList.add("International Energy Management");
//        offeredCoursesList.add("Systems Engineering and Management - International Program");
//
//
//        ArrayAdapter<String> offeredCoursesAdapter = new ArrayAdapter<>(
//                this,
//                android.R.layout.simple_list_item_1,
//                offeredCoursesList
//        );
//
//        offeredCoursesMenu.setAdapter(offeredCoursesAdapter);

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

//        offeredCoursesMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                switch (position) {
//                    case 0:
//                        break;
//                    default:
//                        break;
//                }
//            }
//        });

    }
}