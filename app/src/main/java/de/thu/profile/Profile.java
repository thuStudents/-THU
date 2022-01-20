package de.thu.profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import de.thu.HomeActivity;
import de.thu.R;
import de.thu.WelcomeActivity;
import de.thu.forum.PostActivity;

public class Profile extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        editProfile();
        logout();

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
                        startActivity(new Intent(getApplicationContext(),
                                PostActivity.class));
                        overridePendingTransition(0,0);
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



        FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        TextView profileEmail = (TextView)findViewById(R.id.user_email);
        profileEmail.setText(currentFirebaseUser.getEmail());

    }

    /**
     * Function to sign the user out
     */

    private void logout() {

        Button buttonLogout;
        buttonLogout = findViewById(R.id.buttonLogout);
        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FirebaseAuth.getInstance().signOut();

                //Intent flags used to clear the back stack so the user can not access the app after logout with the back button
                Intent intent = new Intent(Profile.this, WelcomeActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);

                overridePendingTransition(0,0);
            }
        });

    }

    /**
     * Function to go the edit profile page
     */

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


}