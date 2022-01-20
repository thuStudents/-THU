package de.thu.myStudies;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import de.thu.HomeActivity;
import de.thu.R;
import de.thu.forum.PostActivity;
import de.thu.profile.Profile;

public class TimetableActivity extends AppCompatActivity {

    FirebaseDatabase rootnode;
    DatabaseReference reference;
    FirebaseAuth mAuth;
    Button saveTimetable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.find);
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

        saveTimetable = findViewById(R.id.save_timetable_data);

        saveTimetable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                saveTimetable();

            }
        });

        getTimetable();

    }

    /**
     * Get the entries from the database for the respective user
     * Pass them onto the fields for the timetable so that the user can see his last saved timetable
     * Validation for the null entries of the timetable
     */

    private void getTimetable() {

        EditText monday1 = (EditText)findViewById(R.id.mondayClass1);
        EditText monday2 = (EditText)findViewById(R.id.mondayClass2);
        EditText monday3 = (EditText)findViewById(R.id.mondayClass3);
        EditText monday4 = (EditText)findViewById(R.id.mondayClass4);
        EditText monday5 = (EditText)findViewById(R.id.mondayClass5);

        EditText tuesday1 = (EditText)findViewById(R.id.tuesdayClass1);
        EditText tuesday2 = (EditText)findViewById(R.id.tuesdayClass2);
        EditText tuesday3 = (EditText)findViewById(R.id.tuesdayClass3);
        EditText tuesday4 = (EditText)findViewById(R.id.tuesdayClass4);
        EditText tuesday5 = (EditText)findViewById(R.id.tuesdayClass5);

        EditText wednesday1 = (EditText)findViewById(R.id.wednesdayClass1);
        EditText wednesday2 = (EditText)findViewById(R.id.wednesdayClass2);
        EditText wednesday3 = (EditText)findViewById(R.id.wednesdayClass3);
        EditText wednesday4 = (EditText)findViewById(R.id.wednesdayClass4);
        EditText wednesday5 = (EditText)findViewById(R.id.wednesdayClass5);

        EditText thursday1 = (EditText)findViewById(R.id.thursdayClass1);
        EditText thursday2 = (EditText)findViewById(R.id.thursdayClass2);
        EditText thursday3 = (EditText)findViewById(R.id.thursdayClass3);
        EditText thursday4 = (EditText)findViewById(R.id.thursdayClass4);
        EditText thursday5 = (EditText)findViewById(R.id.thursdayClass5);

        EditText friday1 = (EditText)findViewById(R.id.fridayClass1);
        EditText friday2 = (EditText)findViewById(R.id.fridayClass2);
        EditText friday3 = (EditText)findViewById(R.id.fridayClass3);
        EditText friday4 = (EditText)findViewById(R.id.fridayClass4);
        EditText friday5 = (EditText)findViewById(R.id.fridayClass5);


        FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        rootnode = FirebaseDatabase.getInstance("https://thu-3f8f6-default-rtdb.europe-west1.firebasedatabase.app/");
        reference = rootnode.getReference().child("timetable").child(currentFirebaseUser.getUid());


        Log.d("Reference tag", String.valueOf(reference));


        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if (snapshot.exists()) {

                    if (!((snapshot.child("monday1").getValue()) == null)) {
                        String mondayClass1 = snapshot.child("monday1").getValue().toString();
                        monday1.setText(mondayClass1, TextView.BufferType.EDITABLE);
                    }

                    if (!((snapshot.child("monday2").getValue()) == null)) {
                        String mondayClass2 = snapshot.child("monday2").getValue().toString();
                        monday2.setText(mondayClass2, TextView.BufferType.EDITABLE);
                    }

                    if (!((snapshot.child("monday3").getValue()) == null)) {
                        String mondayClass3 = snapshot.child("monday3").getValue().toString();
                        monday3.setText(mondayClass3, TextView.BufferType.EDITABLE);
                    }

                    if (!((snapshot.child("monday4").getValue()) == null)) {
                        String mondayClass4 = snapshot.child("monday4").getValue().toString();
                        monday4.setText(mondayClass4, TextView.BufferType.EDITABLE);
                    }

                    if (!((snapshot.child("monday5").getValue()) == null)) {
                        String mondayClass5 = snapshot.child("monday5").getValue().toString();
                        monday5.setText(mondayClass5, TextView.BufferType.EDITABLE);
                    }

                    if (!((snapshot.child("tuesday1").getValue()) == null)) {
                        String tuesdayClass1 = snapshot.child("tuesday1").getValue().toString();
                        tuesday1.setText(tuesdayClass1, TextView.BufferType.EDITABLE);
                    }

                    if (!((snapshot.child("tuesday2").getValue()) == null)) {
                        String tuesdayClass2 = snapshot.child("tuesday2").getValue().toString();
                        tuesday2.setText(tuesdayClass2, TextView.BufferType.EDITABLE);
                    }

                    if (!((snapshot.child("tuesday3").getValue()) == null)) {
                        String tuesdayClass3 = snapshot.child("tuesday3").getValue().toString();
                        tuesday3.setText(tuesdayClass3, TextView.BufferType.EDITABLE);
                    }

                    if (!((snapshot.child("tuesday4").getValue()) == null)) {
                        String tuesdayClass4 = snapshot.child("tuesday4").getValue().toString();
                        tuesday4.setText(tuesdayClass4, TextView.BufferType.EDITABLE);
                    }

                    if (!((snapshot.child("tuesday5").getValue()) == null)) {
                        String tuesdayClass5 = snapshot.child("tuesday5").getValue().toString();
                        tuesday5.setText(tuesdayClass5, TextView.BufferType.EDITABLE);
                    }

                    if (!((snapshot.child("wednesday1").getValue()) == null)) {
                        String wednesdayClass1 = snapshot.child("wednesday1").getValue().toString();
                        wednesday1.setText(wednesdayClass1, TextView.BufferType.EDITABLE);
                    }

                    if (!((snapshot.child("wednesday2").getValue()) == null)) {
                        String wednesdayClass2 = snapshot.child("wednesday2").getValue().toString();
                        wednesday2.setText(wednesdayClass2, TextView.BufferType.EDITABLE);
                    }

                    if (!((snapshot.child("wednesday3").getValue()) == null)) {
                        String wednesdayClass3 = snapshot.child("wednesday3").getValue().toString();
                        wednesday3.setText(wednesdayClass3, TextView.BufferType.EDITABLE);
                    }

                    if (!((snapshot.child("wednesday4").getValue()) == null)) {
                        String wednesdayClass4 = snapshot.child("wednesday4").getValue().toString();
                        wednesday4.setText(wednesdayClass4, TextView.BufferType.EDITABLE);
                    }

                    if (!((snapshot.child("wednesday5").getValue()) == null)) {
                        String wednesdayClass5 = snapshot.child("wednesday5").getValue().toString();
                        wednesday5.setText(wednesdayClass5, TextView.BufferType.EDITABLE);
                    }

                    if (!((snapshot.child("thursday1").getValue()) == null)) {
                        String thursdayClass1 = snapshot.child("thursday1").getValue().toString();
                        thursday1.setText(thursdayClass1, TextView.BufferType.EDITABLE);
                    }

                    if (!((snapshot.child("thursday2").getValue()) == null)) {
                        String thursdayClass2 = snapshot.child("thursday2").getValue().toString();
                        thursday2.setText(thursdayClass2, TextView.BufferType.EDITABLE);
                    }

                    if (!((snapshot.child("thursday3").getValue()) == null)) {
                        String thursdayClass3 = snapshot.child("thursday3").getValue().toString();
                        thursday3.setText(thursdayClass3, TextView.BufferType.EDITABLE);
                    }

                    if (!((snapshot.child("thursday4").getValue()) == null)) {
                        String thursdayClass4 = snapshot.child("thursday4").getValue().toString();
                        thursday4.setText(thursdayClass4, TextView.BufferType.EDITABLE);
                    }

                    if (!((snapshot.child("thursday5").getValue()) == null)) {
                        String thursdayClass5 = snapshot.child("thursday5").getValue().toString();
                        thursday5.setText(thursdayClass5, TextView.BufferType.EDITABLE);
                    }

                    if (!((snapshot.child("friday1").getValue()) == null)) {
                        String fridayClass1 = snapshot.child("friday1").getValue().toString();
                        friday1.setText(fridayClass1, TextView.BufferType.EDITABLE);
                    }

                    if (!((snapshot.child("friday2").getValue()) == null)) {
                        String fridayClass2 = snapshot.child("friday2").getValue().toString();
                        friday2.setText(fridayClass2, TextView.BufferType.EDITABLE);
                    }

                    if (!((snapshot.child("friday3").getValue()) == null)) {
                        String fridayClass3 = snapshot.child("friday3").getValue().toString();
                        friday3.setText(fridayClass3, TextView.BufferType.EDITABLE);
                    }

                    if (!((snapshot.child("friday4").getValue()) == null)) {
                        String fridayClass4 = snapshot.child("friday4").getValue().toString();
                        friday4.setText(fridayClass4, TextView.BufferType.EDITABLE);
                    }

                    if (!((snapshot.child("friday5").getValue()) == null)) {
                        String fridayClass5 = snapshot.child("friday5").getValue().toString();
                        friday5.setText(fridayClass5, TextView.BufferType.EDITABLE);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    /**
     * Get the values inputted by the user of their timetable
     * Save them in the database
     */

    private void saveTimetable() {

        EditText mondayClass1 = findViewById(R.id.mondayClass1);
        EditText mondayClass2 = findViewById(R.id.mondayClass2);
        EditText mondayClass3 = findViewById(R.id.mondayClass3);
        EditText mondayClass4 = findViewById(R.id.mondayClass4);
        EditText mondayClass5 = findViewById(R.id.mondayClass5);


        String monday1 = mondayClass1.getText().toString();
        String monday2 = mondayClass2.getText().toString();
        String monday3 = mondayClass3.getText().toString();
        String monday4 = mondayClass4.getText().toString();
        String monday5 = mondayClass5.getText().toString();

        EditText tuesdayClass1 = findViewById(R.id.tuesdayClass1);
        EditText tuesdayClass2 = findViewById(R.id.tuesdayClass2);
        EditText tuesdayClass3 = findViewById(R.id.tuesdayClass3);
        EditText tuesdayClass4 = findViewById(R.id.tuesdayClass4);
        EditText tuesdayClass5 = findViewById(R.id.tuesdayClass5);

        String tuesday1 = tuesdayClass1.getText().toString();
        String tuesday2 = tuesdayClass2.getText().toString();
        String tuesday3 = tuesdayClass3.getText().toString();
        String tuesday4 = tuesdayClass4.getText().toString();
        String tuesday5 = tuesdayClass5.getText().toString();

        EditText wednesdayClass1 = findViewById(R.id.wednesdayClass1);
        EditText wednesdayClass2 = findViewById(R.id.wednesdayClass2);
        EditText wednesdayClass3 = findViewById(R.id.wednesdayClass3);
        EditText wednesdayClass4 = findViewById(R.id.wednesdayClass4);
        EditText wednesdayClass5 = findViewById(R.id.wednesdayClass5);

        String wednesday1 = wednesdayClass1.getText().toString();
        String wednesday2 = wednesdayClass2.getText().toString();
        String wednesday3 = wednesdayClass3.getText().toString();
        String wednesday4 = wednesdayClass4.getText().toString();
        String wednesday5 = wednesdayClass5.getText().toString();

        EditText thursdayClass1 = findViewById(R.id.thursdayClass1);
        EditText thursdayClass2 = findViewById(R.id.thursdayClass2);
        EditText thursdayClass3 = findViewById(R.id.thursdayClass3);
        EditText thursdayClass4 = findViewById(R.id.thursdayClass4);
        EditText thursdayClass5 = findViewById(R.id.thursdayClass5);

        String thursday1 = thursdayClass1.getText().toString();
        String thursday2 = thursdayClass2.getText().toString();
        String thursday3 = thursdayClass3.getText().toString();
        String thursday4 = thursdayClass4.getText().toString();
        String thursday5 = thursdayClass5.getText().toString();

        EditText fridayClass1 = findViewById(R.id.fridayClass1);
        EditText fridayClass2 = findViewById(R.id.fridayClass2);
        EditText fridayClass3 = findViewById(R.id.fridayClass3);
        EditText fridayClass4 = findViewById(R.id.fridayClass4);
        EditText fridayClass5 = findViewById(R.id.fridayClass5);

        String friday1 = fridayClass1.getText().toString();
        String friday2 = fridayClass2.getText().toString();
        String friday3 = fridayClass3.getText().toString();
        String friday4 = fridayClass4.getText().toString();
        String friday5 = fridayClass5.getText().toString();

        FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        rootnode = FirebaseDatabase.getInstance("https://thu-3f8f6-default-rtdb.europe-west1.firebasedatabase.app/");
        reference = rootnode.getReference("timetable").child(currentFirebaseUser.getUid());

        reference.child("monday1").setValue(monday1);
        reference.child("monday2").setValue(monday2);
        reference.child("monday3").setValue(monday3);
        reference.child("monday4").setValue(monday4);
        reference.child("monday5").setValue(monday5);

        reference.child("tuesday1").setValue(tuesday1);
        reference.child("tuesday2").setValue(tuesday2);
        reference.child("tuesday3").setValue(tuesday3);
        reference.child("tuesday4").setValue(tuesday4);
        reference.child("tuesday5").setValue(tuesday5);

        reference.child("wednesday1").setValue(wednesday1);
        reference.child("wednesday2").setValue(wednesday2);
        reference.child("wednesday3").setValue(wednesday3);
        reference.child("wednesday4").setValue(wednesday4);
        reference.child("wednesday5").setValue(wednesday5);

        reference.child("thursday1").setValue(thursday1);
        reference.child("thursday2").setValue(thursday2);
        reference.child("thursday3").setValue(thursday3);
        reference.child("thursday4").setValue(thursday4);
        reference.child("thursday5").setValue(thursday5);

        reference.child("friday1").setValue(friday1);
        reference.child("friday2").setValue(friday2);
        reference.child("friday3").setValue(friday3);
        reference.child("friday4").setValue(friday4);
        reference.child("friday5").setValue(friday5);

    }
}