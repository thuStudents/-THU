package de.thu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class HochschuleInfoActivity extends AppCompatActivity {
    ListView hochschuleMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hochschule_info);
        hochschuleMenu = findViewById(R.id.hochschuleMenu);

        ArrayList<String> hsumenuList = new ArrayList<>();

        hsumenuList.add("THU");
        hsumenuList.add("My University");

        ArrayAdapter<String> hsumenuAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
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
//                        intent = new Intent(HochschuleInformationActivity.this, ApplyingActivity.class);
//                        startActivity(intent);
                        break;
                    default:
                        break;
                }
            }
        });
    }
}