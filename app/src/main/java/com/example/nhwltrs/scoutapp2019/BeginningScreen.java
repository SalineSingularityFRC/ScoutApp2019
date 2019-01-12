package com.example.nhwltrs.scoutapp2019;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BeginningScreen extends AppCompatActivity {

    private boolean started=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Create the page and set the layout to the page
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beginning_screen);

        //Create all the buttons
        Button newMatch = (Button)findViewById(R.id.inputDataButton);

        //Set the listeners for the buttons
        newMatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        //Bluetooth code will go here
    }

    @Override
    protected void onStart() {
        super.onStart();

        //Bluetooth code will go here
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        //More bluetooth code
    }

}
