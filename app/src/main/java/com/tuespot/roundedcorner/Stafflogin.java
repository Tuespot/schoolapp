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

public class Stafflogin extends AppCompatActivity {

    //Defining views
    private EditText staffid,staffpassword;



    //boolean variable to check user is logged in or not
    //initially it is false
    private boolean loggedIn = false;


    Button loginstaff;
    // registerstaff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stafflogin);

        /*registerstaff = (Button)findViewById(R.id.registerstaff);

        registerstaff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Stafflogin.this, Staffregister.class);
                startActivity(i);

            }
        });
*/

        //Initializing views
        staffid = (EditText) findViewById(R.id.staffmobile);
        staffpassword = (EditText) findViewById(R.id.staffpassword);

        loginstaff = (Button) findViewById(R.id.loginstaff);

        //Adding click listener
        loginstaff.setOnClickListener(new View.OnClickListener() {
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
        SharedPreferences sharedPreferences = getSharedPreferences(Config.SHARED_PREF_STAFF_NAME, Context.MODE_PRIVATE);

        //Fetching the boolean value form sharedpreferences
        loggedIn = sharedPreferences.getBoolean(Config.SHARED_PREF_STAFF_LOGGEDIN, false);

        //If we will get true
        if (loggedIn) {
            //We will start the Profile Activity
            Intent intent = new Intent(Stafflogin.this, Staffhome.class);
            startActivity(intent);
        }
    }

    private void login() {
        //Getting values from edit texts
        //final String sstaff_mobile = staffmobile.getText().toString().trim();
        final String sstaff_id = staffid.getText().toString().trim();
        final String sstaff_password = staffpassword.getText().toString().trim();

        //Creating a string request
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Config.LOGIN_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //If we are getting success from server
                        if (response.equalsIgnoreCase(Config.LOGIN_STAFF_SUCCESS)) {
                            //Creating a shared preference
                            SharedPreferences sharedPreferences = Stafflogin.this.getSharedPreferences(Config.SHARED_PREF_STAFF_NAME, Context.MODE_PRIVATE);

                            //Creating editor to store values to shared preferences
                            SharedPreferences.Editor editor = sharedPreferences.edit();

                            //Adding values to editor
                            editor.putBoolean(Config.SHARED_PREF_STAFF_LOGGEDIN, true);
                            editor.putString(Config.SHARED_PREF_STAFF_EMAIL, sstaff_id);
                            editor.putString(Config.SHARED_PREF_STAFF_EMAIL, sstaff_password);

                            //Saving values to editor
                            editor.commit();

                            //Starting profile activity
                            Intent intent = new Intent(Stafflogin.this, Staffhome.class);
                            startActivity(intent);
                        } else {
                            //If the server response is not success
                            //Displaying an error message on toast
                            Toast.makeText(Stafflogin.this, response, Toast.LENGTH_LONG).show();
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
                // params.put(Config.KEY_MOBILENUMBER,sstaff_mobile);
                params.put(Config.KEY_STAFF_ID,sstaff_id);
                params.put(Config.KEY_STAFF_PASSWORD,sstaff_password);

                //returning parameter
                return params;
            }
        };

        //Adding the string request to the queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);


    }
    /*//close keybroad
 */
    private boolean isValidUsername(String username) {
        if (username != null && username.length() >= 3) {
            return true;
        }
        return false;
    }

}
