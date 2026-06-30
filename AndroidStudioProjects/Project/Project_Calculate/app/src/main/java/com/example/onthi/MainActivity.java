package com.example.onthi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText editnum1, editnum2;
    private Button buttonadd, buttonsub, buttonmul, buttondiv;
    private TextView textMark, textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Ánh xạ ID
        editnum1 = findViewById(R.id.editnum1);
        editnum2 = findViewById(R.id.editnum2);
        buttonadd = findViewById(R.id.buttonadd);
        buttonsub = findViewById(R.id.buttonsub);
        buttonmul = findViewById(R.id.buttonmul);
        buttondiv = findViewById(R.id.buttondiv);
        textMark = findViewById(R.id.textmark);
        textResult = findViewById(R.id.textResult);

        // 2. Xử lý sự kiện click cho các nút
        buttonadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tinhToan('+');
            }
        });

        buttonsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tinhToan('-');
            }
        });

        buttonmul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tinhToan('*');
            }
        });

        buttondiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tinhToan('/');
            }
        });
    }

    private void tinhToan(char phepTinh) {
        String s1 = editnum1.getText().toString();
        String s2 = editnum2.getText().toString();

        // Kiểm tra nhập liệu
        if (s1.isEmpty() || s2.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập đủ 2 số", Toast.LENGTH_SHORT).show();
            return;
        }

        double n1 = Double.parseDouble(s1);
        double n2 = Double.parseDouble(s2);
        double ketQua = 0;

        // Hiển thị dấu phép tính lên màn hình (nếu muốn)
        textMark.setText(String.valueOf(phepTinh));

        switch (phepTinh) {
            case '+': ketQua = n1 + n2; break;
            case '-': ketQua = n1 - n2; break;
            case '*': ketQua = n1 * n2; break;
            case '/':
                if (n2 == 0) {
                    Toast.makeText(this, "Không thể chia cho 0", Toast.LENGTH_SHORT).show();
                    return;
                }
                ketQua = n1 / n2;
                break;
        }

        textResult.setText("Kết quả: " + ketQua);
    }
}
