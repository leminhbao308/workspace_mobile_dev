package com.leminhbao.tuan01;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BaiTap10_Activity extends AppCompatActivity {

    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    private Button btnDot;
    private Button btnCong, btnTru, btnNhan, btnChia;
    private Button btnDelete, btnEqual;

    private TextView txvResult, txvInput;
    double result;
    String inputSetText = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bai_tap_10);

//        Ánh xạ id cho các đối  tượng
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

        btnDot = findViewById(R.id.btnDot);

        btnCong = findViewById(R.id.btnCong);
        btnTru = findViewById(R.id.btnTru);
        btnNhan = findViewById(R.id.btnNhan);
        btnChia = findViewById(R.id.btnChia);

        btnDelete = findViewById(R.id.btnDelete);
        btnEqual = findViewById(R.id.btnEqual);

        txvResult = findViewById(R.id.tvOutput);
        txvInput = findViewById(R.id.tvInput);

//        xử lý sự kiện


        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputSetText += "0";
                txvInput.setText(inputSetText);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputSetText += "1";
                txvInput.setText(inputSetText);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputSetText += "2";
                txvInput.setText(inputSetText);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputSetText += "3";
                txvInput.setText(inputSetText);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputSetText.concat("4");
                txvInput.setText(inputSetText);
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputSetText += "5";
                txvInput.setText(inputSetText);
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputSetText += "6";
                txvInput.setText(inputSetText);
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputSetText += "7";
                txvInput.setText(inputSetText);
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputSetText += "8";
                txvInput.setText(inputSetText);
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputSetText += "9";
                txvInput.setText(inputSetText);
            }
        });

        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputSetText += ".";
                txvInput.setText(inputSetText);
                System.out.println(inputSetText);
            }
        });

        btnCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputSetText += " + ";
                txvInput.setText(inputSetText);
            }
        });

        btnTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputSetText += " - ";
                txvInput.setText(inputSetText);
            }
        });

        btnNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputSetText += " x ";
                txvInput.setText(inputSetText);
            }
        });

        btnChia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputSetText += " / ";
                txvInput.setText(inputSetText);
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txvInput.setText("");
                txvResult.setText("");
                inputSetText = "";
            }
        });

        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double result;
                if (String.valueOf(txvInput.getText()).contains("+")) {
                    String[] arr = String.valueOf(txvInput.getText()).split(" + ");
                    result = Double.parseDouble(arr[0]) + Double.parseDouble(arr[1]);
                    txvResult.setText(String.valueOf(result));
                } else if (String.valueOf(txvInput.getText()).contains("-")) {
                    String[] arr = String.valueOf(txvInput.getText()).split("-");
                    result = Double.parseDouble(arr[0]) - Double.parseDouble(arr[1]);
                    txvResult.setText(String.valueOf(result));
                } else if (String.valueOf(txvInput.getText()).contains("x")) {
                    String[] arr = String.valueOf(txvInput.getText()).split("x");
                    result = Double.parseDouble(arr[0]) * Double.parseDouble(arr[1]);
                    txvResult.setText(String.valueOf(result));
                } else if (String.valueOf(txvInput.getText()).contains("/")) {
                    String[] arr = String.valueOf(txvInput.getText()).split("/");

                    if (Double.parseDouble(arr[1]) == 0) {
                        txvResult.setText("mẫu không bằng 0");
                    } else {
                        result = Double.parseDouble(arr[0]) / Double.parseDouble(arr[1]);
                        txvResult.setText(String.valueOf(result));
                    }

                }
            }
        });
    }
}