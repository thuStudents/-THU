package de.thu;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class CafeteriaMensaActivity extends AppCompatActivity {

    Button mensaBtn, cafeteriaBtn;
    CafeteriaFragment cafeteriaFrg;
    MensaFragment newsFrg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cafeteria_mensa);
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
                Toast.makeText(CafeteriaMensaActivity.this, "Here", Toast.LENGTH_SHORT).show();

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


    }

    private void replaceFragment(Fragment fragment) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.commit();

    }
}