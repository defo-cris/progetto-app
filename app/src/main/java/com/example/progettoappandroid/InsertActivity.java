package com.example.progettoappandroid;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
//import android.support.v4.app.Fragment;
import android.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class InsertActivity extends AppCompatActivity {
    private static final String TAG = "MyActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment);
        Intent intent = getIntent();
        String s = intent.getStringExtra("message");

        setContentView(R.layout.activity_insert);

        Button buttonIns=(Button)findViewById(R.id.button);
        TextView viewIns=(TextView)findViewById(R.id.Work_out);
        viewIns.setText(s);

        assert buttonIns !=null;
        buttonIns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        FloatingActionButton F_A_B = findViewById(R.id.fab);
        F_A_B.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                FragmentManager fm = getSupportFragmentManager();
                Exercise_Fragment newCase = new Exercise_Fragment();
                FragmentTransaction transaction=fm.beginTransaction();
                transaction.add(R.id.fragment, newCase);// give your fragment container id in first parameter
                //transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
                transaction.commit();

            }
        });
    }

}






