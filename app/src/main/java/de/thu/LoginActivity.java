package de.thu;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    EditText loginEmail, loginPassword;
    Button buttonLogin;
    ProgressDialog progressDialog;
    private boolean userLoggedIn = false;

    String emailPattern = "[a-zA-Z0-9._]-+@[a-z]+\\.+[a-z]";

    FirebaseAuth mAuth;
    FirebaseUser mUser;

    TextView createNewAccount;

    @Override
    public void onStart() {
        super.onStart();

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();

        if(mUser != null){
            mUser.reload();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginEmail = findViewById(R.id.inputEmail);
        loginPassword = findViewById(R.id.inputPassword);
        buttonLogin = findViewById(R.id.buttonLogin);
        createNewAccount = findViewById(R.id.createNewAccount);


        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                login();
            }
        });


        createNewAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext()
                        , RegisterActivity.class));
                overridePendingTransition(0, 0);

            }
        });

    }

    /**
     * Validation for the input fields
     * Check if the user exist
     * Check if password is correct
     * Call the signInWithEmailAndPassword function
     */

    private void login() {
        String email = loginEmail.getText().toString();
        String password = loginPassword.getText().toString();
        if (email.isEmpty()) {
            loginEmail.setError("Enter a valid email");
        } else if (password.isEmpty() || password.length() < 6) {
            loginPassword.setError("Enter a valid password");
        } else {
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                WelcomeActivity.signedAsGuest = false;
                                sendUserToNextActivity();
                            } else {
                                Toast.makeText(LoginActivity.this, "" + task.getException(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    }

    /**
     * After logging in, send the user to the homepage
     */

    private void sendUserToNextActivity() {

        //Intent flags used to clear the back stack so the user can not go back to this activity with the back button
        Intent intent = new Intent(this, HomeActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

}
