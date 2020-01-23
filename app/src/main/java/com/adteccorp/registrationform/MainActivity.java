package com.adteccorp.registrationform;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText etuserreg, etpassreg, etdobreg, etcountryreg, etphonereg, etaddressreg, etemailaddressreg;
    RadioGroup gender;
    Button loginregister, clearregister;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        init();
    }

    private void init() {
        etuserreg = findViewById( R.id.etuser );
        etpassreg = findViewById( R.id.etpassword );
        etdobreg = findViewById( R.id.etdob );
        etcountryreg = findViewById( R.id.etcountry );
        etphonereg = findViewById( R.id.etphone );
        etaddressreg = findViewById( R.id.etaddress );
        etemailaddressreg = findViewById( R.id.etemailaddress );
        gender = findViewById( R.id.gender );
        loginregister = findViewById( R.id.btnlogin );
        clearregister = findViewById( R.id.btnregister );
        //adding Shared prefernces
        sharedPreferences = getSharedPreferences( "userinfo", 0 );
        //loginregister btn
        loginregister.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String etuser = etuserreg.getText().toString();
                String etpass = etpassreg.getText().toString();
                String etdob = etdobreg.getText().toString();
                String etcountry = etcountryreg.getText().toString();
                String etphone = etphonereg.getText().toString();
                String etaddress = etaddressreg.getText().toString();
                String etemail = etemailaddressreg.getText().toString();
                RadioButton checkedbtn = findViewById( gender.getCheckedRadioButtonId() );
                String gendervalue = checkedbtn.getText().toString();


                if (etuser.length() > 1) {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString( "etuserreg", etuser );
                    editor.putString( "etpassreg", etpass );
                    editor.putString( "etdobreg", etdob );
                    editor.putString( "etcountryreg", etcountry );
                    editor.putString( "etphonereg", etphone );
                    editor.putString( "etaddressreg", etaddress );
                    editor.putString( "etemailaddressreg", etemail );
                    editor.putString( "gender", gendervalue );
                 /*   editor.putString( "userlogin", );
                    editor.putString( "passwordlogin","" );*/
                    editor.apply();
                    Toast.makeText( MainActivity.this, "User registered Successfully", Toast.LENGTH_SHORT ).show();
                    startActivity( new Intent( MainActivity.this, LoginAct.class ) );

                } else {
                    Toast.makeText( MainActivity.this, "Please enter the all fields", Toast.LENGTH_SHORT ).show();
                }


            }
        } );
        //register btn
        clearregister.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emptyfield();
            }
        } );

    }

    public void emptyfield() {
        etuserreg.setText( "" );
        etpassreg.setText( "" );
        etdobreg.setText( "" );
        etcountryreg.setText( "" );
        etphonereg.setText( "" );
        etaddressreg.setText( "" );
        etemailaddressreg.setText( "" );
        gender.setTag( "" );
    }

}
