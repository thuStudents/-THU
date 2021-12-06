package de.thu;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class ServicesCardActivity extends AppCompatActivity {
    TextView news1 ;
    TextView news2;
    TextView news3;
    TextView news4;
    TextView news5;
    TextView news6;
    TextView news7;
    TextView news8;
    TextView news9;
    TextView news10;
    TextView news1title ;
    TextView news2title;
    TextView news3title;
    TextView news4title;
    TextView news5title;
    TextView news6title;
    TextView news7title;
    TextView news8title;
    TextView news9title;
    TextView news10title;
    boolean news1exp = false;
    boolean news2exp = false;
    boolean news3exp = false;
    boolean news4exp = false;
    boolean news5exp = false;
    boolean news6exp = false;
    boolean news7exp = false;
    boolean news8exp = false;
    boolean news9exp = false;
    boolean news10exp = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services_card);
        news1 = findViewById(R.id.studentIdText);
        news2 = findViewById(R.id.uniAccountText);
        news3 = findViewById(R.id.emailText);
        news4 = findViewById(R.id.wifiText);
        news5 = findViewById(R.id.remoteAppText);
        news6 = findViewById(R.id.vpnText);
        news7 = findViewById(R.id.softwareForStudentsText);
        news8 = findViewById(R.id.lsfText);
        news9 = findViewById(R.id.selfServiceFunctionsText);
        news10 = findViewById(R.id.eLearningText);
        news1title = findViewById(R.id.StudentIdTitle);
        news2title = findViewById(R.id.uniAccountTitle);
        news3title = findViewById(R.id.emailTitle);
        news4title = findViewById(R.id.wifiTitle);
        news5title = findViewById(R.id.remoteAppTitle);
        news6title = findViewById(R.id.vpnTitle);
        news7title = findViewById(R.id.softwareForStudentsTitle);
        news8title = findViewById(R.id.lsfTitle);
        news9title = findViewById(R.id.selfServiceFunctionsTitle);
        news10title = findViewById(R.id.eLearningTitle);
        news1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(news1exp){
                    news1exp = false;
                    news1.setText(getResources().getText(R.string.StudentIdCardNotExpanded));
                }else{
                    news1exp = true;
                    news1.setText(getResources().getText(R.string.StudentIdExpanded));
                }
            }
        });
        news1title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(news1exp){
                    news1exp = false;
                    news1.setText(getResources().getText(R.string.StudentIdCardNotExpanded));
                }else{
                    news1exp = true;
                    news1.setText(getResources().getText(R.string.StudentIdExpanded));
                }
            }
        });

        news2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(news2exp){
                    news2exp = false;
                    news2.setText(getResources().getText(R.string.uniAccountNotExpanded));
                }else{
                    news2exp = true;
                    news2.setText(getResources().getText(R.string.uniAccountExpanded));
                }
            }
        });
        news2title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(news2exp){
                    news2exp = false;
                    news2.setText(getResources().getText(R.string.uniAccountNotExpanded));
                }else{
                    news2exp = true;
                    news2.setText(getResources().getText(R.string.uniAccountExpanded));
                }
            }
        });
        news3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(news3exp){
                    news3exp = false;
                    news3.setText(getResources().getText(R.string.emailNotExpanded));
                }else{
                    news3exp = true;
                    news3.setText(getResources().getText(R.string.emailExpanded));
                }
            }
        });
        news3title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(news3exp){
                    news3exp = false;
                    news3.setText(getResources().getText(R.string.emailNotExpanded));
                }else{
                    news3exp = true;
                    news3.setText(getResources().getText(R.string.emailExpanded));
                }
            }
        });
        news4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(news4exp){
                    news4exp = false;
                    news4.setText(getResources().getText(R.string.wifiNotExpanded));
                }else{
                    news4exp = true;
                    news4.setText(getResources().getText(R.string.wifiExpanded));
                }
            }
        });
        news4title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(news4exp){
                    news4exp = false;
                    news4.setText(getResources().getText(R.string.wifiNotExpanded));
                }else{
                    news4exp = true;
                    news4.setText(getResources().getText(R.string.wifiExpanded));
                }
            }
        });

        news5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(news5exp){
                    news5exp = false;
                    news5.setText(getResources().getText(R.string.remoteAppNotExpanded));
                }else{
                    news5exp = true;
                    news5.setText(getResources().getText(R.string.remoteAppExpanded));
                }
            }
        });
        news5title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(news5exp){
                    news5exp = false;
                    news5.setText(getResources().getText(R.string.remoteAppNotExpanded));
                }else{
                    news5exp = true;
                    news5.setText(getResources().getText(R.string.remoteAppExpanded));
                }
            }
        });

        news6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(news6exp){
                    news6exp = false;
                    news6.setText(getResources().getText(R.string.vpnNotExpanded));
                }else{
                    news6exp = true;
                    news6.setText(getResources().getText(R.string.vpnExpanded));
                }
            }
        });
        news6title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(news6exp){
                    news6exp = false;
                    news6.setText(getResources().getText(R.string.vpnNotExpanded));
                }else{
                    news6exp = true;
                    news6.setText(getResources().getText(R.string.vpnExpanded));
                }
            }
        });
        news7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(news7exp){
                    news7exp = false;
                    news7.setText(getResources().getText(R.string.softwareForStudentNotExpanded));
                }else{
                    news7exp = true;
                    news7.setText(getResources().getText(R.string.softwareForStudentExpanded));
                }
            }
        });
        news7title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(news7exp){
                    news7exp = false;
                    news7.setText(getResources().getText(R.string.softwareForStudentNotExpanded));
                }else{
                    news7exp = true;
                    news7.setText(getResources().getText(R.string.softwareForStudentExpanded));
                }
            }
        });

        news8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(news8exp){
                    news8exp = false;
                    news8.setText(getResources().getText(R.string.lsfNotExpanded));
                }else{
                    news8exp = true;
                    news8.setText(getResources().getText(R.string.lsfExpanded));
                }
            }
        });
        news8title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(news8exp){
                    news8exp = false;
                    news8.setText(getResources().getText(R.string.lsfNotExpanded));
                }else{
                    news8exp = true;
                    news8.setText(getResources().getText(R.string.lsfExpanded));
                }
            }
        });
        news9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(news9exp){
                    news9exp = false;
                    news9.setText(getResources().getText(R.string.selfServiceFunctionsNotExpanded));
                }else{
                    news9exp = true;
                    news9.setText(getResources().getText(R.string.selfServiceFunctionsExpanded));
                }
            }
        });
        news9title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(news9exp){
                    news9exp = false;
                    news9.setText(getResources().getText(R.string.selfServiceFunctionsNotExpanded));
                }else{
                    news9exp = true;
                    news9.setText(getResources().getText(R.string.selfServiceFunctionsExpanded));
                }
            }
        });

        news10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(news10exp){
                    news10exp = false;
                    news10.setText(getResources().getText(R.string.eLearningNotExpanded));
                }else{
                    news10exp = true;
                    news10.setText(getResources().getText(R.string.eLearningExpanded));
                }
            }
        });
        news10title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(news10exp){
                    news10exp = false;
                    news10.setText(getResources().getText(R.string.eLearningNotExpanded));
                }else{
                    news10exp = true;
                    news10.setText(getResources().getText(R.string.eLearningExpanded));
                }
            }
        });




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

    }
}