package com.tuespot.roundedcorner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Mainlogin extends AppCompatActivity {
    Button student,staff,center;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainlogin);

        student = (Button)findViewById(R.id.studentlogin);
        staff = (Button)findViewById(R.id.stafflogin);
        center = (Button)findViewById(R.id.centerlogin);
        student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Mainlogin.this, MainActivity.Studentlogin.class);
                startActivity(i);

            }
        });

        staff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Mainlogin.this, Stafflogin.class);
                startActivity(i);

            }
        });

        center.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Mainlogin.this, Centerlogin.class);
                startActivity(i);

            }
        });

    }
}
