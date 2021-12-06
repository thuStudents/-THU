package de.thu;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;

public class Profile extends AppCompatActivity {

    FirebaseAuth mAuth;
    FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        editProfile();
        changePassword();
        getUserInfo();


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

    private void changePassword() {

        Button changePasswordButton;
        changePasswordButton = findViewById(R.id.changepassword_bttn);
        changePasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent changepasswordActivity;
                changepasswordActivity = new Intent(Profile.this, ChangepasswordActivity.class);
                startActivity(changepasswordActivity);
            }
        });

    }

    private void editProfile() {

        Button editProfileButton;
        editProfileButton = findViewById(R.id.editprofile_bttn);
        editProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent editProfileActivity;
                editProfileActivity = new Intent(Profile.this, EditprofileActivity.class);
                startActivity(editProfileActivity);
            }
        });

    }

    private void getUserInfo() {

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();

        if (mUser != null) {
            for (UserInfo profile : mUser.getProviderData()) {

                Log.d("Current user info", String.valueOf(profile));

                TextView tv1 = (TextView)findViewById(R.id.user_email);
                tv1.setText(String.valueOf(profile.getEmail()));

            }

        }
    }


}