package de.thu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText postText;
    Button postButton;
    DatabaseReference ref;
    Post post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Toast.makeText(MainActivity.this, "Firebase Connection Success",Toast.LENGTH_LONG).show();

        postText = (EditText) findViewById(R.id.postText);
        postButton = (Button) findViewById(R.id.postButton);

        post = new Post();
        ref = FirebaseDatabase.getInstance().getReference().child("Post");

        postButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                post.setPostText(postText.getText().toString().trim());




                ref.push().setValue(post);

                Toast.makeText(MainActivity.this, "Post inserted",Toast.LENGTH_LONG).show();

            }
        });









    }
}