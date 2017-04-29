package com.example.isaia.socialbuff;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Context;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

import static com.example.isaia.socialbuff.R.id.comments0;
import static com.example.isaia.socialbuff.R.id.editText1;
import static com.example.isaia.socialbuff.R.id.fab;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    boolean sign_out = false;
    EditText newcomment0;
    EditText newcomment1;
    EditText newcomment2;
    EditText newcomment3;
    EditText newcomment4;
    EditText new_status;
    TextView comment0;
    TextView comment1;
    TextView comment2;
    TextView comment3;
    TextView comment4;
    TextView mystatus;
    Button like0;
    Button like1;
    Button like2;
    Button like3;
    Button like4;
    int like_count0 = 0;
    int like_count1 = 0;
    int like_count2 = 0;
    int like_count3 = 0;
    int like_count4 = 0;
    String name = new String("Isaiah Sierra");
    private KeyListener originalKeyListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView t1 = (TextView) findViewById(R.id.Feed1);
        TextView t2 = (TextView) findViewById(R.id.Feed2);
        TextView t3 = (TextView) findViewById(R.id.Feed3);
        TextView t4 = (TextView) findViewById(R.id.Feed4);
        UserDatabase database = UserDatabase.getDatabase();
        t1.setText(database.getRecentMessage(1));
        t2.setText(database.getRecentMessage(2));
        t3.setText(database.getRecentMessage(3));
        t4.setText(database.getRecentMessage(4));

        new_status = (EditText) findViewById(R.id.compose_status);
        new_status.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                mystatus.setText(name + " - "+new_status.getText().toString());
                newcomment0.setVisibility(View.VISIBLE);
                comment0.setVisibility(View.VISIBLE);
                like0.setVisibility(View.VISIBLE);
                mystatus.setVisibility(View.VISIBLE);
                new_status.setVisibility(View.GONE);
                return true;
            }
        });
        originalKeyListener = new_status.getKeyListener();
        new_status.setKeyListener(null);
        comment0 = (TextView) findViewById(R.id.comments0);
        comment1 = (TextView) findViewById(R.id.comments1);
        comment2 = (TextView) findViewById(R.id.comments2);
        comment3 = (TextView) findViewById(R.id.comments3);
        comment4 = (TextView) findViewById(R.id.comments4);
        mystatus = (TextView) findViewById(R.id.mystatus);
        newcomment0 = (EditText) findViewById(R.id.editText0);
        newcomment0.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                comment0.setText(newcomment0.getText().toString());
                return true;
            }
        });
        newcomment1 = (EditText) findViewById(R.id.editText1);
        newcomment1.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                comment1.setText(newcomment1.getText().toString());
                return true;
            }
        });
        newcomment2 = (EditText) findViewById(R.id.editText2);
        newcomment2.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                comment2.setText(newcomment2.getText().toString());
                return true;
            }
        });
        newcomment3 = (EditText) findViewById(R.id.editText3);
        newcomment3.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                comment3.setText(newcomment3.getText().toString());
                return true;
            }
        });
        newcomment4 = (EditText) findViewById(R.id.editText4);
        newcomment4.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                comment4.setText(newcomment4.getText().toString());
                return true;
            }
        });
        like0 = (Button) findViewById(R.id.Like0);
        like0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                like_count0++;
                Toast.makeText(getApplicationContext(),"LIKED! ("+like_count0+")",Toast.LENGTH_SHORT).show();
            }
        });
        like1 = (Button) findViewById(R.id.Like1);
        like1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                like_count1++;
                Toast.makeText(getApplicationContext(),"LIKED! ("+like_count1+")",Toast.LENGTH_SHORT).show();
            }
        });
        like2 = (Button) findViewById(R.id.Like2);
        like2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                like_count2++;
                Toast.makeText(getApplicationContext(),"LIKED!("+like_count2+")",Toast.LENGTH_SHORT).show();
            }
        });
        like3 = (Button) findViewById(R.id.Like3);
        like3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                like_count3++;
                Toast.makeText(getApplicationContext(),"LIKED!("+like_count3+")",Toast.LENGTH_SHORT).show();
            }
        });
        like4 = (Button) findViewById(R.id.Like4);
        like4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                like_count4++;
                Toast.makeText(getApplicationContext(),"LIKED! ("+like_count4+")",Toast.LENGTH_SHORT).show();
            }
        });


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView main_text = (TextView) findViewById(R.id.main_text);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "New Post", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                //mystatus.setText(name+" - "+status);
                new_status.setKeyListener(originalKeyListener);
                // Focus the field.
                new_status.requestFocus();
                // Show soft keyboard for the user to enter the value.
                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(new_status, InputMethodManager.SHOW_IMPLICIT);
                //
                /**new_status.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                        mystatus.setText(imm.toString());
                        return true;
                    }
                });*/
            }
        });

        new_status.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                // If it loses focus...
                if (!hasFocus) {
                    // Hide soft keyboard.
                    InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(new_status.getWindowToken(), 0);
                    // Make it non-editable again.
                    new_status.setKeyListener(null);
                }
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.package.ACTION_LOGOUT");
        registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                //Log.d("onReceive","Logout in progress");
                //At this point you should start the login activity and finish this one
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                finish();
            }
        }, intentFilter);
    }

    @Override
    public void onPause(){
            super.onPause();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            //Setting Activity
            return true;
        }
        else if(id == R.id.sign_out){
            //Need to close entire activity when logging out
            sign_out();
        }
        return super.onOptionsItemSelected(item);
    }
    private void sign_out(){
        Intent broadcastIntent = new Intent();
        broadcastIntent.setAction("com.package.ACTION_LOGOUT");
        sendBroadcast(broadcastIntent);
    }
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            Toast.makeText(this, "You Opened Your Profile", Toast.LENGTH_LONG).show();
            startActivity(new Intent(MainActivity.this, ProfilePage2.class));
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {
            Toast.makeText(this, "You Opened Your Photos", Toast.LENGTH_LONG).show();


        } else if (id == R.id.nav_slideshow) {
            Toast.makeText(this, "You Opened Your Messages", Toast.LENGTH_LONG).show();
            startActivity(new Intent(MainActivity.this, MessageActivity.class));

        } else if (id == R.id.nav_manage) {
            String FILENAME = "hello_file";
            String string = "hello world!";

            File file = new File(getFilesDir(), FILENAME);
            try {
                FileOutputStream fos = new FileOutputStream(file);
                fos.write(string.getBytes());
                fos.write("hello number 2!".getBytes());
                fos.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            Toast.makeText(this, "File: Written", Toast.LENGTH_LONG).show();
            //startActivity(new Intent(MainActivity.this, LoginActivity.class));
            //Need a settin menu here

        } else if (id == R.id.nav_share) {
            String FILENAME = "hello_file";

            File file = new File(getFilesDir(), FILENAME);
            String s = "failure\n";
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                s = br.readLine();
                s = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }

            Toast.makeText(this, "File Contents: " + s, Toast.LENGTH_LONG).show();

        } else if (id == R.id.nav_send) {
            Toast.makeText(this, "Sent.", Toast.LENGTH_LONG).show();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
