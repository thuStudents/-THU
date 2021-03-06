package de.thu.newsEvents;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.util.Calendar;

import de.thu.R;

public class EventsFragment extends Fragment {

     View view;
     Calendar c;
     CalendarView cv;
     TextView event;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        /**
         * Inflate the layout for this fragment
         */
        view = inflater.inflate(R.layout.fragment_events, container, false);
        event = view.findViewById(R.id.eventText);

        /**
         * Get a calendar Instance.
         * Get the calendar view from our layout.
         * Set the minimum date to today's date.
         * Set the event text for today's date.
         * If a date was selected, show the selected day event text.
         */
        c = Calendar.getInstance();
        cv = view.findViewById(R.id.calendarView);
        cv.setMinDate(c.getTimeInMillis());
        setEventText(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DATE));

        cv.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int day) {
                setEventText(year, month, day);
            }
        });

        return view;
    }

    /**
     * This method takes 3 parameters which specify the date.
     * The events for this release were hardcoded.
     * Each event is set in one of the cases of the switch statement
     * This method is called if an event is selected.
     * In each case it will show a message about the event.
     * Otherwise it will simply show No Event.
     * @param year
     * @param month
     * @param dayOfMonth
     */
    private void setEventText(int year, int month, int dayOfMonth) {
        int date = year*10000 + month*100 + dayOfMonth;
        switch(date){
            case 20211015:
                event.setText("Start of period for withdrawing from examinations");
                break;
            case 20211123:
                event.setText("Last teaching day before Christmas");
                break;
            case 20220009:
                event.setText("End of period for withdrawing from examinations");
                break;
            case 20220010:
                event.setText("First teaching day after Christmas");
                break;
            case 20220021:
                event.setText("Last day of lectures in the winter semester and submission deadline for coursework and laboratory work");
                break;
            case 20220022:
                event.setText("Start of examination period");
                break;
            case 20220111:
                event.setText("End of examination period");
                break;
            case 20220114:
                event.setText("Deadline for entering grades into the system for the final semester");
                break;
            case 20220115:
                event.setText("Deadline for entering grades into the system");
                break;
            case 20220116:
                event.setText("Deadline for submitting applications to the examination committee");
                break;
            case 20220118:
                event.setText("Academic graduation ceremony in the Aula and awarding of diplomas");
                break;
            case 20220128:
                event.setText("End of the Winter Semester");
                break;
            default:
                event.setText("No Event");
                break;
        }
    }
}
