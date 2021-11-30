package de.thu;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    ImageView home, add, find;

    RecyclerView.Adapter adapter;
    RecyclerView latest_updates;
    //AutoScrollAdapter autoScrollAdapter;
    //LinearLayoutManager layoutManager;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_homepage_activity);


        //hooks
        latest_updates=findViewById(R.id.latest_updates);

        latest_updates();


        }
        private void latest_updates(){


        //recyclerview only loads the cards visible to user
        latest_updates.setHasFixedSize(true);
        latest_updates.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

            ArrayList<LatestUpdatesItems> latestUpdatesLocations = new ArrayList<>();

            latestUpdatesLocations.add(new LatestUpdatesItems(R.drawable.evenmorenews, "This is news", " fejhf fewjkfzhew fewkufzh ewew"));
            latestUpdatesLocations.add(new LatestUpdatesItems(R.drawable.morenews, "This is news", " fejhf fewjkfzhew fewkufzh ewew"));
            latestUpdatesLocations.add(new LatestUpdatesItems(R.drawable.clubs, "This is news", " fejhf fewjkfzhew fewkufzh ewew"));
            latestUpdatesLocations.add(new LatestUpdatesItems(R.drawable.restaurants, "This is news", " fejhf fewjkfzhew fewkufzh ewew"));

            adapter = new LatestUpdatesAdapter(latestUpdatesLocations);
            latest_updates.setAdapter(adapter);

        }
}