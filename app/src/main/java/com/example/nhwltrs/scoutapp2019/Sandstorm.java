package com.example.nhwltrs.scoutapp2019;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Sandstorm extends Fragment {
    private static final String TAG =
            "Sandstorm";
    int cargoShipHatchCounter = 0;

    MatchData parent;

    public Sandstorm() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sandstorm, container, false);

        Button cargoPlusButton = (Button) view.findViewById(R.id.cargoPlusButton);

        final TextView cargoShipHatchCounterTextView = (TextView) view.findViewById(R.id.cargoShipHatchCounterTextView);


        cargoPlusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(parent.started) {
                    cargoShipHatchCounter++;
                    cargoShipHatchCounterTextView.setText(cargoShipHatchCounter + "");
                }
            }
        });

        return view;
    }

}
