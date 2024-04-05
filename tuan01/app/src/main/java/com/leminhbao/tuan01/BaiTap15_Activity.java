package com.leminhbao.tuan01;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class BaiTap15_Activity extends AppCompatActivity {

    // Invoice Information
    private EditText edtCustomerName, edtBookQuantity;
    private CheckBox chkIsVIP;
    private TextView tvTotalMoney;
    private Button btnCalculate, btnNext, btnStatistics;

    // Statistics Information
    private EditText edtTotalCustomer, edtTotalVIPCustomer, edtTotalIncome;

    private ImageButton btnPowerOff;

    // Data
    private int totalCustomer = 0;
    private int totalVIPCustomer = 0;
    private double totalIncome = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bai_tap_15);

        // Invoice Information
        edtCustomerName = findViewById(R.id.edtCustomerName);
        edtBookQuantity = findViewById(R.id.edtBookQuantity);

        chkIsVIP = findViewById(R.id.chkIsVIP);

        tvTotalMoney = findViewById(R.id.tvTotalMoney);

        btnCalculate = findViewById(R.id.btnCalculate);
        btnNext = findViewById(R.id.btnNext);
        btnStatistics = findViewById(R.id.btnStatistics);

        // Statistics Information
        edtTotalCustomer = findViewById(R.id.edtTotalCustomer);
        edtTotalVIPCustomer = findViewById(R.id.edtTotalVIPCustomer);
        edtTotalIncome = findViewById(R.id.edtTotalIncome);

        btnPowerOff = findViewById(R.id.btnPowerOff);

        btnCalculate.setOnClickListener(v -> addCalculateEvent());
        btnNext.setOnClickListener(v -> addNextEvent());
        btnStatistics.setOnClickListener(v -> addStatisticsEvent());

        btnPowerOff.setOnClickListener(v -> addPowerOffEvent());
    }

    private void addCalculateEvent() {
        // Validate data before calculate
        // make sure customer name is not empty
        if (edtCustomerName.getText().toString().isEmpty()) {
            edtCustomerName.requestFocus();
            Toast.makeText(this, "Please enter customer name", Toast.LENGTH_SHORT).show();
            return;
        }
        // make sure book quantity is not empty
        if (edtBookQuantity.getText().toString().isEmpty()) {
            edtBookQuantity.requestFocus();
            Toast.makeText(this, "Please enter book quantity", Toast.LENGTH_SHORT).show();
            return;
        }

        int bookQuantity;

        try {
            bookQuantity = Integer.parseInt(edtBookQuantity.getText().toString());
        } catch (Exception e) {
            edtBookQuantity.setText("");
            Toast.makeText(this, "Please enter a valid number", Toast.LENGTH_SHORT).show();
            return;
        }

        double totalMoney = 0.0;

        if (chkIsVIP.isChecked()) {
            totalMoney = bookQuantity * 20000 * 0.9;
        } else {
            totalMoney = bookQuantity * 20000;
        }

        tvTotalMoney.setText(String.valueOf(totalMoney));
    }

    private void addNextEvent() {
        double totalMoney;
        try {
            totalMoney = Double.parseDouble(tvTotalMoney.getText().toString());
        } catch (Exception e) {
            tvTotalMoney.setText("");
            btnCalculate.requestFocus();
            Toast.makeText(this, "Please calculate total money first", Toast.LENGTH_SHORT).show();
            return;
        }

        // Update statistics
        totalCustomer++;
        if (chkIsVIP.isChecked()) {
            totalVIPCustomer++;
        }
        totalIncome += totalMoney;

        // Clear display
        edtCustomerName.setText("");
        edtBookQuantity.setText("");
        chkIsVIP.setChecked(false);
        tvTotalMoney.setText("");

        edtCustomerName.requestFocus();
        Toast.makeText(this, "Next customer", Toast.LENGTH_SHORT).show();
    }

    private void addStatisticsEvent() {
        edtTotalCustomer.setText(String.valueOf(totalCustomer));
        edtTotalVIPCustomer.setText(String.valueOf(totalVIPCustomer));
        edtTotalIncome.setText(String.valueOf(totalIncome));

        Toast.makeText(this, "Statistics updated", Toast.LENGTH_SHORT).show();
    }

    private void addPowerOffEvent() {
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
        alertBuilder.setTitle("Are you sure?");
        alertBuilder.setMessage("Do you want to quit the app?");

        alertBuilder.setPositiveButton("Yes", (dialog, which) -> finish());
        alertBuilder.setNegativeButton("No", (dialog, which) -> dialog.dismiss());

        alertBuilder.show();
    }
}