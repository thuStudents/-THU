package de.thu.city;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import de.thu.R;
import de.thu.databinding.ActivityCityMapBinding;

public class CityMapActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityCityMapBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityCityMapBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        /**
         * Obtain the SupportMapFragment and get notified when the map is ready to be used.
         */
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.mapUlm);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can added markers, zoomed our view and moved the camera to the desired location.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        float zoomLevel = 15.0f;

        LatLng thuPin =  new LatLng(48.40854643587451, 9.997882487120377);
        mMap.addMarker(new MarkerOptions().position(thuPin).title("Technische Hochschule Ulm"));
        LatLng ulm = new LatLng(48.397991, 9.980201);
        mMap.addMarker(new MarkerOptions().position(ulm).icon(BitmapDescriptorFactory.fromResource(R.drawable.ulm_location_icon)));
        LatLng studierendenwerk = new LatLng(48.41820654107166, 9.944047326406256);
        mMap.addMarker(new MarkerOptions().position(studierendenwerk).title("Studierendenwerk"));
        LatLng thu2Pin =  new LatLng(48.41830622945095, 9.938758010434492);
        mMap.addMarker(new MarkerOptions().position(thu2Pin).title("Technische Hochschule Ulm"));
        LatLng hbf =  new LatLng(48.3994636257118, 9.98326916873445);
        mMap.addMarker(new MarkerOptions().position(hbf).title("Ulm HBF"));
        LatLng busStation =  new LatLng(48.42597583780749, 10.010131268735536);
        mMap.addMarker(new MarkerOptions().position(busStation).title("Central Bus Station Ulm"));
        LatLng office1 =  new LatLng(48.40015757055806, 9.985023098122072);
        mMap.addMarker(new MarkerOptions().position(office1).title("Ausländerbehörde Ulm"));
        LatLng office2 =  new LatLng(48.40032383303093, 9.985934597570044);
        mMap.addMarker(new MarkerOptions().position(office2).title("Einwohnermeldeamt Ulm"));

        mMap.animateCamera(CameraUpdateFactory.zoomTo(15.0f));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ulm, zoomLevel));

    }
}