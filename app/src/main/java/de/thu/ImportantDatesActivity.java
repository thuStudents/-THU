package de.thu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CalendarView;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class ImportantDatesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_important_dates);

        Calendar c = Calendar.getInstance();
        CalendarView cv = (CalendarView)findViewById(R.id.calendarView);
        cv.setMinDate(c.getTimeInMillis());
    }
}