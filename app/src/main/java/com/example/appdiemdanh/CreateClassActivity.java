package com.example.appdiemdanh;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;



import com.example.appdiemdanh.data.DBHelper;

import java.util.Calendar;
import java.util.Random;

public class CreateClassActivity extends AppCompatActivity {
    EditText editTextBD,editTextKT, editTextTenLop, editTextLop, editTextMonHoc, editTextPhong;
    Button btn_TaoLopHoc;
    //EditText editTextKT;
    Button btn_NgayBD;
    Button btn_NgayKT;
    DatePickerDialog.OnDateSetListener setListener;
    String CodeJionClass = code();
    int Status = 1;
    String idGV = "NTH260101";
    private static final String random_characterss = "0123456789QWERTYUIOPASDFGHJKLZXCVBNM";
//    TextView txtCodeClass;
    private String code() {
        String code;
        final Random random = new Random();
        final StringBuilder sb = new StringBuilder(6);
        for (int i = 0; i < 6; i++)
            sb.append(random_characterss.charAt(random.nextInt(random_characterss.length())));
        code = String.valueOf(sb);
        return code;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_class);
        editTextBD = findViewById(R.id.NgayBatDau);
        editTextKT = findViewById(R.id.NgayKetThuc);
        btn_NgayBD = findViewById(R.id.btn_ngayBD);
        btn_NgayKT = findViewById(R.id.btn_ngayKT);
        btn_TaoLopHoc = findViewById(R.id.btn_TaoLopHoc);
        editTextTenLop = findViewById(R.id.TenLop);
        editTextLop = findViewById(R.id.Lop);
        editTextMonHoc = findViewById(R.id.MonHoc);
        editTextPhong = findViewById(R.id.Phong);


        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(calendar.YEAR);
        final int month = calendar.get(calendar.MONTH);
        final int day = calendar.get(calendar.DAY_OF_MONTH);

        btn_NgayBD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        CreateClassActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        month = month + 1;
                        String date = day + "/" + month + "/" + year;
                        editTextBD.setText(date);
                    }
                }, year, month, day);
                datePickerDialog.show();

            }
        });
        btn_NgayKT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        CreateClassActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        month = month + 1;
                        String date = day + "/" + month + "/" + year;
                        editTextKT.setText(date);
                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });

        btn_TaoLopHoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper myDB = new DBHelper(CreateClassActivity.this);
                myDB.addClass(editTextTenLop.getText().toString().trim(),
                        editTextBD.getText().toString().trim(),
                        editTextKT.getText().toString().trim(),
                        editTextLop.getText().toString().trim(),
                        editTextMonHoc.getText().toString().trim(),
                        editTextPhong.getText().toString().trim(),
//                        editTextPhong.getText().toString().trim(),
//                        Integer.valueOf(editTextPhong.getText().toString().trim())
                        CodeJionClass,
                        Status,
                        idGV
                        );
            }

        });

//        Button btnTaoLop = findViewById(R.id.btnTaoLop);
//        btnTaoLop.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                final Random random = new Random();
//                final StringBuilder sb = new StringBuilder(6);
//                for (int i = 0; i < 6; i++)
//                    sb.append(random_characterss.charAt(random.nextInt(random_characterss.length())));
//                txtCodeClass.setText(String.valueOf(sb));
//            }
//        });
    }
}