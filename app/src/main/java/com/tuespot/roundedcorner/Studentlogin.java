package com.tuespot.roundedcorner;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public  class Studentlogin extends AppCompatActivity {
    //Defining views



    private EditText Estudentroll,Estudentname,Estudentdob;



    //boolean variable to check user is logged in or not
    //initially it is false
    private boolean loggedIn = false;


     Button loginstudent;
    // registerstudent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentlogin);

            /*registerstudent = (Button) findViewById(R.id.registerstudent);


            registerstudent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(Studentlogin.this, Studentregister.class);
                    startActivity(i);

                }
            });*/

        //Initializing views
        Estudentroll = (EditText) findViewById(R.id.studentroll);
        Estudentname = (EditText) findViewById(R.id.studentname);
        Estudentdob = (EditText) findViewById(R.id.studentdob);

        loginstudent = (Button) findViewById(R.id.btloginstudent);

        //Adding click listener
        loginstudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        //In onresume fetching value from sharedpreference

        SharedPreferences sharedPreferences = getSharedPreferences(Config.SHARED_PREF_STUDENT_NAME, Context.MODE_PRIVATE);

        //Fetching the boolean value form sharedpreferences
        loggedIn = sharedPreferences.getBoolean(Config.SHARED_PREF_STUDENT_LOGGEDIN, false);

        //If we will get true
        if (loggedIn) {
            //We will start the Profile Activity
            Intent intent = new Intent(Studentlogin.this, Studenthome.class);
            startActivity(intent);
        }
    }

    private void login() {
        //Getting values from edit texts
        final String Sstudent_roll = Estudentroll.getText().toString().trim();
        final String Sstudent_name = Estudentname.getText().toString().trim();
        final String Sstudent_dod = Estudentdob.getText().toString().trim();

        //Creating a string request
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Config.LOGIN_STUDENT_URL,

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //If we are getting success from server
                        if (response.equalsIgnoreCase(Config.LOGIN_STUDENT_SUCCESS)) {
                            //Creating a shared preference
                            SharedPreferences sharedPreferences = Studentlogin.this.getSharedPreferences(Config.SHARED_PREF_STUDENT_NAME, Context.MODE_PRIVATE);

                            //Creating editor to store values to shared preferences
                            SharedPreferences.Editor editor = sharedPreferences.edit();

                            //Adding values to editor
                            editor.putBoolean(Config.SHARED_PREF_STUDENT_LOGGEDIN, true);
                            editor.putString(Config.SHARED_PREF_STUDENT_EMAIL, Sstudent_roll);
                            editor.putString(Config.SHARED_PREF_STUDENT_NAMEVIEW, Sstudent_name);
                            editor.putString(Config.SHARED_PREF_STUDENT_EMAIL, Sstudent_dod);

                            //Saving values to editor3.0
                            editor.commit();

                            //Starting profile activity
                            Intent intent = new Intent(Studentlogin.this, Studenthome.class);
                            startActivity(intent);
                        } else {
                            //If the server response is not success
                            //Displaying an error message on toast



                            Toast.makeText(Studentlogin.this, response, Toast.LENGTH_LONG).show();
                        }
                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //You can handle error here if you want
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                //Adding parameters to request
                params.put(Config.KEY_STUDENT_ROLLNO,Sstudent_roll);
                params.put(Config.KEY_STUDENT_NAME,Sstudent_name);
                params.put(Config.KEY_STUDENT_DOB,Sstudent_dod);

                //returning parameter
                return params;
            }
        };

        //Adding the string request to the queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }


}




