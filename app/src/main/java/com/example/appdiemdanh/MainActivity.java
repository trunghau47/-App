package com.example.appdiemdanh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;

import com.example.appdiemdanh.data.DBHelper;


public class MainActivity extends AppCompatActivity {

    DBHelper database;
    int SPLASH_TIME_OUT = 1000;//set thời gian chờ 1 giây
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //tạo database khoá học
//       database = new DBHelper(this, "dbDiemDanh.sqlite", null ,1);
//
//        //tạo bảng tài khoản
//        //database.QueryData("CREATE TABLE IF NOT EXISTS TaiKhoan(username VARCHAR(50) PRIMARY KEY , password VARCHAR(50),QUYEN INT )");
//        // thêm data vào bảng tài khoản
//        database.QueryData("INSERT INTO TaiKhoan VALUES('admin','admin', '0' )");
//        database.QueryData("INSERT INTO TaiKhoan VALUES('user','user', '1' )");
//
//        //tạo bảng lớp học
//        //database.QueryData("CREATE TABLE IF NOT EXISTS LopHoc(MALOP INTEGER PRIMARY KEY AUTOINCREMENT, TENMONHOC TEXT , NGAYBD TEXT, NGAYKT TEXT,TENLOP TEXT,PHONG TEXT, TRANGTHAI TEXT,MATHAMGIALOP TEXT)");
//
//        //add data vào bảng lớp học
//        database.QueryData("INSERT INTO LopHoc VALUES(null,'Test Tên Môn Học','1-1-2001','2-2-2022','Test Tên Lớp Học','Test Tên Phòng','Test Trạng thái', 'Test Mã tham gia lop' )");
//        database.QueryData("INSERT INTO LopHoc VALUES(null,'Test Tên Môn Học1','1-1-2001','2-2-2022','Test Tên Lớp Học','Test Tên Phòng','Test Trạng thái', 'Test Mã tham gia lop' )");
//        database.QueryData("INSERT INTO LopHoc VALUES(null,'Test Tên Môn Học2','1-1-2001','2-2-2022','Test Tên Lớp Học','Test Tên Phòng','Test Trạng thái', 'Test Mã tham gia lop' )");

        //tạo bảng chi tiết lớp học
        //database.QueryData("CREATE TABLE IF NOT EXISTS CT_LOPHOC()");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_TIME_OUT);
    }
}