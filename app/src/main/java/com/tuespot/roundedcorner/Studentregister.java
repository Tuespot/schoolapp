package com.tuespot.roundedcorner;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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

public class Studentregister extends AppCompatActivity {

    private static final String REGISTER_URL= "http://tuespotsolutions.com/aman/studentregister.php";


    public  static final String KEY_ROLLNO="student_roll";
    public  static final String KEY_NAME="student_name";
    public  static final String KEY_DOB="student_dob";
    public  static final String KEY_MOBILENUMBER="student_mobile";
    public  static final String KEY_PASSWORD ="student_password";


    String student_roll,student_name,student_dob,student_mobile ,student_password;

    EditText rollno,name,dob,mobile,password;
    Button register;


    TextView clickstudent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentregister);

        clickstudent = (TextView)findViewById(R.id.clickstudent);


        rollno = (EditText)findViewById(R.id.rollno);
        name = (EditText)findViewById(R.id.namestudent);
        dob = (EditText)findViewById(R.id.dobstudent);
        mobile = (EditText)findViewById(R.id.mobilestudent);
        password = (EditText)findViewById(R.id.passwordstudent);

        register = (Button)findViewById(R.id.registerstudent);






        dob.setFocusableInTouchMode(true);
        dob.requestFocus();




        dob.setCursorVisible(false);


        // dob.setFocusable(false);
        //dob.setClickable(true);
        //dob.setFocusableInTouchMode(false);

        dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DateDialog dialog = new DateDialog(v);
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                dialog.show(ft, "DatePicker");


            }
        });



        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                if (v == register) {
                    register_user();



                }}});


        clickstudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Studentregister.this, Studentlogin.class);
                startActivity(i);

            }
        });

    }


    private void register_user(){

        student_roll = rollno.getText().toString().trim();
        student_name = name.getText().toString().trim();
        student_dob = dob.getText().toString().trim();
        student_mobile = mobile.getText().toString().trim();
        student_password = password.getText().toString().trim();


        if(rollno.getText().toString().length()==0){
            rollno.setError("Roll number not entered");
            rollno.requestFocus();
        }
        if(name.getText().toString().length()==0){
            name.setError("Name not entered");
            name.requestFocus();
        }

        if(dob.getText().toString().length()==0){
            dob.setError("DOB not entered");
            dob.requestFocus();
        }

        if(mobile.getText().toString().length()==0){
            mobile.setError("Mobile Number not entered");
            mobile.requestFocus();
        }
        if(password.getText().toString().length()==0){
            password.setError("Password not entered");
            password.requestFocus();

        }

        if (!isValidRoll(student_roll)) {
            rollno.setError("Invalid Roll Number");
        }
        if (!isValidName(student_name)) {
            name.setError("Must be long than Three Char");
        }
        if (!isValidMobilenumber(student_mobile)) {
            mobile.setError("Invalid Mobile Number");
        }
        if (!isValidPassword(student_password)) {
            password.setError("Password should be atlleast 8 digit");
        }



        StringRequest stringRequest = new StringRequest(Request.Method.POST, REGISTER_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(Studentregister.this, response, Toast.LENGTH_SHORT).show();


            }
        },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //Toast.makeText(Studentregister.this, error.toString(), Toast.LENGTH_SHORT).show();
                        Toast.makeText(Studentregister.this, "Make Your Internet Connection", Toast.LENGTH_SHORT).show();
                    }

                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();

                params.put(KEY_ROLLNO, student_roll);
                params.put(KEY_NAME, student_name);
                params.put(KEY_DOB, student_dob);
                params.put(KEY_MOBILENUMBER, student_mobile);
                params.put(KEY_PASSWORD,student_password);
                return params;
            }
        };


        RequestQueue requestqueue = Volley.newRequestQueue(this);
        requestqueue.add(stringRequest);




    }


    private boolean isValidRoll(String roll) {
        if (roll != null && roll.length() >= 4) {
            return true;
        }
        return false;
    }

    private boolean isValidName(String name) {
        if (name != null && name.length() >= 3) {
            return true;
        }
        return false;
    }

    private boolean isValidMobilenumber(String mobilenumber) {
        if (mobilenumber != null && mobilenumber.length() == 10) {
            return true;
        }
        return false;
    }
    private boolean isValidPassword(String password) {
        if (password != null && password.length() > 6) {
            return true;
        }
        return false;
    }
}
