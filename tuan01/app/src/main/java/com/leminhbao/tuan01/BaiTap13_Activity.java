package com.leminhbao.tuan01;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BaiTap13_Activity extends AppCompatActivity {

    private EditText edtDuongLich;
    private Button btnChuyenDoi;
    private TextView tvAmLich;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bai_tap_13);

        edtDuongLich = findViewById(R.id.edtDuongLich);
        btnChuyenDoi = findViewById(R.id.btnChuyenDoi);
        tvAmLich = findViewById(R.id.tvAmLich);

        btnChuyenDoi.setOnClickListener(v -> {
            int namDuongLich;

            try {
                namDuongLich = Integer.parseInt(edtDuongLich.getText().toString());
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Vui lòng nhập năm dương lịch", Toast.LENGTH_SHORT).show();
                return;
            }

            tvAmLich.setText(chuyenDoiLichAm(namDuongLich));
        });
    }

    private String chuyenDoiLichAm(int namDuongLich) {
        String can = "", chi = "";

        switch (namDuongLich % 10) {
            case 0:
                can = "Canh";
                break;
            case 1:
                can = "Tân";
                break;
            case 2:
                can = "Nhâm";
                break;
            case 3:
                can = "Quý";
                break;
            case 4:
                can = "Giáp";
                break;
            case 5:
                can = "Ất";
                break;
            case 6:
                can = "Bính";
                break;
            case 7:
                can = "Đinh";
                break;
            case 8:
                can = "Mậu";
                break;
            case 9:
                can = "Kỷ";
                break;
        }

        switch (namDuongLich % 12) {
            case 0:
                chi = "Thân";
                break;
            case 1:
                chi = "Dậu";
                break;
            case 2:
                chi = "Tuất";
                break;
            case 3:
                chi = "Hợi";
                break;
            case 4:
                chi = "Tý";
                break;
            case 5:
                chi = "Sửu";
                break;
            case 6:
                chi = "Dần";
                break;
            case 7:
                chi = "Mẹo";
                break;
            case 8:
                chi = "Thìn";
                break;
            case 9:
                chi = "Tỵ";
                break;
            case 10:
                chi = "Ngọ";
                break;
            case 11:
                chi = "Mùi";
                break;
        }

        return can + " " + chi;
    }
}