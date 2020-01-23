package com.adteccorp.registrationform;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginAct extends AppCompatActivity {
    Button loginbtn, registerbtn;
    EditText userlogin, passwordlogin;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_login );
        init();
    }

    private void init() {
        userlogin = findViewById( R.id.etloginusername );
        passwordlogin = findViewById( R.id.etloginpassword );
        loginbtn = findViewById( R.id.loginbtnlogin );
        registerbtn = findViewById( R.id.registerloginregister );
        sharedPreferences = getSharedPreferences( "userinfo", 0 );
        loginbtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernamevalue = userlogin.getText().toString();
                String passwordnamevalue = passwordlogin.getText().toString();

                String username =sharedPreferences.getString( "etuserreg","" );
                String userpassword =sharedPreferences.getString( "etpassreg","" );
                if(usernamevalue.equals(username) && passwordnamevalue.equals(userpassword)){
                    startActivity( new Intent( LoginAct.this,SuccssAct.class ) );
                    Toast.makeText( LoginAct.this, "Successfully you are  logged in ...", Toast.LENGTH_SHORT ).show();
                }
                else {
                    Toast.makeText( LoginAct.this, "Invalid Username and password", Toast.LENGTH_SHORT ).show();
                }
            }
        } );
        registerbtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent( LoginAct.this, MainActivity.class ) );
            }
        } );

    }

}
