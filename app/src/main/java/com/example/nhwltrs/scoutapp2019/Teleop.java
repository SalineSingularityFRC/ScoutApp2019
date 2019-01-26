package com.example.nhwltrs.scoutapp2019;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Teleop extends Fragment {
    private static final String TAG = "Teleop";

    public Teleop() {
        // Required empty public constructor
    }
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


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_teleop, container, false);

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
                }
            });

            cargoMinusButton.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    if(cargoShipHatchCounter>0) {
                        cargoShipHatchCounter--;
                        cargoShipHatchCounterTextView.setText(cargoShipHatchCounter + "");
                    }
                }
            });

            rocket1PlusButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    rocket1HatchCounter++;
                    rocket1HatchCounterTextView.setText(rocket1HatchCounter + "");
                }
            });
            rocket1MinusButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(rocket1HatchCounter > 0) {
                        rocket1HatchCounter--;
                        rocket1HatchCounterTextView.setText(rocket1HatchCounter + "");
                    }
                }
            });


            rocket2PlusButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    rocket2HatchCounter++;
                    rocket2HatchCounterTextView.setText(rocket2HatchCounter + "");
                }
            });
            rocket2MinusButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(rocket2HatchCounter > 0) {
                        rocket2HatchCounter--;
                        rocket2HatchCounterTextView.setText(rocket2HatchCounter + "");
                    }
                }
            });

            rocket3PlusButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    rocket3HatchCounter++;
                    rocket3HatchCounterTextView.setText(rocket3HatchCounter + "");
                }
            });
            rocket3MinusButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(rocket3HatchCounter > 0) {
                        rocket3HatchCounter--;
                        rocket3HatchCounterTextView.setText(rocket3HatchCounter + "");
                    }
                }
            });

            cargoPlusButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    cargoShipCargoCounter++;
                    cargoShipCargoCounterTextView.setText(cargoShipCargoCounter + "");
                }
            });

            cargoMinusButton2.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    if(cargoShipCargoCounter>0) {
                        cargoShipCargoCounter--;
                        cargoShipCargoCounterTextView.setText(cargoShipCargoCounter + "");
                    }
                }
            });

            rocket1PlusButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    rocket1CargoCounter++;
                    rocket1CargoCounterTextView.setText(rocket1CargoCounter + "");
                }
            });
            rocket1MinusButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(rocket1CargoCounter > 0) {
                        rocket1CargoCounter--;
                        rocket1CargoCounterTextView.setText(rocket1CargoCounter + "");
                    }
                }
            });


            rocket2PlusButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    rocket2CargoCounter++;
                    rocket2CargoCounterTextView.setText(rocket2CargoCounter + "");
                }
            });
            rocket2MinusButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(rocket2CargoCounter > 0) {
                        rocket2CargoCounter--;
                        rocket2CargoCounterTextView.setText(rocket2CargoCounter + "");
                    }
                }
            });

            rocket3PlusButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    rocket3CargoCounter++;
                    rocket3CargoCounterTextView.setText(rocket3CargoCounter + "");
                }
            });
            rocket3MinusButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(rocket3CargoCounter > 0) {
                        rocket3CargoCounter--;
                        rocket3CargoCounterTextView.setText(rocket3CargoCounter + "");
                    }
                }
            });

            final Spinner climbing = (Spinner) view.findViewById(R.id.climbingSpinner);

            List<String> list = new ArrayList<String>();
            list.add("None");
            list.add("Level 1");
            list.add("Level 2");
            list.add("Level 3");
            final int listsize = list.size();
            list.add("None"); //This is correct

            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, list) {
                @Override
                public int getCount() {
                    return (listsize);
                }
            };
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            climbing.setAdapter(dataAdapter);
            climbing.setSelection(listsize);

            //Database stuff
            climbing.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    String startingPos = climbing.getSelectedItem().toString();
                    switch (startingPos) {
                        case "None":
                            break;
                        case "Level 1":
                            break;
                        case "Level 2":
                            break;
                        case "Level 3":
                            break;
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }

            });


            return view;
    }
}

