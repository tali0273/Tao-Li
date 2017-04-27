package com.example.isaia.socialbuff;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class ProfilePage2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        /**String[] values = new String[] {"\n" +
                "        BoulderBandidio\n" +
                "        AGE: 22\n" +
                "        MAJOR: Electrical and Computer Engineering\n" +
                "        YEAR: 17'\n" +
                "        HOBBIES: Gymnastics, Hiking, etc.", "Date of birth", "Other"};*/
        String[] values = new String[]{"BoulderBandidio","AGE: 22",
                "MAJOR: Electrical and Computer Engineering",
                "YEAR: 17' ","HOBBIES: Gymnastics, Hiking, etc."};
                //ArrayList<String> valueslist = new ArrayList<String>();

        ArrayAdapter <String> profile_info = new ArrayAdapter<String>(this, R.layout.my_profile_items, values);
        ListView my_info = (ListView) findViewById(R.id.list);
        my_info.setAdapter(profile_info);

        registerClickCallback();
        /* I removed this button I think
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        */
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.package.ACTION_LOGOUT");
        registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Log.d("onReceive","Logout in progress");
                //At this point you should start the login activity and finish this one
                finish();
            }
        }, intentFilter);
    }
    private void registerClickCallback() {
        ListView list = (ListView) findViewById(R.id.list);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> paret, View viewClicked, int position, long id) {
                TextView textView = (TextView) viewClicked;
                String message;

                if(position == 0){
                    message = "You clicked " + textView.getText().toString();
                }
                else if(position == 1){
                    message = "You clicked " + textView.getText().toString();
                }
                else if(position == 2){
                    message = "You clicked " + textView.getText().toString();
                }
                else{
                    message = "You clicked " + textView.getText().toString();
                }
                Toast.makeText(ProfilePage2.this, message, Toast.LENGTH_LONG).show();

            }
        });
    }
}


