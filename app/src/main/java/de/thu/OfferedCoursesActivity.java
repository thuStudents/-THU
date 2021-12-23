package de.thu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class OfferedCoursesActivity extends AppCompatActivity {
    Button CourseScheduleCtsBtn, PrequisitesCtsBtn;
    CardView CourseScheduleCardCtsCard, PrequisitesCtsCard;
    ImageView CourseScheduleCtsImage;
    TextView PrequisitesTitleCts, PrequisitesTextCts;
    Button CourseScheduleEnergyInformationManagementBtn, PrequisitesEnergyInformationManagementBtn;
    CardView CourseScheduleCardEnergyInformationManagementCard, PrequisitesEnergyInformationManagementCard;
    ImageView CourseScheduleEnergyInformationManagementImage;
    TextView PrequisitesTitleEnergyInformationManagement, PrequisitesTextEnergyInformationManagement;
    Button CourseScheduleIntelligentSystemsBtn, PrequisitesIntelligentSystemsBtn;
    CardView CourseScheduleCardIntelligentSystemsCard, PrequisitesIntelligentSystemsCard;
    ImageView CourseScheduleIntelligentSystemsImage;
    TextView PrequisitesTitleIntelligentSystems, PrequisitesTextIntelligentSystems;
    Button PrequisitesEnergyEconomicsBtn;
    CardView PrequisitesEnergyEconomicsCard;
    TextView PrequisitesTitleEnergyEconomics, PrequisitesTextEnergyEconomics;
    Button CourseScheduleInternationalEnergyManagementBtn, PrequisitesInternationalEnergyManagementBtn;
    CardView CourseScheduleCardInternationalEnergyManagementCard, PrequisitesInternationalEnergyManagementCard;
    ImageView CourseScheduleInternationalEnergyManagementImage;
    TextView PrequisitesTitleInternationalEnergyManagement, PrequisitesTextInternationalEnergyManagement;
    Button PrequisitesSystemsEngineeringAndManagementBtn;
    CardView PrequisitesSystemsEngineeringAndManagementCard;
    TextView PrequisitesTitleSystemsEngineeringAndManagement, PrequisitesTextSystemsEngineeringAndManagement;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offered_courses);

        //ComputerScience
        CourseScheduleCtsBtn = findViewById(R.id.CourseScheduleComputerScienceButton);
        CourseScheduleCardCtsCard = findViewById(R.id.computerScienceMiniCard1);
        CourseScheduleCtsImage = findViewById(R.id.schedule_image);
        CourseScheduleCtsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CourseScheduleCardCtsCard.setVisibility(View.VISIBLE);
            }
        });
        CourseScheduleCardCtsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CourseScheduleCardCtsCard.setVisibility(View.GONE);
            }
        });
        CourseScheduleCtsImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CourseScheduleCardCtsCard.setVisibility(View.GONE);
            }
        });
        PrequisitesCtsBtn = findViewById(R.id.PrequisitiesComputerScienceButton);
        PrequisitesCtsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PrequisitesCtsCard.setVisibility(View.VISIBLE);
            }
        });
        PrequisitesCtsCard = findViewById(R.id.computerScienceMiniCard2);
        PrequisitesTitleCts = findViewById(R.id.computerSciencePrequisities);
        PrequisitesTextCts = findViewById(R.id.computerSciencePrequisities2);
        PrequisitesCtsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PrequisitesCtsCard.setVisibility(View.GONE);
            }
        });
        PrequisitesTitleCts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PrequisitesCtsCard.setVisibility(View.GONE);
            }
        });
        PrequisitesTextCts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PrequisitesCtsCard.setVisibility(View.GONE);
            }
        });

        //EnergyManagementInformation

        CourseScheduleEnergyInformationManagementBtn = findViewById(R.id.CourseScheduleEnergyInformationManagementButton);
        CourseScheduleCardEnergyInformationManagementCard = findViewById(R.id.energyInformationManagementMiniCard1);
        CourseScheduleEnergyInformationManagementImage = findViewById(R.id.schedule2_image);
        CourseScheduleEnergyInformationManagementBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CourseScheduleCardEnergyInformationManagementCard.setVisibility(View.VISIBLE);
            }
        });
        CourseScheduleCardEnergyInformationManagementCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CourseScheduleCardEnergyInformationManagementCard.setVisibility(View.GONE);
            }
        });
        CourseScheduleEnergyInformationManagementImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CourseScheduleCardEnergyInformationManagementCard.setVisibility(View.GONE);
            }
        });
        PrequisitesEnergyInformationManagementBtn = findViewById(R.id.PrequisitiesEnergyInformationManagementButton);
        PrequisitesEnergyInformationManagementBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PrequisitesEnergyInformationManagementCard.setVisibility(View.VISIBLE);
            }
        });
        PrequisitesEnergyInformationManagementCard = findViewById(R.id.energyInformationManagementMiniCard2);
        PrequisitesTitleEnergyInformationManagement = findViewById(R.id.energyInformationManagementPrequisities);
        PrequisitesTextEnergyInformationManagement = findViewById(R.id.energyInformationManagementPrequisitiesText);
        PrequisitesEnergyInformationManagementCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PrequisitesEnergyInformationManagementCard.setVisibility(View.GONE);
            }
        });
        PrequisitesTitleEnergyInformationManagement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PrequisitesEnergyInformationManagementCard.setVisibility(View.GONE);
            }
        });
        PrequisitesTextEnergyInformationManagement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PrequisitesEnergyInformationManagementCard.setVisibility(View.GONE);
            }
        });

        //IntelligentSystem

        CourseScheduleIntelligentSystemsBtn = findViewById(R.id.CourseScheduleIntelligentSystemsButton);
        CourseScheduleCardIntelligentSystemsCard = findViewById(R.id.intelligentSystemsMiniCard1);
        CourseScheduleIntelligentSystemsImage = findViewById(R.id.schedule3_image);
        CourseScheduleIntelligentSystemsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CourseScheduleCardIntelligentSystemsCard.setVisibility(View.VISIBLE);
            }
        });
        CourseScheduleCardIntelligentSystemsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CourseScheduleCardIntelligentSystemsCard.setVisibility(View.GONE);
            }
        });
        CourseScheduleIntelligentSystemsImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CourseScheduleCardIntelligentSystemsCard.setVisibility(View.GONE);
            }
        });
        PrequisitesIntelligentSystemsBtn = findViewById(R.id.PrequisitesIntelligentSystemsButton);
        PrequisitesIntelligentSystemsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PrequisitesIntelligentSystemsCard.setVisibility(View.VISIBLE);
            }
        });
        PrequisitesIntelligentSystemsCard = findViewById(R.id.intelligentSystemsMiniCard2);
        PrequisitesTitleIntelligentSystems = findViewById(R.id.intelligentSystemsPrequisitiesTitle);
        PrequisitesTextIntelligentSystems = findViewById(R.id.intelligentSystemsPrequisitiesText);
        PrequisitesIntelligentSystemsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PrequisitesIntelligentSystemsCard.setVisibility(View.GONE);
            }
        });
        PrequisitesTitleIntelligentSystems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PrequisitesIntelligentSystemsCard.setVisibility(View.GONE);
            }
        });
        PrequisitesTextIntelligentSystems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PrequisitesIntelligentSystemsCard.setVisibility(View.GONE);
            }
        });

        //EnergyEconomics
        PrequisitesEnergyEconomicsBtn = findViewById(R.id.PrequisitesInternationalEnergyEconomicsButton);
        PrequisitesEnergyEconomicsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PrequisitesEnergyEconomicsCard.setVisibility(View.VISIBLE);
            }
        });
        PrequisitesEnergyEconomicsCard = findViewById(R.id.internationalEnergyEconomicsMiniCard1);
        PrequisitesTitleEnergyEconomics = findViewById(R.id.internationalEnergyEconomicsPrequisitiesTitle);
        PrequisitesTextEnergyEconomics = findViewById(R.id.internationalEnergyEconomicsPrequisitiesText);
        PrequisitesEnergyEconomicsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PrequisitesEnergyEconomicsCard.setVisibility(View.GONE);
            }
        });
        PrequisitesTitleEnergyEconomics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PrequisitesEnergyEconomicsCard.setVisibility(View.GONE);
            }
        });
        PrequisitesTextEnergyEconomics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PrequisitesEnergyEconomicsCard.setVisibility(View.GONE);
            }
        });

        //InternationalEnergyManagement

        CourseScheduleInternationalEnergyManagementBtn = findViewById(R.id.CourseScheduleInternationalEnergyManagementButton);
        CourseScheduleCardInternationalEnergyManagementCard = findViewById(R.id.internationalEnergyManagementMiniCard1);
        CourseScheduleInternationalEnergyManagementImage = findViewById(R.id.schedule4_image);
        CourseScheduleInternationalEnergyManagementBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CourseScheduleCardInternationalEnergyManagementCard.setVisibility(View.VISIBLE);
            }
        });
        CourseScheduleCardInternationalEnergyManagementCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CourseScheduleCardInternationalEnergyManagementCard.setVisibility(View.GONE);
            }
        });
        CourseScheduleInternationalEnergyManagementImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CourseScheduleCardInternationalEnergyManagementCard.setVisibility(View.GONE);
            }
        });
        PrequisitesInternationalEnergyManagementBtn = findViewById(R.id.PrequisitesInternationalEnergyManagementButton);
        PrequisitesInternationalEnergyManagementBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PrequisitesInternationalEnergyManagementCard.setVisibility(View.VISIBLE);
            }
        });
        PrequisitesInternationalEnergyManagementCard = findViewById(R.id.internationalEnergyManagementMiniCard2);
        PrequisitesTitleInternationalEnergyManagement = findViewById(R.id.internationalEnergyManagementPrequisities);
        PrequisitesTextInternationalEnergyManagement = findViewById(R.id.internationalEnergyManagementPrequisitiesText);
        PrequisitesInternationalEnergyManagementCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PrequisitesInternationalEnergyManagementCard.setVisibility(View.GONE);
            }
        });
        PrequisitesTitleInternationalEnergyManagement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PrequisitesInternationalEnergyManagementCard.setVisibility(View.GONE);
            }
        });
        PrequisitesTextInternationalEnergyManagement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PrequisitesInternationalEnergyManagementCard.setVisibility(View.GONE);
            }
        });

       //SystemsEngineeringAndManagement

        PrequisitesSystemsEngineeringAndManagementBtn = findViewById(R.id.PrequisitesSystemsEngineeringAndManagementButton);
        PrequisitesSystemsEngineeringAndManagementBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PrequisitesSystemsEngineeringAndManagementCard.setVisibility(View.VISIBLE);
            }
        });
        PrequisitesSystemsEngineeringAndManagementCard = findViewById(R.id.internationalEnergyEconomicsMiniCard1);
        PrequisitesTitleSystemsEngineeringAndManagement = findViewById(R.id.systemsEngineeringAndManagementPrequisitiesTitle);
        PrequisitesTextSystemsEngineeringAndManagement = findViewById(R.id.systemsEngineeringAndManagementPrequisitiesText);
        PrequisitesSystemsEngineeringAndManagementCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PrequisitesSystemsEngineeringAndManagementCard.setVisibility(View.GONE);
            }
        });
        PrequisitesTitleSystemsEngineeringAndManagement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PrequisitesSystemsEngineeringAndManagementCard.setVisibility(View.GONE);
            }
        });
        PrequisitesTextSystemsEngineeringAndManagement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PrequisitesSystemsEngineeringAndManagementCard.setVisibility(View.GONE);
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