package de.thu;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
    ProgressDialog progressDialog;

    String emailPattern = "[a-zA-Z0-9._]-+@[a-z]+\\.+[a-z]";

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
        progressDialog = new ProgressDialog(this);

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerAuth();
            }
        });

    }

    private void registerAuth() {

        String email = registerEmail.getText().toString();
        String username = registerUsername.getText().toString();
        String password = registerPassword.getText().toString();
        String confirmPassword = registerConfirmPassword.getText().toString();


        if (email.isEmpty()) {
            registerEmail.setError("Enter a valid email");
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

       Intent intent = new Intent(this, HomeActivity.class);
       intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
       startActivity(intent);

    }

//    public boolean isCurUserRegisteredIn() {
//        return (FirebaseAuth.getInstance().getReference() != null);
//    }


}