package de.thu.ulm.transport;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import de.thu.R;
import de.thu.adapters.TransportAdapter;

public class TransportActivity extends AppCompatActivity {

    private RecyclerView transportBRecView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_transport);

        transportBRecView =findViewById(R.id.transport_recview);

        ArrayList<TransportItems> means = new ArrayList<>();
        means.add(new TransportItems("Buses", "Discover Ulm thanks to it's developed public transport system", R.drawable.bus));
        means.add(new TransportItems("Trains", "Take advantage of the connections to many destinations in and outside Germany", R.drawable.train));
        means.add(new TransportItems("Trams", "Get to your destinations fast thanks to Ulms' tram system", R.drawable.tram));


        TransportAdapter adapter=new TransportAdapter(this);
        adapter.setContacts(means);

        transportBRecView.setAdapter(adapter);
        transportBRecView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        //transportBRecView.setLayoutManager(new GridLayoutManager(this, 2));
    }
}