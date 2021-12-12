package de.thu;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class EditprofileActivity extends AppCompatActivity {

    EditText profileEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editprofile);

        profile();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.find);


        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.find:
                        startActivity(new Intent(getApplicationContext()
                                , Profile.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.add:
                        Toast.makeText(EditprofileActivity.this, "Add button pressed", Toast.LENGTH_SHORT).show();
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


    public void profile() {
        Button saveChanges;
        saveChanges = findViewById(R.id.edit_savechanges);
        saveChanges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                profileEmail=findViewById(R.id.edit_email);
                String email = profileEmail.getText().toString();
                Log.d("email", email);

                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                user.updateEmail(email)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Log.d("Status", "User email address updated.");
                                    Intent profileActivity;
                                    profileActivity = new Intent(EditprofileActivity.this, Profile.class);
                                    startActivity(profileActivity);
                                } else {
                                    Toast.makeText(EditprofileActivity.this, ""+task.getException(),Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

                /*Intent profileActivity;
                profileActivity = new Intent(EditprofileActivity.this, Profile.class);
                startActivity(profileActivity);*/
            }
        });


    }



}