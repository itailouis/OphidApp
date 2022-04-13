package com.milipade.talitha_koum.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.milipade.talitha_koum.app.data.DatabaseHelper;
import com.milipade.talitha_koum.app.data.User;
import com.milipade.talitha_koum.app.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    private DatabaseHelper databaseHelper;
    EditText usernameInput, userpasswordInput;
    private static final String TAG =MainActivity.class.getName();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        Button sign_in = findViewById(R.id.button_signin);
        usernameInput = findViewById(R.id.user_name);
        userpasswordInput = findViewById(R.id.user_password);
        databaseHelper = new DatabaseHelper(MainActivity.this);
        if (!databaseHelper.checkUser("ophid", "ophid")) {
            Log.e(TAG, "checkUser  true");
            databaseHelper.addUser(new User("ophid", "itai Louis zulu", "ophid"));
        }
        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username = usernameInput.getText().toString();
                String password = userpasswordInput.getText().toString();
                if (isValiduser(username, password)) {
                    Intent intent = new Intent(MainActivity.this, WelcomeActivity.class);
                    User user = databaseHelper.checkUser(username);

                    Log.e(TAG,"resuilts "+databaseHelper.checkUser(username,password));
                    intent.putExtra("user" ,user );
                    startActivity(intent);
                } else {
                    Snackbar.make(view, "wrong username or password", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }

            }
        });
    }

    private boolean isValiduser(String username, String password) {
        databaseHelper = new DatabaseHelper(MainActivity.this);
        Log.e(TAG,"resuilts "+databaseHelper.checkUser(username,password));

        return  databaseHelper.checkUser(username,password);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}