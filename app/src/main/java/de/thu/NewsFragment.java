package de.thu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class NewsFragment extends Fragment {
    View view;
    TextView news1, news2, news3;
    TextView news1title, news2title, news3title;
    ImageView img1, img2, img3;
    boolean news1exp = false, news2exp = false, news3exp = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_news, container, false);

        news1 = view.findViewById(R.id.news1text);
        news2 = view.findViewById(R.id.news2text);
        news3 = view.findViewById(R.id.news3text);
        news1title = view.findViewById(R.id.newsTitle1);
        news2title = view.findViewById(R.id.newsTitle2);
        news3title = view.findViewById(R.id.newsTitle3);
        img1 = view.findViewById(R.id.photoNews1);
        img2 = view.findViewById(R.id.photoNews2);
        img3 = view.findViewById(R.id.photoNews3);
        img1.setClickable(true);
        img2.setClickable(true);
        img3.setClickable(true);

        news1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(news1exp){
                    news1exp = false;
                    news1.setText(getResources().getText(R.string.coronaNewsNotExpanded));
                }else{
                    news1exp = true;
                    news1.setText(getResources().getText(R.string.coronaNewsExpanded));
                }
            }
        });
        news1title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(news1exp){
                    news1exp = false;
                    news1.setText(getResources().getText(R.string.coronaNewsNotExpanded));
                }else{
                    news1exp = true;
                    news1.setText(getResources().getText(R.string.coronaNewsExpanded));
                }
            }
        });
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(news1exp){
                    news1exp = false;
                    news1.setText(getResources().getText(R.string.coronaNewsNotExpanded));
                }else{
                    news1exp = true;
                    news1.setText(getResources().getText(R.string.coronaNewsExpanded));
                }
            }
        });

        news2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(news2exp){
                    news2exp = false;
                    news2.setText(getResources().getText(R.string.serviceRoboticsNotExpanded));
                }else{
                    news2exp = true;
                    news2.setText(getResources().getText(R.string.serviceRoboticsExpanded));
                }
            }
        });
        news2title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(news2exp){
                    news2exp = false;
                    news2.setText(getResources().getText(R.string.serviceRoboticsNotExpanded));
                }else{
                    news2exp = true;
                    news2.setText(getResources().getText(R.string.serviceRoboticsExpanded));
                }
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(news2exp){
                    news2exp = false;
                    news2.setText(getResources().getText(R.string.serviceRoboticsNotExpanded));
                }else{
                    news2exp = true;
                    news2.setText(getResources().getText(R.string.serviceRoboticsExpanded));
                }
            }
        });

        news3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(news3exp){
                    news3exp = false;
                    news3.setText(getResources().getText(R.string.newCampusNotExpanded));
                }else{
                    news3exp = true;
                    news3.setText(getResources().getText(R.string.newCampusExpanded));
                }
            }
        });
        news3title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(news3exp){
                    news3exp = false;
                    news3.setText(getResources().getText(R.string.newCampusNotExpanded));
                }else{
                    news3exp = true;
                    news3.setText(getResources().getText(R.string.newCampusExpanded));
                }
            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(news3exp){
                    news3exp = false;
                    news3.setText(getResources().getText(R.string.newCampusNotExpanded));
                }else{
                    news3exp = true;
                    news3.setText(getResources().getText(R.string.newCampusExpanded));
                }
            }
        });



        return view;
    }
}


// getting reference of ExpandableTextView
//        ExpandableTextView expTextViewCoronaLargeText = (ExpandableTextView) view.findViewById(R.id.expand_text_view1).findViewById(R.id.expand_text_view1);
//
//        // calling setText on the ExpandableTextView so that
//        // text content will be displayed to the user
//        expTextViewCoronaLargeText.setText(getString(R.string.coronaNewsLargeText));
//
//        ExpandableTextView expTextViewRoboticsLargeText = (ExpandableTextView) view.findViewById(R.id.expand_text_view2).findViewById(R.id.expand_text_view2);
//        expTextViewRoboticsLargeText.setText(getString(R.string.serviceRoboticsLargeText));
//
////        ExpandableTextView expTextViewRoboticsLargeText = (ExpandableTextView) view.findViewById(R.id.expand_text_view2).findViewById(R.id.expand_text_view2);
////        expTextViewCoronaLargeText.setText(getString(R.string.serviceRoboticsLargeText));