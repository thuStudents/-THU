package de.thu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PostActivity extends AppCompatActivity  implements View.OnClickListener{
     Button btnAdd;
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
                Intent createAccount = new Intent(this, ForumActivity.class);
                startActivity(createAccount);
                break;
            default:
                break;
        }

    }
}