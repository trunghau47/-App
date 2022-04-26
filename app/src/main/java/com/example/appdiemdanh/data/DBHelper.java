package com.example.appdiemdanh.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.room.Database;

public class DBHelper extends SQLiteOpenHelper {


    private Context context;
    private static final String DATABASE_NAME = "AppDiemDanh.db";
    private static final int DATABASE_VERSION =1;

    private static final String TABLE_NAME = "CLASS";
    private static final String COLUMN_ID = "class_ID";
    private static final String COLUMN_ClassName = "class_Name";
    private static final String COLUMN_Subject = "class_Subject";
    private static final String COLUMN_Class = "class_Class";
    private static final String COLUMN_Room = "class_Room";
    private static final String COLUMN_StarDay = "class_StarDay";
    private static final String COLUMN_EndDay = "class_EndDay";
    private static final String COLUMN_CodeJoin = "class_CodeJoin";
    private static final String COLUMN_Status = "class_Status";
    private static final String COLUMN_idGV = "class_idGV";



    //        database.QueryData("CREATE TABLE IF NOT EXISTS Class(ClassId INTEGER PRIMARY KEY AUTOINCREMENT, " +
//                "ClassName TEXT, Subject TEXT, Class TEXT, ClassRoom TEXT, " +
//                "StartDay TEXT, EndDay TEXT, CodeJoin TEXT, Status INTEGER)");

   // public DBHelper(Context context , String name, SQLiteDatabase.CursorFactory factory, int version) {
   public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_ClassName + " TEXT," +
                COLUMN_StarDay + " TEXT," +
                COLUMN_EndDay + " TEXT," +
                COLUMN_Class + " TEXT," +
                COLUMN_Subject + " TEXT," +
                COLUMN_Room + " TEXT," +

                COLUMN_CodeJoin + " TEXT," +
                COLUMN_Status + " INTEGER,"+
                COLUMN_idGV + " TEXT);";
//        MyDB.execSQL("CREATE TABLE IF NOT EXISTS Class(ClassId INTEGER PRIMARY KEY AUTOINCREMENT, " +
//                "ClassName TEXT, Subject TEXT, Class TEXT, ClassRoom TEXT, " +
//                "StartDay TEXT, EndDay TEXT, CodeJoin TEXT, Status INTEGER)");
        MyDB.execSQL(query);


    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME);
        onCreate(MyDB);
    }
    //Thêm dữ liệu vào database từ tạo lớp
    public void addClass(String classname,String starday, String endday,String _class, String subject,  String classroom,  String codejoin, int status, String idGV)
     {
         //Khởi tạo database để ghi vào
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_ClassName, classname);
        cv.put(COLUMN_StarDay, starday);
        cv.put(COLUMN_EndDay, endday);
        cv.put(COLUMN_Subject, subject);
        cv.put(COLUMN_Class, _class);
        cv.put(COLUMN_Room, classroom);

        cv.put(COLUMN_CodeJoin, codejoin);
        cv.put(COLUMN_Status, status);
         cv.put(COLUMN_idGV, idGV);
        long result = db.insert(TABLE_NAME,null, cv);
        if(result == -1 ){
            Toast.makeText(context, "Không thể tạo lớp",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(context, "Tạo Lớp Thành Công",Toast.LENGTH_SHORT).show();
        }

    }
    // đọc dữ liệu từ database
    public Cursor readAllData(){
        String query = " SELECT * FROM "+ TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        if(db != null)
        {
            cursor = db.rawQuery(query, null);
        }
        return  cursor;
    }




//    public Boolean insertData(String username, String password) {
//        SQLiteDatabase MyDB = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//
//        contentValues.put("username", username);
//        contentValues.put("password", password);
////        contentValues.put("role", role);
//        long result = MyDB.insert("users", null, contentValues);
//        if (result == -1)
//            return false;
//        else
//            return true;
//    }
//
//
//
//    public Boolean checkusernamepassword(String username, String password) {
//        SQLiteDatabase MyDB = this.getWritableDatabase();
//        Cursor cursor = MyDB.rawQuery("Select * from users where username = ? and password = ?", new String[]{username, password});
//        if (cursor.getCount() > 0)
//            return true;
//        else
//            return false;
//    }
}
