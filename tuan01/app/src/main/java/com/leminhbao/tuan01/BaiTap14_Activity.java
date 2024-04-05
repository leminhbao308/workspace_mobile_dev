package com.leminhbao.tuan01;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class BaiTap14_Activity extends AppCompatActivity {

    private EditText edtFullname, edtIdentify;

    private RadioGroup rgCertificate;

    private CheckBox chbReadBook, chbReadNewsPaper, chbReadCode;

    private EditText edtMultiLineAdditionalInfo;

    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bai_tap_14);

        edtFullname = findViewById(R.id.edtFullname);
        edtIdentify = findViewById(R.id.edtIdentify);

        rgCertificate = findViewById(R.id.rgCertificate);

        chbReadBook = findViewById(R.id.chbReadBook);
        chbReadNewsPaper = findViewById(R.id.chbReadNewsPaper);
        chbReadCode = findViewById(R.id.chbReadCode);

        edtMultiLineAdditionalInfo = findViewById(R.id.edtMultiLineAdditionalInfo);

        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(v -> {
            String fullname = edtFullname.getText().toString();
            String identify = edtIdentify.getText().toString();
            String certificate = getCertificate();
            String hobbies = getHobbies();
            String additionalInfo = edtMultiLineAdditionalInfo.getText().toString();

            if (!validName(fullname)) {
                Toast.makeText(this, "Invalid fullname, must only contain letters", Toast.LENGTH_SHORT).show();
                edtFullname.selectAll();
                edtFullname.requestFocus();

                return;
            }

            if (!validIdentify(identify)) {
                Toast.makeText(this, "Invalid identify, (0-9), 9 digits", Toast.LENGTH_SHORT).show();
                edtIdentify.selectAll();
                edtIdentify.requestFocus();

                return;
            }

            if (hobbies == null) {
                Toast.makeText(this, "Please select at least one hobby", Toast.LENGTH_SHORT).show();

                return;
            }

            StringBuilder message = new StringBuilder();

            message.append(fullname).append("\n");
            message.append(identify).append("\n");
            message.append(certificate).append("\n");
            message.append(hobbies).append("\n");
            message.append("--------------------------").append("\n");
            message.append("Thông Tin Bổ Sung:").append("\n");
            message.append(additionalInfo).append("\n");
            message.append("--------------------------").append("\n");


            AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
            alertBuilder.setTitle("Thông Tin Cá Nhân");
            alertBuilder.setMessage(message.toString());
            alertBuilder.setPositiveButton("Đóng", (dialog, which) -> dialog.dismiss());

            alertBuilder.show();
        });
    }

    private boolean validName(String name) {
        return name.length() > 0 && name.matches("^[a-zA-Z\\s]*$");
    }

    private boolean validIdentify(String identify) {
        return identify.matches("^[0-9]{9}$");
    }

    private String getCertificate() {
        int selectedId = rgCertificate.getCheckedRadioButtonId();
        RadioButton selectedRadioButton = findViewById(selectedId);

        return selectedRadioButton.getText().toString();
    }

    private String getHobbies() {
        StringBuilder hobbies = new StringBuilder();

        // if nothing is checked, return null
        if (!chbReadBook.isChecked() && !chbReadNewsPaper.isChecked() && !chbReadCode.isChecked()) {
            return null;
        }

        if (chbReadBook.isChecked()) {
            hobbies.append(chbReadBook.getText().toString()).append(" - ");
        }

        if (chbReadNewsPaper.isChecked()) {
            hobbies.append(chbReadNewsPaper.getText().toString()).append(" - ");
        }

        if (chbReadCode.isChecked()) {
            hobbies.append(chbReadCode.getText().toString()).append(" - ");
        }

        // remove the last " - "
        return hobbies.delete(hobbies.length() - 3, hobbies.length()).toString();
    }
}