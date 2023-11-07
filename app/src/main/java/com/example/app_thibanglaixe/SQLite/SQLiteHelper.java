package com.example.app_thibanglaixe.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.app_thibanglaixe.Model.DeThi;

import java.util.ArrayList;
import java.util.List;

public class SQLiteHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "AppThiBangLaiXe.db";
    private static final int DATABASE_VERSION = 1;
    public static final String TABLE_DETHI = "DeThi";
    public static final String TABLE_CAUHOI = "Question";

    // Các trường cơ sở dữ liệu cho bảng DeThi
    public static final String COLUMN_DETHI_ID = "id";
    public static final String COLUMN_DETHI_MA = "maDeThi";
    public static final String COLUMN_DETHI_TEN = "tenDeThi";



    // Câu lệnh SQL để tạo bảng DeThi
    private static final String CREATE_TABLE_DETHI = "CREATE TABLE " + TABLE_DETHI + " ("
            + COLUMN_DETHI_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_DETHI_MA + " TEXT,"
            + COLUMN_DETHI_TEN + " TEXT)";

    // Các trường cơ sở dữ liệu cho bảng CauHoi
    public static final String COLUMN_CAUHOI_ID = "Id";
    public static final String COLUMN_CAUHOI_MA_DETHI = "MaDeThi";
    public static final String COLUMN_CAUHOI_NOI_DUNG = "NoiDungCauHoi";
    public static final String COLUMN_OPTION1 = "Option1";
    public static final String COLUMN_OPTION2 = "Option2";
    public static final String COLUMN_OPTION3 = "Option3";
    public static final String COLUMN_OPTION4 = "Option4";

    // Câu lệnh SQL để tạo bảng CauHoi với khóa ngoại
    private static final String CREATE_TABLE_CAUHOI = "CREATE TABLE " + TABLE_CAUHOI + " ("
            + COLUMN_CAUHOI_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_CAUHOI_MA_DETHI + " TEXT,"
            + COLUMN_CAUHOI_NOI_DUNG + " TEXT,"
            + "FOREIGN KEY(" + COLUMN_CAUHOI_MA_DETHI + ") REFERENCES " + TABLE_DETHI + "(" + COLUMN_DETHI_MA + "))";
    public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_DETHI);
        db.execSQL(CREATE_TABLE_CAUHOI);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DETHI);
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CAUHOI);
        onCreate(db);
    }
    public void AddDeThi() {
        deleteAllDeThi();
        SQLiteDatabase database = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_CAUHOI_MA_DETHI, "DT1");
        values.put(COLUMN_DETHI_TEN,"Đề Thi 1");
        database.insert(TABLE_DETHI, null, values);


        values.put(COLUMN_CAUHOI_MA_DETHI, "DT2");
        values.put(COLUMN_DETHI_TEN,"Đề Thi 2");
        database.insert(TABLE_DETHI, null, values);


        values.put(COLUMN_CAUHOI_MA_DETHI, "DT3");
        values.put(COLUMN_DETHI_TEN,"Đề Thi 3");
        database.insert(TABLE_DETHI, null, values);

        values.put(COLUMN_CAUHOI_MA_DETHI, "DT4");
        values.put(COLUMN_DETHI_TEN,"Đề Thi 4");
        database.insert(TABLE_DETHI, null, values);
        database.close();
    }
    public List<DeThi> getAllDeThi()
    {
        List<DeThi> deThiList=new ArrayList<>();
        SQLiteDatabase db=this.getReadableDatabase();
        String Query="SELECT * FROM "+TABLE_DETHI;
        Cursor cursor=db.rawQuery(Query,null);
        if(cursor.moveToFirst())
        {
            do{
                deThiList.add(new DeThi(1,cursor.getString(1),cursor.getString(2)));
            }while (cursor.moveToNext());
        }
        return deThiList;
    }
    public void deleteAllDeThi() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_DETHI, null, null);
        db.close();
    }
}
