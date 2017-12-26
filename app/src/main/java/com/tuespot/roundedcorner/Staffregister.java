package com.tuespot.roundedcorner;

import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
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

public class Staffregister extends AppCompatActivity {

    private static final String REGISTER_URL= "http://tuespotsolutions.com/aman/staffregister.php";


    public  static final String KEY_ROLLNO="staff_id";
    public  static final String KEY_NAME="staff_name";
    public  static final String KEY_DOB="staff_dob";
    public  static final String KEY_MOBILENUMBER="staff_mobile";
    public  static final String KEY_PASSWORD ="staff_password";


    String staff_id,staff_name,staff_dob,staff_mobile ,staff_password;

    EditText staffid,name,dob,mobile,password;
    Button register;


    TextView clickstaff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staffregister);


        clickstaff = (TextView) findViewById(R.id.clickstaff);

        staffid = (EditText)findViewById(R.id.idstaff);
        name = (EditText)findViewById(R.id.namestaff);
        dob = (EditText)findViewById(R.id.dobstaff);
        mobile = (EditText)findViewById(R.id.mobilestaff);
        password = (EditText)findViewById(R.id.passwordstaff);
        register = (Button)findViewById(R.id.registerstaff);
        dob.setFocusable(false);
        dob.setClickable(true);


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

        clickstaff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Staffregister.this, Stafflogin.class);
                startActivity(i);


            }
        });
    }

    @Override
    public boolean onTouchEvent (MotionEvent event){
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.
                INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        return true;
    }


    private void register_user(){

        staff_id = staffid.getText().toString().trim();
        staff_name = name.getText().toString().trim();
        staff_dob = dob.getText().toString().trim();
        staff_mobile = mobile.getText().toString().trim();
        staff_password = password.getText().toString().trim();





        StringRequest stringRequest = new StringRequest(Request.Method.POST, REGISTER_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(Staffregister.this, response, Toast.LENGTH_SHORT).show();

                Intent i = new Intent(getApplicationContext(), Stafflogin.class);
                startActivity(i);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Staffregister.this, error.toString(), Toast.LENGTH_SHORT).show();
                        //Toast.makeText(Signup.this, "Make Your Internet Connection", Toast.LENGTH_SHORT).show();
                    }

                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();

                params.put(KEY_ROLLNO, staff_id);
                params.put(KEY_NAME, staff_name);
                params.put(KEY_DOB, staff_dob);
                params.put(KEY_MOBILENUMBER, staff_mobile);
                params.put(KEY_PASSWORD,staff_password);
                return params;
            }
        };

        RequestQueue requestqueue = Volley.newRequestQueue(this);
        requestqueue.add(stringRequest);




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
