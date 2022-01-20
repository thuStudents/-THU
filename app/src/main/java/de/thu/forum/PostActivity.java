package de.thu.forum;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.Calendar;

import de.thu.HomeActivity;
import de.thu.R;
import de.thu.WelcomeActivity;
import de.thu.hochschule.ApplyingActivity;
import de.thu.profile.Profile;

public class PostActivity extends AppCompatActivity  implements View.OnClickListener{

    Button btnAdd;
    FirebaseDatabase rootnode;
    DatabaseReference reference;
    FirebaseAuth mAuth;
    Random rand = new Random();
    private NewPostNotifier newPostNotifier;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        btnAdd = findViewById(R.id.add_post_btn);
        btnAdd.setOnClickListener(this);
        newPostNotifier = new NewPostNotifier(this);


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.find:
                        if(WelcomeActivity.signedAsGuest!=true){
                            startActivity(new Intent(getApplicationContext()
                                    , Profile.class));
                        } else {
                            Toast.makeText(PostActivity.this, "You are not Logged In", Toast.LENGTH_SHORT).show();
                        }
                        return true;
                    case R.id.add:
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
    }

    /**
     * Function to create a table object in the database for the post
     * Get the value in the editText
     * Send them to the database
     */

    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.add_post_btn:
                //add the post and go back to activity
                EditText editText = findViewById(R.id.add_post_txt);
                String value = editText.getText().toString();
                FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser();


                rootnode = FirebaseDatabase.getInstance("https://thu-3f8f6-default-rtdb.europe-west1.firebasedatabase.app/");
                reference = rootnode.getReference("posts");
                int random = (int) (Math.random() * 50 + 1);

                String currentDate = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(new Date());
                int mSec = calendar.get(Calendar.MILLISECOND);

                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                String str = sdf.format(new Date());

                reference.child(currentFirebaseUser.getUid() + mSec).child("post").setValue(value);
                reference.child(currentFirebaseUser.getUid() + mSec).child("date").setValue(currentDate + " " + str);
                reference.child(currentFirebaseUser.getUid() + mSec).child("email").setValue(currentFirebaseUser.getEmail());
                reference.child(currentFirebaseUser.getUid() + mSec).child("id").setValue(currentFirebaseUser.getUid() + mSec);

                newPostNotifier.showNotification();

                Intent intent = new Intent(PostActivity.this, ForumActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

                break;
            default:
                break;
        }

    }
}
