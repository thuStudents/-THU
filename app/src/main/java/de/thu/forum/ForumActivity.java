package de.thu.forum;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.firebase.ui.database.FirebaseListAdapter;
import com.firebase.ui.database.FirebaseListOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import de.thu.HomeActivity;
import de.thu.profile.Profile;
import de.thu.R;

/**
 * Query the database for forum post
 * Create the view for the listview on the layout
 * Pass the data to the view
 * Generate the view with the adapter
 */

public class ForumActivity extends AppCompatActivity {

    ListView lv;
    FirebaseListAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum);
//            Toolbar toolbar=findViewById(R.id.toolbar);
//    setSupportActionBar(toolbar);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.home);

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

        lv = (ListView) findViewById(R.id.postListView);

        Query query = FirebaseDatabase.getInstance("https://thu-3f8f6-default-rtdb.europe-west1.firebasedatabase.app/").getReference().child("posts");

        Log.d("query result", String.valueOf(query));


        FirebaseListOptions<Post> options = new FirebaseListOptions.Builder<Post>()
                .setLayout(R.layout.post_layout)
                .setQuery(query, Post.class)
                .build();

        Log.d("formcheck", String.valueOf(options));

        adapter = new FirebaseListAdapter(options) {
            @Override
            protected void populateView(@NonNull View v, @NonNull Object model, int position) {

                Log.d("check", "2");

                TextView postPost = v.findViewById(R.id.user_que);
                TextView postEmail = v.findViewById(R.id.post_que_user_name);
                TextView postDate = v.findViewById(R.id.text_que_time_dis);
                TextView postId = v.findViewById(R.id.post_id);

                TextView reply = v.findViewById(R.id.no_likes);
                TextView answers = v.findViewById(R.id.ans_text);

                Post pst = (Post) model;
                postPost.setText(pst.getPost().toString());
                postEmail.setText((pst.getEmail().toString()));
                postDate.setText(pst.getDate().toString());
                postId.setText(pst.getId().toString());


                reply.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String id = postId.getText().toString();

                        Intent i = new Intent(ForumActivity.this, de.thu.forum.reply.class);
                        i.putExtra("id",id);
                        startActivity(i);


                    }
                });

                answers.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String id = postId.getText().toString();

                        Intent i = new Intent(ForumActivity.this, Answers.class);
                        i.putExtra("id",id);
                        startActivity(i);


                    }
                });
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
}