package com.example.nhwltrs.scoutapp2019;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class Sandstorm extends Fragment {
    private static final String TAG =
            "Sandstorm";
    //Creating counter variables
    int cargoShipHatchCounter = 0;
    int rocket1HatchCounter = 0;
    int rocket2HatchCounter = 0;
    int rocket3HatchCounter = 0;

    int cargoShipCargoCounter = 0;
    int rocket1CargoCounter = 0;
    int rocket2CargoCounter = 0;
    int rocket3CargoCounter = 0;

    MatchData parent;

    @SuppressLint("ValidFragment")
    public Sandstorm(MatchData matchData) {
        parent = matchData;
    }

    public Sandstorm() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sandstorm, container, false);

        //Setting buttons to variables
        Button cargoPlusButton = (Button) view.findViewById(R.id.cargoPlusButton);
        Button cargoMinusButton = (Button) view.findViewById(R.id.cargoMinusButton);

        Button rocket1PlusButton = (Button) view.findViewById(R.id.rocket1PlusButton);
        Button rocket1MinusButton = (Button) view.findViewById(R.id.rocket1MinusButton);

        Button rocket2PlusButton = (Button) view.findViewById(R.id.rocket2PlusButton);
        Button rocket2MinusButton = (Button) view.findViewById(R.id.rocket2MinusButton);

        Button rocket3PlusButton = (Button) view.findViewById(R.id.rocket3PlusButton);
        Button rocket3MinusButton = (Button) view.findViewById(R.id.rocket3MinusButton);

        //Second Column
        Button cargoPlusButton2 = (Button) view.findViewById(R.id.cargoPlusButton2);
        Button cargoMinusButton2 = (Button) view.findViewById(R.id.cargoMinusButton2);

        Button rocket1PlusButton2 = (Button) view.findViewById(R.id.rocket1PlusButton2);
        Button rocket1MinusButton2 = (Button) view.findViewById(R.id.rocket1MinusButton2);

        Button rocket2PlusButton2 = (Button) view.findViewById(R.id.rocket2PlusButton2);
        Button rocket2MinusButton2 = (Button) view.findViewById(R.id.rocket2MinusButton2);

        Button rocket3PlusButton2 = (Button) view.findViewById(R.id.rocket3PlusButton2);
        Button rocket3MinusButton2 = (Button) view.findViewById(R.id.rocket3MinusButton2);

        //Setting counter values to the variables 
        final TextView cargoShipHatchCounterTextView = (TextView) view.findViewById(R.id.cargoShipHatchCounterTextView);
        final TextView rocket1HatchCounterTextView = (TextView) view.findViewById(R.id.rocket1HatchCounterTextView);
        final TextView rocket2HatchCounterTextView = (TextView) view.findViewById(R.id.rocket2HatchCounterTextView);
        final TextView rocket3HatchCounterTextView = (TextView) view.findViewById(R.id.rocket3HatchCounterTextView);

        final TextView cargoShipCargoCounterTextView = (TextView) view.findViewById(R.id.cargoShipCargoCounterTextView);
        final TextView rocket1CargoCounterTextView = (TextView) view.findViewById(R.id.rocket1CargoCounterTextView);
        final TextView rocket2CargoCounterTextView = (TextView) view.findViewById(R.id.rocket2CargoCounterTextView);
        final TextView rocket3CargoCounterTextView = (TextView) view.findViewById(R.id.rocket3CargoCounterTextView);

        cargoPlusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cargoShipHatchCounter++;
                cargoShipHatchCounterTextView.setText(cargoShipHatchCounter + "");
                //DatabaseClass.addCargoShipHatch(parent.getTimer());
            }
        });

        cargoMinusButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(cargoShipHatchCounter>0) {
                    cargoShipHatchCounter--;
                    cargoShipHatchCounterTextView.setText(cargoShipHatchCounter + "");
                    //DatabaseClass.removeCargoShipHatch();
                }
            }
        });

        rocket1PlusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rocket1HatchCounter++;
                rocket1HatchCounterTextView.setText(rocket1HatchCounter + "");
                //DatabaseClass.addRocketFirstLevelHatch(parent.getTimer());
            }
        });

        rocket1MinusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rocket1HatchCounter > 0) {
                    rocket1HatchCounter--;
                    rocket1HatchCounterTextView.setText(rocket1HatchCounter + "");
                    //DatabaseClass.removeRocketFirstLevelHatch();
                }
            }
        });


        rocket2PlusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rocket2HatchCounter++;
                rocket2HatchCounterTextView.setText(rocket2HatchCounter + "");
                //DatabaseClass.addRocketSecondLevelHatch(parent.getTimer());
            }
        });

        rocket2MinusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rocket2HatchCounter > 0) {
                    rocket2HatchCounter--;
                    rocket2HatchCounterTextView.setText(rocket2HatchCounter + "");
                    //DatabaseClass.removeRocketSecondLevelHatch();
                }
            }
        });

        rocket3PlusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rocket3HatchCounter++;
                rocket3HatchCounterTextView.setText(rocket3HatchCounter + "");
                //DatabaseClass.addRocketThirdLevelHatch(parent.getTimer());
            }
        });
        rocket3MinusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rocket3HatchCounter > 0) {
                    rocket3HatchCounter--;
                    rocket3HatchCounterTextView.setText(rocket3HatchCounter + "");
                    //DatabaseClass.removeRocketThirdLevelHatch();
                }
            }
        });

        //Second Column starts
        cargoPlusButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cargoShipCargoCounter++;
                cargoShipCargoCounterTextView.setText(cargoShipCargoCounter + "");
                //DatabaseClass.addCargoShipCargo(parent.getTimer());
            }
        });
        cargoMinusButton2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(cargoShipCargoCounter>0) {
                    cargoShipCargoCounter--;
                    cargoShipCargoCounterTextView.setText(cargoShipCargoCounter + "");
                    //DatabaseClass.removeCargoShipCargo();
                }
            }
        });

        rocket1PlusButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rocket1CargoCounter++;
                rocket1CargoCounterTextView.setText(rocket1CargoCounter + "");
                //DatabaseClass.addRocketFirstLevelCargo(parent.getTimer());
            }
        });
        rocket1MinusButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rocket1CargoCounter > 0) {
                    rocket1CargoCounter--;
                    rocket1CargoCounterTextView.setText(rocket1CargoCounter + "");
                    //DatabaseClass.removeRocketFirstLevelCargo();
                }
            }
        });


        rocket2PlusButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rocket2CargoCounter++;
                rocket2CargoCounterTextView.setText(rocket2CargoCounter + "");
                //DatabaseClass.addRocketSecondLevelCargo(parent.getTimer());
            }
        });
        rocket2MinusButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rocket2CargoCounter > 0) {
                    rocket2CargoCounter--;
                    rocket2CargoCounterTextView.setText(rocket2CargoCounter + "");
                    //DatabaseClass.removeRocketSecondLevelCargo();
                }
            }
        });

        rocket3PlusButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rocket3CargoCounter++;
                rocket3CargoCounterTextView.setText(rocket3CargoCounter + "");
                //DatabaseClass.addRocketThirdLevelCargo(parent.getTimer());
            }
        });
        rocket3MinusButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rocket3CargoCounter > 0) {
                    rocket3CargoCounter--;
                    rocket3CargoCounterTextView.setText(rocket3CargoCounter + "");
                    //DatabaseClass.removeRocketThirdLevelCargo();
                }
            }
        });

        final CheckBox exitHabitat = (CheckBox)view.findViewById(R.id.exitHabitatCheckBox);
        exitHabitat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        return view;
    }

}
