package de.thu;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import de.thu.adapters.NightLifeAdapter;

public class NightLifeActivity extends AppCompatActivity {

    private RecyclerView nightRecView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_night);

        nightRecView =findViewById(R.id.night_recview);


        ArrayList<NightLifeItems> nightitem = new ArrayList<>();
        nightitem.add(new NightLifeItems("Clubs", R.drawable.clubs));
        nightitem.add(new NightLifeItems("Bars", R.drawable.bars));
        nightitem.add(new NightLifeItems("Cinemas", R.drawable.cinemas));
        nightitem.add(new NightLifeItems("Restaurants", R.drawable.restaurants));


        NightLifeAdapter adapter=new NightLifeAdapter(this);
        adapter.setContacts(nightitem);

        nightRecView.setAdapter(adapter);
        //nightRecView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        //nightRecView.setLayoutManager(new LinearLayoutManager(this));
        nightRecView.setLayoutManager(new GridLayoutManager(this, 2));




    }
}