package com.tuespot.roundedcorner;

/**
 * Created by ASUS on 12-Aug-17.
 */
public class Config {

    //URL to our login.php file
    public static final String LOGIN_URL = "http://nbse.funcofi.com/staff/app/stafflogin.php";

   // public static final String LOGIN_URL = "http://handa.16mb.com/stafflogin.php";


    //Keys for email and password as defined in our $_POST['key'] in login.php

    // student login
    public  static final String KEY_ROLLNO="student_roll";
    public static final String KEY_NAME ="student_password";
    public static final String KEY_DOB="student_mobile";
    // staff login
    public  static final String KEY_STAFF_ID="userid";
    public static final String KEY_STAFF_PASSWORD ="password";

    //If server response is equal to this that means login is successful
    public static final String LOGIN_SUCCESS = "success";

    //Keys for Sharedpreferences
    //This would be the name of our shared preferences
    public static final String SHARED_PREF_NAME = "myloginapp";

    //This would be used to store the email of current logged in user
    public static final String EMAIL_SHARED_PREF = "e_mail";

    //We will use this to store the boolean in sharedpreference to track user is loggedin or not
    public static final String LOGGEDIN_SHARED_PREF = "loggedin";
}
