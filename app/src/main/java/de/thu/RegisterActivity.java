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

public class RegisterActivity extends AppCompatActivity {

    EditText registerEmail, registerUsername, registerPassword, registerConfirmPassword;
    Button buttonRegister;
    TextView alreadyHaveAccount;
    ProgressDialog progressDialog;

    String emailPattern = "[a-zA-Z0-9._]+@thu.de";

    FirebaseAuth mAuth;
    FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        registerEmail=findViewById(R.id.inputEmail);
        registerUsername=findViewById(R.id.username);
        registerPassword=findViewById(R.id.inputPassword);
        registerConfirmPassword=findViewById(R.id.confirmPassword);
        buttonRegister=findViewById(R.id.buttonRegister);
        alreadyHaveAccount = findViewById(R.id.alreadyHaveAccount);
        progressDialog = new ProgressDialog(this);

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerAuth();
            }
        });

        alreadyHaveAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext()
                        , LoginActivity.class));
                overridePendingTransition(0, 0);

            }
        });




    }

    private void registerAuth() {

        String email = registerEmail.getText().toString();
        String username = registerUsername.getText().toString();
        String password = registerPassword.getText().toString();
        String confirmPassword = registerConfirmPassword.getText().toString();


        if (email.isEmpty()) {
            registerEmail.setError("Email is empty");
        } else if (!(email.matches(emailPattern))){
            registerEmail.setError("Enter your student email");
        } else if (password.isEmpty() || password.length()<6) {
            registerPassword.setError("Enter a valid password");
        } else if (!password.equals(confirmPassword)) {
            registerConfirmPassword.setError("Passwords don't match");
        } else {
            progressDialog.setMessage("Registration in progress");
            progressDialog.setTitle("Registration");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();


            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()) {
                                WelcomeActivity.signedAsGuest = false;
                                progressDialog.dismiss();
                                sendUserToNextActivity();
                                Toast.makeText(RegisterActivity.this, "Registration successful",Toast.LENGTH_SHORT).show();

                            } else {
                                progressDialog.dismiss();
                                Toast.makeText(RegisterActivity.this, ""+task.getException(),Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }


    }

    private void sendUserToNextActivity() {
        //Intent flags used to clear the back stack so the user can not go back to this activity with the back button
       Intent intent = new Intent(this, HomeActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
       startActivity(intent);
    }

}

//    public boolean isCurUserRegisteredIn() {
//        return (FirebaseAuth.getInstance().getReference() != null);
//    }
