package com.example.nhwltrs.scoutapp2019;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.List;


public class Pregame extends Fragment {
    private static final String TAG = "Pregame";

    public Pregame() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pregame, container, false);

        final Spinner startingPosition = (Spinner) view.findViewById(R.id.spinnerStartPosition);

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
                        break;
                    case "Middle":
                        break;
                    case "Closest":
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
        robotPreload.setAdapter(dataAdapter2);//This is the line that is screwed up
        robotPreload.setSelection(listsize2);

            //Database stuff
        robotPreload.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    String robotPre = robotPreload.getSelectedItem().toString();
                    switch(robotPre) {
                        case "Cargo":
                            break;
                        case "Hatch":
                            break;
                        case "None":
                            break;
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
        });
        return view;
    };
}
