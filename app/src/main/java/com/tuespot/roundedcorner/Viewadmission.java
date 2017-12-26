package com.tuespot.roundedcorner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Viewadmission extends AppCompatActivity {

    ImageButton Rollno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewadmission);

        Rollno = (ImageButton) findViewById(R.id.searchrollno);

        Rollno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Viewadmission.this, Viewadmissionstudent.class);
                startActivity(i);

            }
        });
    }
}
