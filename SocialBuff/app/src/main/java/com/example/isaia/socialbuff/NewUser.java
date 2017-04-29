package com.example.isaia.socialbuff;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IntegerRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class NewUser extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    EditText first_name;
    EditText last_name;
    EditText email;
    EditText password__;
    EditText password_confirm_;
    EditText dob;
    EditText major;
    TextView year_;
    boolean year_select;
    Spinner year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        first_name = (EditText) findViewById(R.id.first_name);
        last_name = (EditText) findViewById(R.id.last_name);
        email = (EditText) findViewById(R.id.email_address);
        dob = (EditText) findViewById(R.id.birthdate);
        major = (EditText) findViewById(R.id.major);
        password__ = (EditText) findViewById(R.id.password);
        password_confirm_ = (EditText) findViewById(R.id.password_confirm);
        year = (Spinner) findViewById(R.id.year);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,R.array.years,android.R.layout.simple_spinner_dropdown_item);
        year.setAdapter(adapter);
        year.setOnItemSelectedListener(this);


        Button create_user = (Button) findViewById(R.id.create_user);
        create_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if((password__.getText().toString().equals(password_confirm_.getText().toString()))&&
                        (email.getText().toString().contains("@colorado.edu")||email.getText().toString().contains("@Colorado.edu")||
                                email.getText().toString().contains("@COLORADO.EDU"))&&year_select&&(password__.getText().toString().length() > 2)){
                    create_user();
                }
                else if(!(email.getText().toString().contains("@colorado.edu")||email.getText().toString().contains("@Colorado.edu")||
                        email.getText().toString().contains("@COLORADO.EDU"))){
                    Toast.makeText(NewUser.this, "Must be @colorado.edu", Toast.LENGTH_LONG).show();
                }
                else if(!year_select){
                    Toast.makeText(NewUser.this,"Select Year",Toast.LENGTH_SHORT).show();
                }
                else if(!(password__.getText().toString().length() > 2)){
                    Toast.makeText(NewUser.this,"Password too short",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(NewUser.this, "Password does not match", Toast.LENGTH_LONG).show();
                }
            }
        });



    }

    private void create_user(){
        String first = first_name.getText().toString();
        String last = last_name.getText().toString();
        String full_name = first+" "+last;
        String year_add = year_.getText().toString();
        String age = dob.getText().toString();

        UserDatabase database = UserDatabase.getDatabase();
        User myuser = database.getUserByEmail(email.getText().toString());
        //ADD USER
        if(myuser == null) {
            database.addUser(full_name, email.getText().toString(), password__.getText().toString(), Integer.parseInt(age), major.getText().toString(), Integer.parseInt(year_add));
            Toast.makeText(this, "Account Created: " + full_name, Toast.LENGTH_SHORT).show();
            startActivity(new Intent(NewUser.this, LoginActivity.class));
        }
        else {
            Toast.makeText(this, "Email already in use",Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        year_ = (TextView) view;
        year_select = true;
        //Toast.makeText(this, "Your YEar" + year_.getText().toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        year_select = false;
    }
}
