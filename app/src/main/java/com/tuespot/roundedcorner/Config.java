package com.tuespot.roundedcorner;

/**
 * Created by ASUS on 12-Aug-17.
 */
public class Config {

    //URL to our login.php file
    public static final String LOGIN_URL = "http://tuespotsolutions.com/aman/studentlogin.php";


    //Keys for email and password as defined in our $_POST['key'] in login.php
    public static final String KEY_MOBILENUMBER="student_mobile";
    public  static final String KEY_ROLLNO="student_roll";
    public static final String KEY_PASSWORD ="student_password";

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
