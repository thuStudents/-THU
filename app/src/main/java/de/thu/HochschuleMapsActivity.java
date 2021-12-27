package de.thu;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

import de.thu.databinding.ActivityHochschuleMapsBinding;

public class HochschuleMapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityHochschuleMapsBinding binding;

    private ArrayList<LatLng> locationArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityHochschuleMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        float zoomLevel = 19.0f;
        mMap.setMapType(mMap.MAP_TYPE_SATELLITE);
        LatLng thuPin =  new LatLng(48.40854643587451, 9.997882487120377);
        LatLng aula = new LatLng(48.4083131479761, 9.997879678462267);
        LatLng aulaPin = new LatLng(48.4082231479761, 9.997879678462267);
        LatLng cafeteria = new LatLng(48.40865730362196, 9.999050656468041);
        LatLng cafeteriaPin = new LatLng(48.40856730362196, 9.999050656468041);
        LatLng bauA = new LatLng(48.40888016884203, 9.997563228383093);
        LatLng bauB = new LatLng(48.40841723070783, 9.998422085558538);
        LatLng bauC = new LatLng(48.4088399066848, 9.99806669638207);
        LatLng bauE = new LatLng(48.40862758616991, 9.997506958430266);
        LatLng bauF = new LatLng(48.40904414037098, 9.9965635001219);
        LatLng bauG = new LatLng(48.40837621729293, 9.999280046569596);
        LatLng mensa = new LatLng(48.4083422703157, 9.999091815377632);
        LatLng mensaPin = new LatLng(48.4082522703157, 9.999091815377632);

        mMap.addMarker(new MarkerOptions().position(aula).icon(BitmapDescriptorFactory.fromResource(R.drawable.aula_text)));
        mMap.addMarker(new MarkerOptions().position(aulaPin));
        mMap.addMarker(new MarkerOptions().position(cafeteria).icon(BitmapDescriptorFactory.fromResource(R.drawable.cafeteria_text)));
        mMap.addMarker(new MarkerOptions().position(cafeteriaPin));
        mMap.addMarker(new MarkerOptions().position(mensa).icon(BitmapDescriptorFactory.fromResource(R.drawable.mensa_text)));
        mMap.addMarker(new MarkerOptions().position(mensaPin));

        mMap.addMarker(new MarkerOptions().position(bauA).icon(BitmapDescriptorFactory.fromResource(R.drawable.bau_a_text)));
        mMap.addMarker(new MarkerOptions().position(bauB).icon(BitmapDescriptorFactory.fromResource(R.drawable.bau_b_text)));
        mMap.addMarker(new MarkerOptions().position(bauC).icon(BitmapDescriptorFactory.fromResource(R.drawable.bau_c_text)));
        mMap.addMarker(new MarkerOptions().position(bauE).icon(BitmapDescriptorFactory.fromResource(R.drawable.bau_e_text)));
        mMap.addMarker(new MarkerOptions().position(bauF).icon(BitmapDescriptorFactory.fromResource(R.drawable.bau_f_text)));
        mMap.addMarker(new MarkerOptions().position(bauG).icon(BitmapDescriptorFactory.fromResource(R.drawable.bau_g_text)));


        mMap.addMarker(new MarkerOptions().position(thuPin).icon(BitmapDescriptorFactory.fromResource(R.drawable.thu_text)));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(18.0f));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(thuPin, zoomLevel));

    }
}