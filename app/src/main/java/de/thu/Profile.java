package de.thu;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Profile extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        editProfile();
        changePassword();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.find);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.find:
                        Toast.makeText(Profile.this, "Profile", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.add:
                        Toast.makeText(Profile.this, "Add button pressed", Toast.LENGTH_SHORT).show();
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

    public void editProfile() {
        Button editProfile;
        editProfile = findViewById(R.id.editprofile_bttn);
        editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent editProfileActivity;
                editProfileActivity = new Intent(Profile.this, EditprofileActivity.class);
                startActivity(editProfileActivity);
            }
        });


    }


    public void changePassword() {
        Button changePassword;
        changePassword = findViewById(R.id.changepassword_bttn);
        changePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent changepasswordActivity;
                changepasswordActivity = new Intent(Profile.this, ChangepasswordActivity.class);
                startActivity(changepasswordActivity);
            }
        });


    }

}