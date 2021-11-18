package de.thu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class OfferedCoursesActivity extends AppCompatActivity {
    ListView offeredCoursesMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offered_courses);

        offeredCoursesMenu = findViewById(R.id.offeredCoursesMenu);

        ArrayList<String> offeredCoursesList = new ArrayList<>();

        offeredCoursesList.add("Computer Science");
        offeredCoursesList.add("Energy Information Management");
        offeredCoursesList.add("Intelligent Systems");
        offeredCoursesList.add("International Energy Economics");
        offeredCoursesList.add("International Energy Management");
        offeredCoursesList.add("Systems Engineering and Management - International Program");


        ArrayAdapter<String> offeredCoursesAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                offeredCoursesList
        );

        offeredCoursesMenu.setAdapter(offeredCoursesAdapter);

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