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
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ChangepasswordActivity extends AppCompatActivity {

    EditText currentPassword, newPassword, newPasswordConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.changepassword);

        currentPassword=findViewById(R.id.cp_oldpassword);
        newPassword=findViewById(R.id.cp_newpassword);
        newPasswordConfirm=findViewById(R.id.cp_confirmpassword);


        //profilecp();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.find);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.find:
                        if(WelcomeActivity.signedAsGuest!=true){
                            startActivity(new Intent(getApplicationContext()
                                    , Profile.class));
                        } else {
                            Toast.makeText(ChangepasswordActivity.this, "You are not Logged In", Toast.LENGTH_SHORT).show();
                        }
                        return true;
                    case R.id.add:
                        if(WelcomeActivity.signedAsGuest!=true){
                            startActivity(new Intent(getApplicationContext()
                                    , PostActivity.class));
                            overridePendingTransition(0,0);
                        } else {
                            Toast.makeText(ChangepasswordActivity.this, "You are not Logged In", Toast.LENGTH_SHORT).show();
                        }
                        return true;
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext()
                                , HomeActivity.class));
                        overridePendingTransition(0,0);
                        return true;                }

                return false;
            }
        });

    }

    public void profilecp() {
        Button saveChanges;
        saveChanges = findViewById(R.id.cp_button);

        String curPassword = currentPassword.getText().toString();
        String nPassword = newPassword.getText().toString();
        String nPasswordConfirm = newPasswordConfirm.getText().toString();

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();


            saveChanges.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    if (curPassword.isEmpty() || nPassword.isEmpty() || nPasswordConfirm.isEmpty() || nPassword.length()<6) {
                        Toast.makeText(ChangepasswordActivity.this, "Enter a valid password", Toast.LENGTH_SHORT).show();
                    } else if (!nPassword.equals(newPassword)) {
                        Toast.makeText(ChangepasswordActivity.this, "Passwords don't match", Toast.LENGTH_SHORT).show();
                    } else {
                        user.updatePassword(nPasswordConfirm)
                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {

                                        if (task.isSuccessful()) {
                                            Log.d("Status", "User password updated.");
                                        }

                                    }
                                });
                    }
                }
            });
    }
}