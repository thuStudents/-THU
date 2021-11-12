package de.thu;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;


public class ForumActivity extends AppCompatActivity {
    BottomNavigationView bottomNav;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum);
//            Toolbar toolbar=findViewById(R.id.toolbar);
//    setSupportActionBar(toolbar);
        bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
//                    Intent intent=new Intent(getApplicationContext(),DashboardActivity.class);
//                    startActivity(intent);
//                    finish();
                        break;
                    case R.id.add:
                        Intent intent=new Intent(getApplicationContext(),PostActivity.class);
                        startActivity(intent);
                        finish();
//                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container1,new AddButtonQue()).commit();
                        break;
                    case R.id.find:
//                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container1,new FindFriend()).commit();
                        break;
                }
                return true;
            }
        });

//
//        if(savedInstanceState==null) {
//        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container1, new ForumFragment()).commit();
    }

}