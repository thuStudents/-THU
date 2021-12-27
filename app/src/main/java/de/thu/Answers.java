package de.thu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.firebase.ui.database.FirebaseListOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class Answers extends AppCompatActivity {

    ListView answersLv;
    FirebaseListAdapter answersAdapter;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answers);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            id = extras.getString("id");
        }

        answersLv = (ListView) findViewById(R.id.answersListView);

        Query query = FirebaseDatabase.getInstance("https://thu-3f8f6-default-rtdb.europe-west1.firebasedatabase.app/").getReference().child("answers").child(id);

        Log.d("query result", String.valueOf(query));

        FirebaseListOptions<AnswerItems> answersOptions = new FirebaseListOptions
                .Builder<AnswerItems>()
                .setLayout(R.layout.answers_layout)
                .setQuery(query, AnswerItems.class)
                .build();

        Log.d("query result", String.valueOf(answersOptions));

        answersAdapter = new FirebaseListAdapter(answersOptions) {
            @Override
            protected void populateView(@NonNull View v, @NonNull Object model, int position) {

                Log.d("check", "1");

                TextView answersReply = v.findViewById(R.id.answers_reply);
                TextView answersEmail = v.findViewById(R.id.answers_user_name);
                TextView answersDate = v.findViewById(R.id.answers_date_time);

                AnswerItems pst = (AnswerItems) model;

                Log.d("reply", pst.getReply().toString());
                Log.d("email", pst.getEmail().toString());
                Log.d("date", pst.getDate().toString());

                answersReply.setText(pst.getReply().toString());
                answersEmail.setText((pst.getEmail().toString()));
                answersDate.setText(pst.getDate().toString());

            }
        };

        answersLv.setAdapter(answersAdapter);

    }

    @Override
    protected void onStart() {
        super.onStart();
        answersAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        answersAdapter.stopListening();
    }
}