package com.example.to_dolistmanagementapp;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText edtTask;
    private Button btnAdd;
    private ListView lvTasks;

    private ArrayList<String> taskList; //Noi luu du lieu that
    private ArrayAdapter<String> adapter; // cầu nối save data and Listview

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Anh Xa ID
        edtTask = findViewById(R.id.edtTask);
        btnAdd = findViewById(R.id.btnAdd);
        lvTasks = findViewById(R.id.lvTasks);
        // Khoi tao du lieu và adapter
        taskList = new ArrayList<>();
        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1, //layout co san cua android cho moi ddong
                taskList
        );
        lvTasks.setAdapter(adapter);

        // Xu ly su kien bam nut "Add"
        btnAdd.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v){
               String task = edtTask.getText().toString().trim();
               if(TextUtils.isEmpty(task)){
                   Toast.makeText(MainActivity.this,"Vui long nhap cong viec!",Toast.LENGTH_SHORT).show();
                   return;
               }
               taskList.add(task);
               adapter.notifyDataSetChanged();
               edtTask.setText("");
           }
        });
        // 4. (Tùy chọn) Bấm giữ vào 1 dòng để xóa công việc đó
        lvTasks.setOnItemLongClickListener((parent, view, position, id) -> {
            taskList.remove(position);
            adapter.notifyDataSetChanged();
            Toast.makeText(this, "Đã xóa công việc", Toast.LENGTH_SHORT).show();
            return true;
        });
    }
}