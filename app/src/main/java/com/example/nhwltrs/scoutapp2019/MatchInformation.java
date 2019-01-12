package com.example.nhwltrs.scoutapp2019;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MatchInformation extends AppCompatActivity {

    boolean blueTeam;
    boolean abort = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_information);

        Button startMatchButton = (Button)findViewById(R.id.startMatchButton);
        final EditText matchNumberEditText = (EditText)findViewById(R.id.matchNumberEditText);
        final RadioButton allianceBlue = (RadioButton)findViewById(R.id.allianceBlue);
        final RadioButton allianceRed = (RadioButton)findViewById(R.id.allianceRed);

        startMatchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(allianceBlue.isChecked()) {
                    blueTeam = true;
                }

                else if (allianceRed.isChecked()) {
                    blueTeam = false;
                }

                String checkInput = matchNumberEditText.getText().toString();
                if (checkInput.matches("")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MatchInformation.this);

                    builder.setCancelable(false);
                    builder.setTitle("");
                    builder.setMessage("Please input what match number this is");

                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            return;
                        }
                    });
                    builder.show();
                    return;
                }

                if (getIntent().hasExtra("Team Number")) {
                    String teamNumberString = getIntent().getExtras().toString();
                    teamNumberString = teamNumberString.replace("Bundle[{Team Number=","");
                    teamNumberString = teamNumberString.replace("}]", "");
                    int teamNumber = Integer.parseInt(teamNumberString);
                    //Bluetooth code goes here
                    //Intent matchData = new Intent(getApplicationContext(), MatchData.class);
                    abort=true;
                    //startActivity(matchData);
                }
            }
        });
    }

    protected void onResume() {

        super.onResume();

        if(abort){
            finish();
        }
    }
}
