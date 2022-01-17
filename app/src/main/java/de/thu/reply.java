package de.thu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class reply extends AppCompatActivity {

    Button replyButton;
    String id;
    FirebaseDatabase rootnode;
    DatabaseReference reference;
    FirebaseAuth mAuth;
    ReplyItems replyItems;
    long maxid=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reply);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            id = extras.getString("id");
        }

        replyItems = new ReplyItems();

        rootnode = FirebaseDatabase.getInstance("https://thu-3f8f6-default-rtdb.europe-west1.firebasedatabase.app/");
        reference = rootnode.getReference("answers").child(id);

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if(snapshot.exists()) {
                    maxid=(snapshot.getChildrenCount());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        replyButton = findViewById(R.id.add_reply_btn);
        replyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("check id", String.valueOf(id));

                EditText editText = findViewById(R.id.add_reply_txt);
                String replyText = editText.getText().toString();

                FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser();

                int random = (int)(Math.random() * 50 + 1);

                String currentDate = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(new Date());
                int mSec = calendar.get(Calendar.MILLISECOND);

                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                String str = sdf.format(new Date());

                replyItems.setReply(replyText);
                replyItems.setDate(currentDate + " " + str);
                replyItems.setEmail(currentFirebaseUser.getEmail());

                reference.child(String.valueOf(maxid+1)).setValue(replyItems);

                startActivity(new Intent(getApplicationContext()
                        , ForumActivity.class));
                overridePendingTransition(0,0);

            }
        });


    }
}