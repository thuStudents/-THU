package de.thu.hochschule;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import de.thu.R;

public class CafeteriaFragment extends Fragment {

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        /** Inflate the layout for this fragment
         */
        view = inflater.inflate(R.layout.fragment_cafeteria, container, false);

        return view;
    }
}