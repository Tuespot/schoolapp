package com.tuespot.roundedcorner;

/**
 * Created by ASUS on 12-Aug-17.
 */
public class Config {

    //URL to our login.php file

        public static final String LOGIN_STUDENT_URL = "http://handa.16mb.com/studentlogin.php";
        public static final String LOGIN_URL = "http://nbse.funcofi.com/staff/app/stafflogin.php";
        public static final String LOGIN_CENTER_URL = "http://handa.16mb.com/centerlogin.php ";


    //Keys for email and password as defined in our $_POST['key'] in login.php

    // student login

    public  static final String KEY_STUDENT_ROLLNO="student_roll";
    public static final String KEY_STUDENT_NAME ="student_name";
    public static final String KEY_STUDENT_DOB="student_dob";

    //If server response is equal to this that means login is successful
    public static final String LOGIN_STUDENT_SUCCESS = "success";
    //Keys for Sharedpreferences
    //This would be the name of our shared preferences
    public static final String SHARED_PREF_STUDENT_NAME = "student_myloginapp";
    //This would be used to store the email of current logged in user
    public static final String SHARED_PREF_STUDENT_EMAIL = "student_e_mail";
    //We will use this to store the boolean in sharedpreference to track user is loggedin or not
    public static final String SHARED_PREF_STUDENT_LOGGEDIN = "student_loggedin";




    // *********************  STAFF LOGIN  ****************************

         public  static final String KEY_STAFF_ID="userid";
         public static final String KEY_STAFF_PASSWORD ="password";

         //If server response is equal to this that means login is successful
         public static final String LOGIN_STAFF_SUCCESS = "success";

         //Keys for Sharedpreferences
          //This would be the name of our shared preferences
         public static final String SHARED_PREF_STAFF_NAME = "staff_myloginapp";
         //This would be used to store the email of current logged in user
         public static final String SHARED_PREF_STAFF_EMAIL = "staff_e_mail";
         //We will use this to store the boolean in sharedpreference to track user is loggedin or not
         public static final String SHARED_PREF_STAFF_LOGGEDIN = "staff_loggedin";




    //****************** CENTER LOGIN*******************************

    public  static final String KEY_CENTER_ID="center_id";
    public static final String KEY_CENTER_PASSWORD ="center_password";


    //If server response is equal to this that means login is successful
     public static final String LOGIN_CENTER_SUCCESS = "success";

    //Keys for Sharedpreferences
    //This would be the name of our shared preferences
     public static final String SHARED_PREF_CENTER_NAME = "center_myloginapp";

    //This would be used to store the email of current logged in user
       public static final String SHARED_PREF_CENTER_EMAIL = "center_e_mail";

    //We will use this to store the boolean in sharedpreference to track user is loggedin or not
           public static final String SHARED_PREF_CENTER_LOGGEDIN = "center_loggedin";
}
