package com.example.nhwltrs.scoutapp2019;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.List;


public class Pregame extends Fragment {
    private static final String TAG = "Pregame";

    String location = "";

    public Pregame() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pregame, container, false);

        DatabaseClass.setPreLoadCargo(0);
        DatabaseClass.setPreLoadHatch(0);

        final Spinner startingPosition = (Spinner) view.findViewById(R.id.spinnerStartPosition);

        final CheckBox level2 = (CheckBox)view.findViewById(R.id.level2Checkbox);

        List<String> list = new ArrayList<String>();
        list.add("Away");
        list.add("Middle");
        list.add("Closest");
        final int listsize = list.size();
        list.add("Select Position"); //This is correct

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, list) {
            @Override
            public int getCount() {
                return (listsize);
            }
        };
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        startingPosition.setAdapter(dataAdapter);
        startingPosition.setSelection(listsize);

        //Database stuff
        startingPosition.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String startingPos = startingPosition.getSelectedItem().toString();
                switch (startingPos) {
                    case "Away":
                        if (level2.isChecked()) {
                            DatabaseClass.setStartingPos(-3);
                        } else {
                            DatabaseClass.setStartingPos(3);
                        }
                        location = "Away";
                        break;
                    case "Middle":
                        DatabaseClass.setStartingPos(1);
                        location = "Middle";
                        break;
                    case "Closest":
                        if (level2.isChecked()) {
                            DatabaseClass.setStartingPos(-2);
                        }
                        else {
                            DatabaseClass.setStartingPos(2);
                        }
                        location = "Closest";
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });

        final Spinner robotPreload = (Spinner) view.findViewById(R.id.gamePieceSpinner);
        List<String> list2 = new ArrayList<String>();
        list2.add("Cargo");
        list2.add("Hatch");
        list2.add("None");
        final int listsize2 = list2.size();
        list2.add("None");

        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, list2) {
            @Override
            public int getCount() {
                return (listsize2);
            }

        };

        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        robotPreload.setAdapter(dataAdapter2);
        robotPreload.setSelection(listsize2);

            //Database stuff
        robotPreload.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    String robotPre = robotPreload.getSelectedItem().toString();
                    switch(robotPre) {
                        case "Cargo":
                            DatabaseClass.setRobotPreload(1);
                            break;
                        case "Hatch":
                            DatabaseClass.setRobotPreload(2);
                            break;
                        case "None":
                            DatabaseClass.setRobotPreload(0);
                            break;
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                    DatabaseClass.setRobotPreload(0);
                }
        });
        level2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (level2.isChecked()) {
                    switch(location){
                        case"Away":
                            DatabaseClass.setStartingPos(-3);
                            break;
                        case "Middle":
                            break;
                        case "Closest":
                            DatabaseClass.setStartingPos(-2);
                            break;
                    }
                }
                else {
                    switch(location){
                        case"Away":
                            DatabaseClass.setStartingPos(3);
                            break;
                        case "Middle":
                            break;
                        case "Closest":
                            DatabaseClass.setStartingPos(2);
                            break;
                    }
                }
            }
        });

        final EditText hatchesOnField = (EditText) view.findViewById(R.id.fieldHatchEditText);
        hatchesOnField.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                if(hatchesOnField.getText().toString().trim().equals("")) {
                }
                else {
                    Integer intHatchesOnField = Integer.valueOf(hatchesOnField.getText().toString());
                    DatabaseClass.setPreLoadHatch(intHatchesOnField);
                }
            }
        });

        final EditText cargoOnField = (EditText) view.findViewById(R.id.fieldCargoEditText);
        cargoOnField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                if(cargoOnField.getText().toString().trim().equals("")) {
                }
                else {
                    Integer intCargoOnField = Integer.valueOf(cargoOnField.getText().toString());
                    DatabaseClass.setPreLoadCargo(intCargoOnField);
                }
            }
        });


        return view;
    };
}
