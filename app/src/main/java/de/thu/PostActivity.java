package de.thu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Random;

public class PostActivity extends AppCompatActivity  implements View.OnClickListener{
     Button btnAdd;
    FirebaseDatabase rootnode;
    DatabaseReference reference;
    FirebaseAuth mAuth;
    Random rand = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        btnAdd = findViewById(R.id.add_post_btn);
        btnAdd.setOnClickListener(this);
    }


    public void onClick(View view) {
        switch(view.getId()){
            case R.id.add_post_btn:
                //add the post and go back to activity
                EditText editText = findViewById(R.id.add_post_txt);
                String value = editText.getText().toString();
                FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser();


                rootnode = FirebaseDatabase.getInstance("https://thu-3f8f6-default-rtdb.europe-west1.firebasedatabase.app/");
                reference = rootnode.getReference("posts");
                int random = (int)(Math.random() * 50 + 1);

                reference.child(currentFirebaseUser.getUid() + random).setValue(value);



                /*Intent createAccount = new Intent(this, ForumActivity.class);
                startActivity(createAccount);*/

                break;
            default:
                break;
        }

    }
}
