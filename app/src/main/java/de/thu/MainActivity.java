package de.thu;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    ImageView home, profile, settings;


    RecyclerView event_rec_view;
    AutoScrollAdapter autoScrollAdapter;
     LinearLayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_homepage);
        //Toast.makeText(MainActivity.this, "Firebase Connection Success",Toast.LENGTH_LONG).show();

        event_rec_view = findViewById(R.id.event_rec_view);

        setRV();

        home = findViewById(R.id.home_icon);
        profile = findViewById(R.id.profile_icon);
        settings = findViewById(R.id.settings_icon);

        setClickListener(home);
        setClickListener(profile);
        setClickListener(settings);

    }

    private void setClickListener(View view) {

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "this is a test", Toast.LENGTH_SHORT).show();
            }
        });

    }


    private void setRV() {
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        event_rec_view.setLayoutManager(layoutManager);
        autoScrollAdapter = new AutoScrollAdapter(this);
        event_rec_view.setAdapter(autoScrollAdapter);

        LinearSnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(event_rec_view);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if(layoutManager.findLastCompletelyVisibleItemPosition() < (autoScrollAdapter.getItemCount() - 1)){
                    layoutManager.smoothScrollToPosition(event_rec_view, new RecyclerView.State(), layoutManager.findLastCompletelyVisibleItemPosition() + 1);
                }else{
                    layoutManager.smoothScrollToPosition(event_rec_view, new RecyclerView.State(), 0);
                }
            }

        },0, 3000);

    }
}
