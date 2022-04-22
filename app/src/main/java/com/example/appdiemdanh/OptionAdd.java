package com.example.appdiemdanh;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class OptionAdd extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option_add);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        //Lựa chọn Thêm
        bottomNavigationView.setSelectedItemId(R.id.addOption);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), ClassActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.account:
                        startActivity(new Intent(getApplicationContext(), AccountActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.addOption:
                        return true;
                }
                return false;
            }
        });
        bottomNavigationView.setBackground(null);
        //Tạo lớp học
        Button btnCreateClass = findViewById(R.id.btnCreateClass);
        btnCreateClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OptionAdd.this, CreateClassActivity.class);
                startActivity(intent);
            }
        });
        //Tham gia lớp học
        Button btnJoinClass = findViewById(R.id.btnJoinClass);
        btnJoinClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OptionAdd.this, JoinClass.class);
                startActivity(intent);
            }
        });
    }
}