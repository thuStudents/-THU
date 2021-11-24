package de.thu;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class ImportantLinksActivity extends AppCompatActivity {

    //Initialize variable
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_important_links);

        //Assign variable
        textView = (TextView) findViewById(R.id.text_view);

        //Initialize spannable string
        SpannableString spannableString = new SpannableString("THU Website\n\nOR\n\nGrades Overview\n\nOR\n\nE-Learning\n\nOR\n\nWebmail");

        //Initialize clickable span
        ClickableSpan span1 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                //Initialize intent
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://studium.hs-ulm.de"));

                //Set flag
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                //START ACTIVITY
                startActivity(intent);

            }

        };


        //Initialize clickable span

        ClickableSpan span2 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                //Initialize intent
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.verwaltung.hs-ulm.de/studieren/rds?state=user&type=0"));
                //Set flag
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                //Start activity
                startActivity(intent);


            }
        };

            ClickableSpan span3 = new ClickableSpan() {
                @Override
                public void onClick(@NonNull View view) {
                    //Initialize intent
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://moodle-thu.de/login/index.php"));
                    //Set flag
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    //Start activity
                    startActivity(intent);

                }
            };

        ClickableSpan span4 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                //Initialize intent
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://webmail.hs-ulm.de/"));
                //Set flag
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                //Start activity
                startActivity(intent);

            }
        };


        //Set span
        spannableString.setSpan(span1,0,11, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(span2,15,33, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(span3,38,48, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(span4,54,61, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);


        //Set text
        textView.setText(spannableString);
        //Set link movement method
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }
}