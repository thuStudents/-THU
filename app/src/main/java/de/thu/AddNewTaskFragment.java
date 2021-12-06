package de.thu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class AddNewTaskFragment extends Fragment {
    View view;
    static boolean removeFragmentAddTask = true;
    Button savebtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_add_new_task, container, false);

        savebtn = view.findViewById(R.id.newTaskButton);

        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeFragmentAddTask = true;
                view.setVisibility(View.GONE);
            }
        });

        return view;
    }
}