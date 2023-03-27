package com.example.week2task;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button convertButton;
    TextView resultView;
    EditText userInput;

    String FromSelectedUnit, ToSelectedUnit, FinalResult;
    double result = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        convertButton = findViewById(R.id.convert);
        resultView = findViewById(R.id.result);
        Spinner fromUnitSpinner = (Spinner) findViewById(R.id.fromUnit);
        Spinner toUnitSpinner = (Spinner) findViewById(R.id.toUnit);
        userInput = findViewById(R.id.userInput);

        fromUnitSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View view, int arg2, long arg3) {
                FromSelectedUnit= fromUnitSpinner.getSelectedItem().toString().toLowerCase();
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                FromSelectedUnit = "inch";
            }
        });
        toUnitSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View view, int arg2, long arg3) {
                ToSelectedUnit= toUnitSpinner.getSelectedItem().toString().toLowerCase();
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                ToSelectedUnit = "inch";
            }
        });

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = userInput.getText().toString().trim();
                if(TextUtils.isEmpty(input)) {
                    Toast.makeText(MainActivity.this, "Input Field is empty", Toast.LENGTH_SHORT).show();
                    return;
                }

                try {
                    double inputNumber = Double.parseDouble(input);
                    switch (FromSelectedUnit) {
                        case "foot":
                            switch (ToSelectedUnit) {
                                case "inch":
                                    result = inputNumber * 12.0;
                                    FinalResult = Double.toString(result);
                                    break;
                                case "yard":
                                    result = inputNumber / 3.0;
                                    FinalResult = Double.toString(result);
                                    break;
                                case "mile":
                                    result = inputNumber / 5280.0;
                                    FinalResult = Double.toString(result);
                                    break;
                                default:
                                    result = inputNumber;
                                    FinalResult = Double.toString(result);
                                    break;
                            }
                            break;
                        case "inch":
                            switch (ToSelectedUnit) {
                                case "foot":
                                    result = inputNumber / 12.0;
                                    FinalResult = Double.toString(result);
                                    break;
                                case "yard":
                                    result = inputNumber / 36.0;
                                    FinalResult = Double.toString(result);
                                    break;
                                case "mile":
                                    result = inputNumber / 63360.0;
                                    FinalResult = Double.toString(result);
                                    break;
                                default:
                                    result = inputNumber;
                                    FinalResult = Double.toString(result);
                                    break;
                            }
                            break;
                        case "yard":
                            switch (ToSelectedUnit) {
                                case "foot":
                                    result = inputNumber * 3.0;
                                    FinalResult = Double.toString(result);
                                    break;
                                case "inch":
                                    result = inputNumber * 36.0;
                                    FinalResult = Double.toString(result);
                                    break;
                                case "mile":
                                    result = inputNumber / 1760.0;
                                    FinalResult = Double.toString(result);
                                    break;
                                default:
                                    result = inputNumber;
                                    FinalResult = Double.toString(result);
                                    break;
                            }
                            break;
                            case "mile":
                            switch (ToSelectedUnit) {
                                case "foot":
                                    result = inputNumber * 5280.0;
                                    FinalResult = Double.toString(result);
                                    break;
                                case "inch":
                                    result = inputNumber * 63360.0;
                                    FinalResult = Double.toString(result);
                                    break;
                                case "yard":
                                    result = inputNumber * 1760.0;
                                    FinalResult = Double.toString(result);
                                    break;
                                default:
                                    result = inputNumber;
                                    FinalResult = Double.toString(result);
                                    break;
                            }
                            break;
                        default:
                            result = inputNumber;
                            FinalResult = Double.toString(result);
                            break;
                    }
                } catch (NumberFormatException a) {
                    Toast.makeText(MainActivity.this, "input is  not a number", Toast.LENGTH_SHORT).show();
                }
                resultView.setText("Result: "+FinalResult + " " + ToSelectedUnit);
                Toast.makeText(MainActivity.this, FromSelectedUnit + " To " + ToSelectedUnit, Toast.LENGTH_SHORT).show();
            }
        });
    }
}