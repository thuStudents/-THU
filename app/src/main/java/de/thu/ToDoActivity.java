package de.thu;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.firebase.ui.database.FirebaseListOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class ToDoActivity extends AppCompatActivity {
    Button addNewTask;
    FragmentTransaction fragmentTransaction;
    ListView lv;
    FirebaseListAdapter adapter;
    // private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.find:
                        startActivity(new Intent(getApplicationContext()
                                , Profile.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.add:
                        startActivity(new Intent(getApplicationContext()
                                , PostActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext()
                                , HomeActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }

                return false;
            }
        });

        /*recyclerView = findViewById(R.id.recycerlview_todoList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(ToDoActivity.this ));*/

        addNewTask = findViewById(R.id.addTaskButton);
        addNewTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                startActivity(new Intent(getApplicationContext()
                        , AddTask.class));
                overridePendingTransition(0,0);

                }
        });


        lv = (ListView) findViewById(R.id.toDoListView);

        FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        Query query = FirebaseDatabase
                .getInstance("https://thu-3f8f6-default-rtdb.europe-west1.firebasedatabase.app/")
                .getReference()
                .child("toDo")
                .child(currentFirebaseUser.getUid());

        FirebaseListOptions<Task> options = new FirebaseListOptions.Builder<Task>()
                .setLayout(R.layout.to_do_layout)
                .setQuery(query, Task.class)
                .build();

        adapter = new FirebaseListAdapter(options) {
            @Override
            protected void populateView(@NonNull View v, @NonNull Object model, int position) {


                TextView taskView = v.findViewById(R.id.taskText);

                Task tsk = (Task) model;
                taskView.setText(tsk.getTask().toString());

            }
        };

        lv.setAdapter(adapter);




    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }

    /*public void showButton(){
        addNewTask.setVisibility(View.VISIBLE);
    }*/

}