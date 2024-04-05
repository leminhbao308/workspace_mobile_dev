package com.leminhbao.tuan01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BaiTap09_Activity extends AppCompatActivity {

    private EditText edtFahrenheit, edtCelsius;
    private Button btnConvertToFahrenheit, btnConvertToCelsius, btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bai_tap_09);

        edtFahrenheit = findViewById(R.id.edtFahrenheit);
        edtCelsius = findViewById(R.id.edtCelsius);

        btnConvertToFahrenheit = findViewById(R.id.btnConvertToFahrenheit);
        btnConvertToCelsius = findViewById(R.id.btnConvertToCelsius);
        btnClear = findViewById(R.id.btnClear);

        btnConvertToFahrenheit.setOnClickListener(v -> convertToFahrenheit());
        btnConvertToCelsius.setOnClickListener(v -> convertToCelsius());

        btnClear.setOnClickListener(v -> {
            edtFahrenheit.setText("");
            edtCelsius.setText("");
        });
    }

    private void convertToFahrenheit() {
        double celsius;

        try {
            celsius = Double.parseDouble(edtCelsius.getText().toString());
        } catch (NumberFormatException e) {
            edtCelsius.selectAll();
            edtCelsius.requestFocus();

            Toast.makeText(this, "Please enter a valid number", Toast.LENGTH_SHORT).show();
            return;
        }

        double fahrenheit = celsius * 1.8 + 32;
        edtFahrenheit.setText(String.valueOf(fahrenheit));
    }

    private void convertToCelsius() {
        double fahrenheit;

        try {
            fahrenheit = Double.parseDouble(edtFahrenheit.getText().toString());
        } catch (NumberFormatException e) {
            edtFahrenheit.selectAll();
            edtFahrenheit.requestFocus();

            Toast.makeText(this, "Please enter a valid number", Toast.LENGTH_SHORT).show();
            return;
        }

        double celsius = (fahrenheit - 32) / 1.8;
        edtCelsius.setText(String.valueOf(celsius));
    }
}