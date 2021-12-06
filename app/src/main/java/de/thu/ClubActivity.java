package de.thu;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

import de.thu.adapters.ClubAdapter;

public class ClubActivity extends AppCompatActivity {

    private RecyclerView funRecView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview);

        funRecView =findViewById(R.id.RecView);

        //Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        //TextView textView = (TextView)toolbar.findViewById(R.id.txt_toolbar);
        //textView.setText("Clubs");

        ArrayList<ClubItems> funitem = new ArrayList<>();
        funitem.add(new ClubItems("Rules", "this place is cool", R.drawable.rulesclub));
        funitem.add(new ClubItems("Theatro", "this place is cool", R.drawable.theatroclub));
        funitem.add(new ClubItems("Gleis44", "this place is cool", R.drawable.gleis44club));
        funitem.add(new ClubItems("Cabaret Club Eden", "this place is cool", R.drawable.edenclub));
        funitem.add(new ClubItems("M-Club", "this place is cool", R.drawable.mclub));

        ClubAdapter adapter=new ClubAdapter(this);
//        adapter.setContacts(funitem);

        funRecView.setAdapter(adapter);
        //contactsRecView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        funRecView.setLayoutManager(new GridLayoutManager(this, 2));

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.find);


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