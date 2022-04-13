package com.milipade.talitha_koum.app;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.milipade.talitha_koum.app.data.User;

import java.text.SimpleDateFormat;
import java.util.Calendar;



public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        Toolbar toolbar = findViewById(R.id.toolbar);

        User user = getIntent().getParcelableExtra("user");
        //setSupportActionBar(toolbar);
        Button newRecord = findViewById(R.id.button_newrecord);
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy HH:mm a");
        String mydateTime = df.format(c.getTime());
        TextView wellcome = findViewById(R.id.textview_welcome);
        wellcome.setText("Welcome user"+ user.getRealname());
        TextView myTime = findViewById(R.id.textview_time);
        myTime.setText(mydateTime);


        newRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                PatientDialogFragment newFragment = new PatientDialogFragment();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                transaction.add(android.R.id.content, newFragment).addToBackStack(null).commit();

            }
        });
    }


}