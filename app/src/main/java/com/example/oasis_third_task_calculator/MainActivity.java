package com.example.oasis_third_task_calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText inputResult;
    private String currentInput = "";

    private String operator ="";
    private Double operatorIcon = Double.NaN;
    private double operator2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputResult = findViewById(R.id.displayText);
        onEventLauncher();
    }

    private void onEventLauncher(){
        int[] buttons = new int[] {
                R.id.number0,R.id.number1,R.id.number2,R.id.number3,R.id.number4,R.id.number5,
                R.id.number6,R.id.number7,R.id.number8,R.id.number9,
                R.id.dot,R.id.divider,R.id.addition,R.id.substr,R.id.mulitper,R.id.equals,R.id.Clearbtn
        };

        for (int Id : buttons){
            Button button = findViewById(Id);
            button.setOnClickListener(this::ClickEvent);
        }
    }

    private void ClickEvent(View view){
        Button clickbutton = (Button) view;
        String buttonContent = clickbutton.getText().toString();

        switch (buttonContent){
            case "+":

            case "-":

            case "*":

            case "/":
                operator = buttonContent;
                operatorIcon = Double.parseDouble(currentInput);
                currentInput ="";
                break;
            case "=":
                if(!Double.isNaN(operatorIcon)){
                    operator2 = Double.parseDouble(currentInput);
                    double result = performOperation();
                    inputResult.setText(String.valueOf(result));
                    operatorIcon =Double.NaN;
                    operator ="";
                    currentInput =String.valueOf(result);
                }
                break;
            case ".":
                if(!currentInput.contains(".")){
                    currentInput += buttonContent;
                    inputResult.setText(currentInput);
                }
                break;
            case "C":
                currentInput = "";
                inputResult.setText(currentInput);
                break;
            default:
                currentInput += buttonContent;
                inputResult.setText(currentInput);


        }
    }
    private double performOperation() {
        switch (operator) {
            case "+":
                return operatorIcon + operator2;
            case "-":
                return operatorIcon - operator2;
            case "*":
                return operatorIcon * operator2;
            case "/":
                return operatorIcon / operator2;
            default:
                return Double.NaN;
        }
    }

}