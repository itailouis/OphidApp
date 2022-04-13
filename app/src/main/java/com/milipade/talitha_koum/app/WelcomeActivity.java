package com.milipade.talitha_koum.app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.milipade.talitha_koum.app.data.Patient;
import com.milipade.talitha_koum.app.data.User;

import java.text.SimpleDateFormat;
import java.util.Calendar;



public class WelcomeActivity extends AppCompatActivity implements PatientDialogFragment.OnFragmentInteractionListener {
    private static final String TAG =WelcomeActivity.class.getName();
    TextView textviewRecord;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        Toolbar toolbar = findViewById(R.id.toolbar);

        User user = getIntent().getParcelableExtra("");
        //setSupportActionBar(toolbar);
        Button newRecord = findViewById(R.id.button_newrecord);
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy HH:mm a");
        String mydateTime = df.format(c.getTime());
        TextView wellcome = findViewById(R.id.textview_welcome);

        user = new  User("ophid", "itai Louis zulu", "ophid");
        wellcome.setText("Welcome user"+ user.getRealname());
        TextView myTime = findViewById(R.id.textview_time);
        myTime.setText(mydateTime);
        textviewRecord = findViewById(R.id.textview_record);

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


    @Override
    public void onFragmentInteraction(Patient patient) {
        Log.e(TAG, "onFragmentInteraction ");
        textviewRecord.setText("Name "+patient.getName()+"\n Gender"+patient.getGender()+"\n Age "+patient.getAge());

        if(patient.getAge()<21){
            Snackbar.make(textviewRecord, "21 and below play video", Snackbar.LENGTH_LONG)
                    .setAction("Play",  new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent tostart = new Intent(Intent.ACTION_VIEW);
                            tostart.setDataAndType(Uri.parse("https://www.youtube.com/watch?v=0wd5P7VlIoo&list=RD0wd5P7VlIoo&start_radio=1"), "video/*");
                            startActivity(tostart);
                        }
                    }).show();
        }

        if(patient.getAge()<21 && patient.getAge()>29  ){
            Snackbar.make(textviewRecord, "Between 21 and 30", Snackbar.LENGTH_LONG)
                    .setAction("Play", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent tostart = new Intent(Intent.ACTION_VIEW);
                            tostart.setDataAndType(Uri.parse("https://www.youtube.com/watch?v=0wd5P7VlIoo&list=RD0wd5P7VlIoo&start_radio=1"), "video/*");
                            startActivity(tostart);
                        }
                    }).show();
        }

        if(patient.getAge()>30){
            Snackbar.make(textviewRecord, "30  and above  play audio", Snackbar.LENGTH_LONG)
                    .setAction("Play",  new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent tostart = new Intent(Intent.ACTION_VIEW);
                            tostart.setDataAndType(Uri.parse("https://www.youtube.com/watch?v=0wd5P7VlIoo&list=RD0wd5P7VlIoo&start_radio=1"), "video/*");
                            startActivity(tostart);
                        }
                    }).show();
        }
    }
}