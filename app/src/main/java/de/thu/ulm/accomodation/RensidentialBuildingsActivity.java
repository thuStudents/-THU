package de.thu.ulm.accomodation;

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

import de.thu.HomeActivity;
import de.thu.PostActivity;
import de.thu.Profile;
import de.thu.R;
import de.thu.adapters.ResidentialBAdapter;

public class RensidentialBuildingsActivity extends AppCompatActivity {

    private RecyclerView resBRecView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview);

        resBRecView =findViewById(R.id.RecView);

        ArrayList<ResidentialBuildingsItems> res_elements = new ArrayList<>();
        res_elements.add(new ResidentialBuildingsItems("Gutenbergstraße", "th@email.com", R.drawable.gutenbergstr ));
        res_elements.add(new ResidentialBuildingsItems("Frauensteigestraße", "as@email.com", R.drawable.frauensteige));
        res_elements.add(new ResidentialBuildingsItems("Heidenheimerstraße 1", "rm@email.com",R.drawable.heidenheimer1));
        res_elements.add(new ResidentialBuildingsItems("Heidenheimerstraße 2", "rm@email.com",R.drawable.heidenheimer2));
        res_elements.add(new ResidentialBuildingsItems("Upper West Side", "rm@email.com",R.drawable.uppperwestside));

        ResidentialBAdapter adapter=new ResidentialBAdapter(this);
        adapter.setContacts(res_elements);

        resBRecView.setAdapter(adapter);
        //contactsRecView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        resBRecView.setLayoutManager(new GridLayoutManager(this, 2));



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