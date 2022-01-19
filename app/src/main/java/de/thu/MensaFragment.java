package de.thu;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class MensaFragment extends Fragment {

    View view;

    TextView viewLink;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        /**Inflate the layout for this fragment
         *
         */
        view = inflater.inflate(R.layout.fragment_mensa, container, false);

        viewLink =  view.findViewById(R.id.forthParagraph);

        /**
         * New intent is created if the clickable link is clicked.
         * It redirects the user to the corresponding webpage.
         */
        viewLink.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://studierendenwerk-ulm.de/en/food-and-drink/menus/"));

                //Set flag
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                //START ACTIVITY
                startActivity(intent);


            }});

        return view;



    }

}