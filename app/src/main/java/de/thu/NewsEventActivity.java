package de.thu;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class NewsEventActivity extends AppCompatActivity {

    Button newsBtn, eventsBtn;
    EventsFragment eventFrg;
    NewsFragment newsFrg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_event);
        newsBtn = findViewById(R.id.newsFragmentbtn);
        eventsBtn = findViewById(R.id.eventsFragmentbtn);
        eventFrg = new EventsFragment();
        newsFrg = new NewsFragment();
        replaceFragment(newsFrg);


        newsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newsBtn.setBackground(getResources().getDrawable(R.drawable.news_selected_button));
                newsBtn.setTextColor(getResources().getColor(R.color.white));
                eventsBtn.setBackground(getResources().getDrawable(R.drawable.events_notselected_button));
                eventsBtn.setTextColor(getResources().getColor(R.color.thuColor));
                replaceFragment(newsFrg);
            }
        });

        eventsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newsBtn.setBackground(getResources().getDrawable(R.drawable.news_notselected_button));
                newsBtn.setTextColor(getResources().getColor(R.color.thuColor));
                eventsBtn.setBackground(getResources().getDrawable(R.drawable.events_selected_button));
                eventsBtn.setTextColor(getResources().getColor(R.color.white));
                replaceFragment(eventFrg);
            }
        });

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
    }

    private void replaceFragment(Fragment fragment) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.commit();
    }
}


//
//    AppCompatRadioButton newsButton, eventsButton;
//    EventsFragment fragment_event;
//    NewsFragment fragment_news;
//    RadioGroup toggleButton;
//    FragmentManager manager;
//    FragmentTransaction transaction;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_news_event);
//
//        newsButton = findViewById(R.id.newsButton);
//        eventsButton = findViewById(R.id.eventsButton);
//        toggleButton = findViewById(R.id.togglebutton);
//        fragment_event = new EventsFragment();
//        fragment_news = new NewsFragment();
////        manager = getSupportFragmentManager();
////        transaction=manager.beginTransaction();
////        transaction.add(R.id.newsFragment, fragment_news, "FragmentNews");
////        transaction.add(R.id.eventsFragment, fragment_event, "FragmentEvents");
//        //transaction.commit();
//    }
//
//    public void onToggleButtonClicked(View view){
//        boolean isSelected = ((AppCompatRadioButton) view).isChecked();
//        switch(view.getId()){
//            case R.id.newsButton:
//                if(isSelected){
//                    Toast.makeText(NewsEventActivity.this, "News", Toast.LENGTH_SHORT).show();
//                    newsButton.setTextColor(Color.WHITE);
//                    eventsButton.setTextColor(getResources().getColor(R.color.thuColor));
//                   replaceFragment(fragment_news);
//                    //transaction.show(manager.findFragmentByTag("FragmentNews")).commit();
////                    if(manager.findFragmentByTag("FragmentNews") != null) {
////                        //if the fragment exists, show it.
////                        manager.beginTransaction().show(manager.findFragmentByTag("FragmentNews")).commit();
////                    } else {
////                        //if the fragment does not exist, add it to fragment manager.
////                        manager.beginTransaction().add(R.id.container, fragment_news, "FragmentNews").commit();
////                    }
////                    if(manager.findFragmentByTag("FragmentEvents") != null){
////                        //if the other fragment is visible, hide it.
////                        manager.beginTransaction().hide(manager.findFragmentByTag("FragmentEvents")).commit();
////                    }
////                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
////                    if(getSupportFragmentManager().findFragmentByTag("FragmentEvents") != null ){
////                        fragmentTransaction.detach(getSupportFragmentManager().findFragmentByTag("FragmentEvents"));
////                    }
////                    fragmentTransaction.attach(fragment_news);
////                    fragmentTransaction.addToBackStack(null);
////                    fragmentTransaction.commitAllowingStateLoss();
////                    getSupportFragmentManager().executePendingTransactions();
//                }
//                break;
//            case R.id.eventsButton:
//                if(isSelected) {
//                    Toast.makeText(NewsEventActivity.this, "Event", Toast.LENGTH_SHORT).show();
//                    eventsButton.setTextColor(Color.WHITE);
//                    newsButton.setTextColor(getResources().getColor(R.color.thuColor));
//                    replaceFragment(fragment_event);
//                    //transaction.show(manager.findFragmentByTag("FragmentEvents")).commit()
////                if(manager.findFragmentByTag("FragmentEvents") != null) {
////                    //if the fragment exists, show it.
////                    manager.beginTransaction().show(manager.findFragmentByTag("FragmentEvents")).commit();
////                } else {
////                    //if the fragment does not exist, add it to fragment manager.
////                    manager.beginTransaction().add(R.id.container, fragment_news, "FragmentEvents").commit();
////                }
////                if(manager.findFragmentByTag("FragmentNews") != null){
////                    //if the other fragment is visible, hide it.
////                    manager.beginTransaction().hide(manager.findFragmentByTag("FragmentNews")).commit();
////                }
////                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
////                    if(getSupportFragmentManager().findFragmentByTag("FragmentNews") != null ){
////                        fragmentTransaction.detach(getSupportFragmentManager().findFragmentByTag("FragmentNews"));
////                    }                    fragmentTransaction.attach(fragment_event);
////                    fragmentTransaction.addToBackStack(null);
////                    fragmentTransaction.commitAllowingStateLoss();
////                    getSupportFragmentManager().executePendingTransactions();
//                }
//                break;
//            default:
//                break;
//        }
//    }
//
//    private void replaceFragment(Fragment fragment) {
//
//
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.replace(R.id.frameLayout,fragment);
//        Toast.makeText(NewsEventActivity.this, "I dont work", Toast.LENGTH_SHORT).show();
//        fragmentTransaction.commit();
//
//    }
//}