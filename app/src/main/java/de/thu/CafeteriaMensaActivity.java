package de.thu;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class CafeteriaMensaActivity extends AppCompatActivity {

    Button mensaBtn, cafeteriaBtn;
    CafeteriaFragment cafeteriaFrg;
    MensaFragment newsFrg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cafeteria_mensa);


        /**
         * Two buttons are created and initialized with the buttons from the layout.
         * OnClickListeners and corresponding handling methods are implemented for both buttons.
         * When each of the buttons is clicked the corresponding fragment is replaced and shown.
         * The colors of the buttons are toggled on button clicks.
         */
        mensaBtn = findViewById(R.id.mensaFragmentbtn);
        cafeteriaBtn = findViewById(R.id.cafeteriaFragmentbtn);
        cafeteriaFrg = new CafeteriaFragment();
        newsFrg = new MensaFragment();
        replaceFragment(newsFrg);

        mensaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mensaBtn.setBackground(getResources().getDrawable(R.drawable.news_selected_button));
                mensaBtn.setTextColor(getResources().getColor(R.color.white));
                cafeteriaBtn.setBackground(getResources().getDrawable(R.drawable.events_notselected_button));
                cafeteriaBtn.setTextColor(getResources().getColor(R.color.thuColor));

                replaceFragment(newsFrg);
            }
        });

        cafeteriaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mensaBtn.setBackground(getResources().getDrawable(R.drawable.news_notselected_button));
                mensaBtn.setTextColor(getResources().getColor(R.color.thuColor));
                cafeteriaBtn.setBackground(getResources().getDrawable(R.drawable.events_selected_button));
                cafeteriaBtn.setTextColor(getResources().getColor(R.color.white));
                replaceFragment(cafeteriaFrg);
            }
        });


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.find:
                        if(WelcomeActivity.signedAsGuest!=true){
                            startActivity(new Intent(getApplicationContext()
                                    , Profile.class));
                        } else {
                            Toast.makeText(CafeteriaMensaActivity.this, "You are not Logged In", Toast.LENGTH_SHORT).show();
                        }
                        return true;
                    case R.id.add:
                        if(WelcomeActivity.signedAsGuest!=true){
                            startActivity(new Intent(getApplicationContext()
                                    , PostActivity.class));
                            overridePendingTransition(0,0);
                        } else {
                            Toast.makeText(CafeteriaMensaActivity.this, "You are not Logged In", Toast.LENGTH_SHORT).show();
                        }
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

    /**
     * This method replaces the current fragment in an activity with another.
     * It receives the fragment as a parameter.
     * It calls the Fragment Manager for interacting with fragments associated with this activity.
     * It creates a fragment transaction and begins it.
     * The fragment layout is replaced with the fragment received as parameter.
     * The fragment transaction is then committed.
     * @param fragment
     */
    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.commit();
    }
}