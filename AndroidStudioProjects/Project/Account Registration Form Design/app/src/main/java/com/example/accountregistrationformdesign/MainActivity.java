package com.example.accountregistrationformdesign;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    // Khai báo phần giao diện
    private EditText editName, editEmail, editPassword;
    private RadioGroup raidoGroupGender;
    private RadioButton radioButton1, radioButton2;
    private CheckBox game, music, watchingTV;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ ID từ file XML sang Java
        editName = findViewById(R.id.editName);
        editEmail = findViewById(R.id.editEmail);
        editPassword = findViewById(R.id.editPassword);
        raidoGroupGender = findViewById(R.id.raidoGroupGender);
        radioButton1 = findViewById(R.id.radioButton1);
        radioButton2 = findViewById(R.id.radioButton2);
        game = findViewById(R.id.game);
        music = findViewById(R.id.music);
        watchingTV = findViewById(R.id.watchingTV);
        btnRegister = findViewById(R.id.btnRegister);

        // Thiết lập nút bấm Register
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register_process();
            }
        });
    }

    private void register_process() {
        // Lấy dữ liệu dạng text và xóa khoảng trắng dư thừa
        String name = editName.getText().toString().trim();
        String email = editEmail.getText().toString().trim();
        String password = editPassword.getText().toString().trim();

        // Kiểm tra lỗi bỏ trống dữ liệu (Validation)
        if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please fill in all the required information!", Toast.LENGTH_SHORT).show();
            return;
        }

        // Xử lý RadioButton (Chọn giới tính)
        String gender = "";
        if (radioButton1.isChecked()) {
            gender = "Male";
        } else if (radioButton2.isChecked()) {
            gender = "Female";
        } else {
            gender = "Not selected";
        }

        // Xử lý CheckBox (Chọn nhiều sở thích)
        StringBuilder hobbies = new StringBuilder();
        if (game.isChecked()) {
            hobbies.append("Play games, ");
        }
        if (music.isChecked()) {
            hobbies.append("Listen to music, ");
        }
        if (watchingTV.isChecked()) {
            hobbies.append("Watching TV, ");
        }

        String finalHobbies = hobbies.toString();
        // Xóa dấu phẩy và khoảng trắng dư thừa ở cuối chuỗi
        if (finalHobbies.endsWith(", ")) {
            finalHobbies = finalHobbies.substring(0, finalHobbies.length() - 2);
        }
        if (finalHobbies.isEmpty()) {
            finalHobbies = "None";
        }

        // Hiển thị kết quả tổng hợp
        String result = "Name: " + name + "\nEmail: " + email + "\nGender: " + gender + "\nHobbies: " + finalHobbies;
        Toast.makeText(this, "Registration Successful!\n" + result, Toast.LENGTH_LONG).show();
    }
}
