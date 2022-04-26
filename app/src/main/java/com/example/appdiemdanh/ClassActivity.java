package com.example.appdiemdanh;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.appdiemdanh.data.ClassAdapter;
import com.example.appdiemdanh.data.DBHelper;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;

public class ClassActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    DBHelper myDB;
    ArrayList<String> class_ID, class_Name , idGV;
    ClassAdapter classAdapter;
    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        frameLayout = findViewById(R.id.frame_layout);
        //Thanh Navigation
        //Lựa chọn Home
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        return true;
                    case R.id.account:
                        startActivity(new Intent(getApplicationContext(), AccountActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.addOption:
                        startActivity(new Intent(getApplicationContext(), OptionAdd.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });
        bottomNavigationView.setBackground(null);
        //tao array cac thong tin
        myDB = new DBHelper(ClassActivity.this);
        class_ID = new ArrayList<>();
        class_Name = new ArrayList<>();
        idGV = new ArrayList<>();
        displayData();

        classAdapter = new ClassAdapter(ClassActivity.this,class_ID,class_Name,idGV);
        //frameLayout.setAdapter();



        //Vào Thông Tin Lớp Học
        Button btnClassDetails = findViewById(R.id.btnclassDetails);
        btnClassDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ClassActivity.this, SV_InfoClassActivity.class);
                startActivity(intent);
            }
        });


    }
    void displayData() {
        Cursor cursor = myDB.readAllData();
        if(cursor.getCount() == 0)
        {
            Toast.makeText(this,"Không có lớp nào",Toast.LENGTH_SHORT).show();
        }else{
            class_ID.add(cursor.getString(0));
            class_Name.add(cursor.getString(1));
            idGV.add(cursor.getString(2));
        }
    }
//    public void openBottomSheet(View view) {
//        BottomSheetFragment bottomSheetFragment = new BottomSheetFragment();
//        bottomSheetFragment.show(getSupportFragmentManager(), "");
//    }

}