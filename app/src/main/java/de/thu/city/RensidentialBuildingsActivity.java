package de.thu.city;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

import de.thu.HomeActivity;
import de.thu.R;
import de.thu.city.adapters.ResidentialBAdapter;
import de.thu.forum.PostActivity;
import de.thu.profile.Profile;

public class RensidentialBuildingsActivity extends AppCompatActivity {

    private RecyclerView resBRecView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview);

        resBRecView =findViewById(R.id.RecView);

        ArrayList<ResidentialBuildingsItems> res_elements = new ArrayList<>();
        res_elements.add(new ResidentialBuildingsItems("Gutenbergstraße", R.drawable.gutenbergstr, "4 and 6 person flat share: € 322\n\n9 person flat share (private bathroom): €362", "Gutenbergstraße 6, 89073 Ulm"));
        res_elements.add(new ResidentialBuildingsItems("Frauensteigestraße", R.drawable.frauensteige, "2 person flat share: € 296", "Frauensteige 2, 89075 Ulm"));
        res_elements.add(new ResidentialBuildingsItems("Heidenheimerstraße (Hause 1)", R.drawable.heidenheimer1, "18 person flat share: € 241", "Heidenheimer Str. 78, 89075 Ulm"));
        res_elements.add(new ResidentialBuildingsItems("Heidenheimerstraße (Hause 2)", R.drawable.heidenheimer2, "10, 12 and 15 person flat share (private bathroom): € 318", "Heidenheimer Str. 78, 89075 Ulm"));
        res_elements.add(new ResidentialBuildingsItems("Upper West Side", R.drawable.uppperwestside, "3 and 5 person flat share: € 343\n\n11 person flat share (private bathroom): €343", "Manfred-Straße, 89081 Ulm"));

        ResidentialBAdapter adapter=new ResidentialBAdapter(this);
        adapter.setContacts(res_elements);

        resBRecView.setAdapter(adapter);
        resBRecView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        //resBRecView.setLayoutManager(new GridLayoutManager(this, 2));



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