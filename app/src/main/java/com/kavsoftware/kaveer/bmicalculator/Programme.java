package com.kavsoftware.kaveer.bmicalculator;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.text.DecimalFormat;


/**
 * A simple {@link Fragment} subclass.
 */
public class Programme extends Fragment {

    Spinner Sweight;
    Spinner Sheight;
    EditText weight;
    EditText height;
    EditText result;

    public Programme() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_programme, container, false);

        InitializeText(view);

        Button calculate   = (Button)view.findViewById(R.id.BtnCalculate);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (IsValid()){
                    Float weight = ConvertWeight();
                    Float height = ConvertHeight();

                    DecimalFormat df = new DecimalFormat("#.##");

                    result.setText(df.format(Result(weight , height)).toString());
                }
            }


        });

        Button info   = (Button)view.findViewById(R.id.BtnInfo);
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }


        });

        return  view;
    }

    private Float ConvertHeight() {
        Float result = 0.0f;
        Float heightResult = 0.0f;
        String unit = Sheight.getSelectedItem().toString();

        switch (unit){
            case "ft":
                heightResult = Float.parseFloat(height.getText().toString());
                result = heightResult * 12.0f;
                break;
            case "cm":
                heightResult = Float.parseFloat(height.getText().toString());
                result = heightResult * 0.3937f;
                break;
            default:
                result = 0.0f;
        }
        return result;
    }

    private Float ConvertWeight() {
        Float result = 0.0f;
        String unit = Sweight.getSelectedItem().toString();

        switch (unit){
            case "kg":
                Float weightResult = Float.parseFloat(weight.getText().toString());
                result = weightResult * 2.2f;
                break;
            case "lbs":
                result = Float.parseFloat(weight.getText().toString());
                break;
            default:
                result = 0.0f;
        }
        return result;
    }

    private Float Result(Float weight, Float height) {
        Float result = 0.0f;
        Float resultWeight;
        Float resultHeight;

        resultWeight = weight * 0.45f;
        resultHeight = height * 0.025f;

        resultHeight = resultHeight * resultHeight;

        result = resultWeight/resultHeight;

        return result;
    }

    private boolean IsValid() {
        boolean result = true;

        if (weight.getText().toString().trim().length() == 0){
            weight.setError("Enter your weight");
            return false;
        }

        if (height.getText().toString().trim().length() == 0){
            height.setError("Enter your height");
            return false;
        }

        return result;
    }

    private void InitializeText(View view) {
        Sweight = (Spinner) view.findViewById(R.id.SpinnerWeight);
        Sheight = (Spinner) view.findViewById(R.id.SpinnerHeight);
        weight = (EditText) view.findViewById(R.id.TxtWeight);
        height = (EditText) view.findViewById(R.id.TxtHeight);
        result = (EditText) view.findViewById(R.id.TxtResult);
    }


}
