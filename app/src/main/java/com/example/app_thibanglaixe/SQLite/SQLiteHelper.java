package com.example.app_thibanglaixe.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "AppThiBangLaiXe.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_DETHI = "DeThi";
    public static final String TABLE_CAUHOI = "CauHoi";

    // Các trường cơ sở dữ liệu cho bảng DeThi
    public static final String COLUMN_DETHI_ID = "id";
    public static final String COLUMN_DETHI_MA = "maDeThi";
    public static final String COLUMN_DETHI_TEN = "tenDeThi";

    // Các trường cơ sở dữ liệu cho bảng CauHoi
    public static final String COLUMN_CAUHOI_ID = "id";
    public static final String COLUMN_CAUHOI_MA_DETHI = "maDeThi";
    public static final String COLUMN_CAUHOI_NOI_DUNG = "noiDungCauHoi";

    // Câu lệnh SQL để tạo bảng DeThi
    private static final String CREATE_TABLE_DETHI = "CREATE TABLE " + TABLE_DETHI + " ("
            + COLUMN_DETHI_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_DETHI_MA + " TEXT,"
            + COLUMN_DETHI_TEN + " TEXT)";

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
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DETHI);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CAUHOI);
        onCreate(db);
    }
}
