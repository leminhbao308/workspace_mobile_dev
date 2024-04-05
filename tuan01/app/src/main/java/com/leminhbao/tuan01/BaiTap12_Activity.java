package com.leminhbao.tuan01;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class BaiTap12_Activity extends AppCompatActivity {

    private EditText edtUser, edtPassword;
    private CheckBox chkSaveInfo;
    private Button btnLogin, btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bai_tap_12);

        edtUser = findViewById(R.id.edtUser);
        edtPassword = findViewById(R.id.edtPassword);

        chkSaveInfo = findViewById(R.id.chkSaveInfo);

        btnLogin = findViewById(R.id.btnLogin);
        btnExit = findViewById(R.id.btnExit);

        btnLogin.setOnClickListener(v -> {
            String user = edtUser.getText().toString();
            String password = edtPassword.getText().toString();
            boolean saveInfo = chkSaveInfo.isChecked();

            if (saveInfo) {
                Toast.makeText(this, "Chào mừng bạn đăng nhập hệ thống, bạn đã lưu thông tin", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Chào mừng bạn đăng nhập hệ thống, bạn không lưu thông tin", Toast.LENGTH_SHORT).show();
            }
        });

        btnExit.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setTitle("Thông báo");
            builder.setMessage("Bạn có muốn thoát không?");

            // Nếu người dùng chọn "Có" thì thoát ứng dụng
            builder.setPositiveButton("Có", (dialog, which) -> {
                finish();
            });

            // Nếu người dùng chọn "Không" thì đóng dialog
            builder.setNegativeButton("Không", (dialog, which) -> {
                dialog.dismiss();
            });

            builder.show();
        });
    }
}