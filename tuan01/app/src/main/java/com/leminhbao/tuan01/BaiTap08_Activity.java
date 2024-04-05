package com.leminhbao.tuan01;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BaiTap08_Activity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtSoA, edtSoB;

    private TextView tvResult;

    private Button buttonTong, buttonHieu, buttonTich, buttonThuong;

    private Button buttonUCLN, buttonExit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bai_tap_08);

        // Anh xa id
        edtSoA = findViewById(R.id.edtSoA);
        edtSoB = findViewById(R.id.edtSoB);

        tvResult = findViewById(R.id.tvResult);

        buttonTong = findViewById(R.id.buttonTong);
        buttonHieu = findViewById(R.id.buttonHieu);
        buttonTich = findViewById(R.id.buttonTich);
        buttonThuong = findViewById(R.id.buttonThuong);

        buttonUCLN = findViewById(R.id.buttonUCLN);
        buttonExit = findViewById(R.id.buttonExit);

        // Set event click
        buttonHieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a;
                int b;

                try {
                    a = Integer.parseInt(edtSoA.getText().toString());
                } catch (NumberFormatException e) {
                    edtSoA.selectAll();
                    edtSoA.requestFocus();

                    Toast.makeText(BaiTap08_Activity.this, "Số A không hợp lệ", Toast.LENGTH_SHORT).show();
                    return;
                }

                try {
                    b = Integer.parseInt(edtSoB.getText().toString());
                } catch (NumberFormatException e) {
                    edtSoB.selectAll();
                    edtSoB.requestFocus();

                    Toast.makeText(BaiTap08_Activity.this, "Số B không hợp lệ", Toast.LENGTH_SHORT).show();
                    return;
                }

                int result = a - b;
                tvResult.setText(String.valueOf(result));
            }
        });

        buttonTich.setOnClickListener(this);


        View.OnClickListener divisionListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int soA = Integer.parseInt(edtSoA.getText().toString());
                int soB = Integer.parseInt(edtSoB.getText().toString());

                if (soB != 0) {
                    double thuong = (double) soA / soB;
                    tvResult.setText(String.valueOf(thuong));
                } else {
                    tvResult.setText("Không thể chia cho 0");
                }
            }
        };
        buttonThuong.setOnClickListener(divisionListener);

        buttonUCLN.setOnClickListener(new UCLNClickListener());
    }

    public void calcSum(View view) {
        int a = Integer.parseInt(edtSoA.getText().toString());
        int b = Integer.parseInt(edtSoB.getText().toString());
        int result = a + b;
        tvResult.setText(String.valueOf(result));
    }



    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.buttonTich) {
            int soA = Integer.parseInt(edtSoA.getText().toString());
            int soB = Integer.parseInt(edtSoB.getText().toString());

            int tich = soA * soB;
            tvResult.setText(String.valueOf(tich));
        }
    }

    public class UCLNClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            // Xử lý tính toán ước số chung lớn nhất và hiển thị kết quả
            // Ví dụ:
            EditText edtSoA = findViewById(R.id.edtSoA);
            EditText edtSoB = findViewById(R.id.edtSoB);
            TextView tvResult = findViewById(R.id.tvResult);

            int soA = Integer.parseInt(edtSoA.getText().toString());
            int soB = Integer.parseInt(edtSoB.getText().toString());

            int ucln = calcUCLN(soA, soB);
            tvResult.setText(String.valueOf(ucln));
        }

        private int calcUCLN(int a, int b) {
            if (b == 0) {
                return a;
            }
            return calcUCLN(b, a % b);
        }
    }
}