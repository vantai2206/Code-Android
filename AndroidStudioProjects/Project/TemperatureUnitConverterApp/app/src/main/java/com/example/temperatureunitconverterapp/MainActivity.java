package com.example.temperatureunitconverterapp;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    // Khai báo giao diện
    private EditText editCelsius;
    private TextView textTitle,textResultFahrenheit,textResultKelvin;
    private Button buttonConvert;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ ID
         editCelsius=findViewById(R.id.editCelsius);
         textTitle=findViewById(R.id.textTitle);
         textResultFahrenheit=findViewById(R.id.textResultFahrenheit);
         textResultKelvin=findViewById(R.id.textResultKelvin);
         buttonConvert=findViewById(R.id.buttonConvert);

         // Xử lý sự kiện khi người dùng click vào nút " The change "
        buttonConvert.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v){
                temperature_change();
            }
        });
    }
    //Hàm tự định nghĩa để xử lý kiểm tra và thực hiện tính toán
    private void temperature_change(){
        // Lấy chuỗi dữ liệu người dùng nhập
        String input = editCelsius.getText().toString().trim();

        //Kiểm tra dữ liệu đầu vào (Validation)
        if(input.isEmpty()){
            Toast.makeText(this,"Please enter the temperature in °C you want to convert!", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            //Ép kiểu dữ liệu từ Chuỗi (String) sang Số thực (double)
            double degreesC = Double.parseDouble(input);
            // Thực hiện tính toán theo công thức khoa học
            double degreesF = degreesC * 1.8 + 32;
            double degreesK = degreesC + 273.15; // Công thức chuẩn là 273.15

            //Xử lý hiển thị chuỗi kết quả lên màn hình UI
            textResultKelvin.setText(String.format("Kelvin result: %.2f °K", degreesK));
            textResultFahrenheit.setText(String.format("Fahrenheit result: %.2f °F", degreesF));
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Please enter a valid number!", Toast.LENGTH_SHORT).show();
        }
    }
}