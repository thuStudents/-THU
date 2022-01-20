package de.thu.myStudies;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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

import de.thu.R;

/**
 * Get the database reference and instance
 * Check the number of entries on the database and increment
 * On button click send the task to database
 */

public class AddTask extends AppCompatActivity {

    Button addTask;
    FirebaseDatabase rootnode;
    DatabaseReference reference;
    FirebaseAuth mAuth;
    long maxid=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        rootnode = FirebaseDatabase.getInstance("https://thu-3f8f6-default-rtdb.europe-west1.firebasedatabase.app/");
        reference = rootnode.getReference("toDo").child(currentFirebaseUser.getUid());

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

        addTask = findViewById(R.id.add_task_btn);
        addTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText addTask = findViewById(R.id.add_task);
                String taskValue = addTask.getText().toString();

                reference.child(String.valueOf(maxid+1)).child("task").setValue(taskValue);


                Intent intent = new Intent(AddTask.this, ToDoActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP );
                startActivity(intent);

            }
        });

    }
}