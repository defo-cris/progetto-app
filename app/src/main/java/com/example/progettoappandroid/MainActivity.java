package com.example.progettoappandroid;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageButton DialogSave;
    TextView Myname;
    Dialog ThisDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ImageButton imageInsert=(ImageButton)findViewById(R.id.imageButton);
        //ImageButton imageLoad=(ImageButton)findViewById(R.id.imageButton2);
        DialogSave = (ImageButton)findViewById(R.id.imageButton);
        Myname = (TextView)findViewById(R.id.Work_out);
        DialogSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ThisDialog = new Dialog(MainActivity.this);
                ThisDialog.setTitle("Save Your Name");
                ThisDialog.setContentView(R.layout.dialog_template);
                final EditText Write = (EditText)ThisDialog.findViewById(R.id.write);
                Button SaveMyWorkOut = (Button)ThisDialog.findViewById(R.id.SaveNow);
                Button CancelMyWorkOut = (Button)ThisDialog.findViewById(R.id.Cancel);
                Write.setEnabled(true);
                SaveMyWorkOut.setEnabled(true);
                SaveMyWorkOut.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String s = Write.getText().toString();
                        SharedPrefesSAVE(s);
                        ThisDialog.cancel();

                        launchInsert(v, s);

                    }

                });

                ThisDialog.show();
            }
        });
        //Show.setOnClickListener(new View.OnClickListener() {
         //   @Override
         //   public void onClick(View v) {
         //       SharedPreferences SP = getApplicationContext().getSharedPreferences("NAME", 0);
         //       Myname.setText(SP.getString("Name", null));
         //   }
        //});
    }


    public void launchLoad(View v){
        Intent i=new Intent(this,LoadActivity.class);
        startActivity(i);
    }

    public void launchInsert (View v, String s){
        Intent i = new Intent(this, InsertActivity.class);
        i.putExtra("message" , s);
        startActivity(i);
    }

    public void SharedPrefesSAVE(String Name){
        SharedPreferences prefs = getApplicationContext().getSharedPreferences("NAME", 0);
        SharedPreferences.Editor prefEDIT = prefs.edit();
        prefEDIT.putString("Name", Name);
        prefEDIT.commit();
    }
}