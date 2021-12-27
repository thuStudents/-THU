package de.thu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class AddNewTaskFragment extends Fragment {
    View view;
    Button savebtn;
    EditText newTaskText;
    TextView dateText, taskText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_add_new_task, container, false);

        savebtn = view.findViewById(R.id.newTaskButton);


        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToDoActivity activity = (ToDoActivity) getActivity();
                activity.showButton();
                view.setVisibility(View.GONE);
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        savebtn = view.findViewById(R.id.newTaskButton);
        newTaskText = view.findViewById(R.id.newTaskText);
//        dateText = view.


    }
}