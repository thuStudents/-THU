package de.thu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class HochschuleGeneralActivity extends AppCompatActivity {
    ListView hochschuleGeneralMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hochschule_general);
        hochschuleGeneralMenu = findViewById(R.id.hochschuleGeneralMenu);
        
        ArrayList<String> hsumenuGeneralList = new ArrayList<>();

        hsumenuGeneralList.add("Offered Courses");
        hsumenuGeneralList.add("Applying");
        hsumenuGeneralList.add("Fees");
        hsumenuGeneralList.add("Important Dates");
        hsumenuGeneralList.add("Offices");
        hsumenuGeneralList.add("Cafeteria & Mensa");
        hsumenuGeneralList.add("Subjects & Tips");
        hsumenuGeneralList.add("IT-Services & THU-Card");
        hsumenuGeneralList.add("Library");
        hsumenuGeneralList.add("Important Links");

        ArrayAdapter<String> hsumenuGeneralAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
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
                    case 2: // fees
                        intent = new Intent(HochschuleGeneralActivity.this, FeesActivity.class);
                        startActivity(intent);
                        break;
                    case 3: // important dates
                        intent = new Intent(HochschuleGeneralActivity.this, ImportantDatesActivity.class);
                        startActivity(intent);
                        break;
                    case 4: // offices
                        intent = new Intent(HochschuleGeneralActivity.this, OfficesActivity.class);
                        startActivity(intent);
                        break;
                    case 5: // Cafeteria & Mensa
                        intent = new Intent(HochschuleGeneralActivity.this, CafeteriaMensaActivity.class);
                        startActivity(intent);
                        break;
                    case 6: // Subjects & Tips
                        intent = new Intent(HochschuleGeneralActivity.this, SubjectsTipsActivity.class);
                        startActivity(intent);
                        break;
                    case 7: // IT-Services & THU-Card
                        intent = new Intent(HochschuleGeneralActivity.this, ServicesCardActivity.class);
                        startActivity(intent);
                        break;
                    case 8: // Library
                        intent = new Intent(HochschuleGeneralActivity.this, LibraryActivity.class);
                        startActivity(intent);
                        break;
//                    case 9: // Important Websites
//                        intent = new Intent(HochschuleInformationActivity.this, ImportantDatesActivity.class);
//                        startActivity(intent);
//                        break;
                    default:
                        break;
                }
            }
        });

    }
}