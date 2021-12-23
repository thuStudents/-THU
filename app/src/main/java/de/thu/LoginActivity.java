package de.thu;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
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

    String emailPattern = "[a-zA-Z0-9._]-+@[a-z]+\\.+[a-z]";

    FirebaseAuth mAuth;
    FirebaseUser mUser;

    TextView createNewAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginEmail=findViewById(R.id.inputEmail);
        loginPassword=findViewById(R.id.inputPassword);
        buttonLogin=findViewById(R.id.buttonLogin);
        progressDialog = new ProgressDialog(this);
        createNewAccount = findViewById(R.id.createNewAccount);

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();

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
                overridePendingTransition(0,0);

            }
        });

    }

    private void login() {
        String email = loginEmail.getText().toString();
        String password = loginPassword.getText().toString();

        if (email.isEmpty()) {
            loginEmail.setError("Enter a valid email");
        } else if (password.isEmpty() || password.length()<6) {
            loginPassword.setError("Enter a valid password");
        } else {
            progressDialog.setMessage("Login in progress");
            progressDialog.setTitle("Login");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()) {

                                progressDialog.dismiss();
                                sendUserToNextActivity();
                                Toast.makeText(LoginActivity.this, "Registration successful",Toast.LENGTH_SHORT).show();

                            } else {
                                progressDialog.dismiss();
                                Toast.makeText(LoginActivity.this, ""+task.getException(),Toast.LENGTH_SHORT).show();

                            }

                        }
                    });

        }
    }

    private void sendUserToNextActivity() {

        Intent intent = new Intent(this, HomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

    }

}