package de.thu.city;

import android.content.Intent;
import android.os.Bundle;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import de.thu.R;

public class LegalAdviceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_legal_advice);


//        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
//        bottomNavigationView.setSelected(false);
//        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                switch (item.getItemId()) {
//                    case R.id.find:
//                        if (WelcomeActivity.signedAsGuest != true) {
//                            startActivity(new Intent(getApplicationContext()
//                                    , Profile.class));
//                        } else {
//                            Toast.makeText(LegalAdviceActivity.this, "You are not Logged In", Toast.LENGTH_SHORT).show();
//                        }
//                        return true;
//                    case R.id.add:
//                        if (WelcomeActivity.signedAsGuest != true) {
//                            startActivity(new Intent(getApplicationContext()
//                                    , PostActivity.class));
//                            overridePendingTransition(0, 0);
//                        } else {
//                            Toast.makeText(LegalAdviceActivity.this, "You are not Logged In", Toast.LENGTH_SHORT).show();
//                        }
//                        return true;
//                    case R.id.home:
//                        startActivity(new Intent(getApplicationContext()
//                                , HomeActivity.class));
//                        overridePendingTransition(0, 0);
//                        return true;
//                }
//
//                return false;
//            }
//        });



    }
}