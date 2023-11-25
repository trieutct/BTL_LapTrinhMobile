package com.example.app_thibanglaixe.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.app_thibanglaixe.Model.DeThi;
import com.example.app_thibanglaixe.Model.Question;

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
    public static final String COLUMN_IMAGE = "Image";
    public static final String COLUMN_UserSelectedAnswer = "UserSelectedAnswer";
    public static final String COLUMN_Answer = "Answer";

    // Câu lệnh SQL để tạo bảng CauHoi với khóa ngoại
//    private static final String CREATE_TABLE_CAUHOI = "CREATE TABLE " + TABLE_CAUHOI + " ("
//            + COLUMN_CAUHOI_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
//            + COLUMN_CAUHOI_MA_DETHI + " TEXT,"
//            + COLUMN_CAUHOI_NOI_DUNG + " TEXT,"
//            + "FOREIGN KEY(" + COLUMN_CAUHOI_MA_DETHI + ") REFERENCES " + TABLE_DETHI + "(" + COLUMN_DETHI_MA + "))";
    private static final String CREATE_TABLE_CAUHOI = "CREATE TABLE " + TABLE_CAUHOI + " ("
            + COLUMN_CAUHOI_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_CAUHOI_MA_DETHI + " TEXT,"
            + COLUMN_CAUHOI_NOI_DUNG + " TEXT,"
            + COLUMN_OPTION1 + " TEXT,"
            + COLUMN_OPTION2 + " TEXT,"
            + COLUMN_OPTION3 + " TEXT,"
            + COLUMN_OPTION4 + " TEXT,"
            + COLUMN_IMAGE + " TEXT,"
            + COLUMN_UserSelectedAnswer + " TEXT,"
            + COLUMN_Answer + " TEXT)";
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
    public void AddQuestion()
    {
        deleteQuestion();
        AddCauHoiDeThi1();
        AddCauHoiDeThi2();
        AddCauHoiDeThi3();
        AddCauHoiDeThi4();
    }
    private void AddCauhoi(String madethi,String cauhoi,String op1,String op2,String op3,String op4,String userslected,String answer,String anh)
    {
        SQLiteDatabase database = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_CAUHOI_MA_DETHI, madethi);
        values.put(COLUMN_CAUHOI_NOI_DUNG,cauhoi);
        values.put(COLUMN_OPTION1,op1);
        values.put(COLUMN_OPTION2,op2);
        values.put(COLUMN_OPTION3,op3);
        values.put(COLUMN_OPTION4,op4);
        values.put(COLUMN_UserSelectedAnswer,userslected);
        values.put(COLUMN_Answer,answer);
        values.put(COLUMN_IMAGE,anh);
        database.insert(TABLE_CAUHOI, null, values);
    }
    private void AddCauHoiDeThi1()
    {
        AddCauhoi("DT1","Phần của đường bộ được sử dụng cho các phương tiện giao thông qua lại là gì?","Phần mặt đường và lề đường.","Phần đường xe chạy.","Phần đường xe cơ giới.","","s","Phần đường xe chạy.","");
        AddCauhoi("DT1","“Làn đường” là gì?","Là một phần của phần đường xe chạy được chia theo chiều dọc của đường, sử dụng cho xe chạy.","Là một phần của phần đường xe chạy được chia theo chiều dọc của đường, có bề rộng đủ cho xe chạy an toàn.","Là đường cho xe ô tô chạy, dừng, đỗ an toàn.","","","Là một phần của phần đường xe chạy được chia theo chiều dọc của đường, có bề rộng đủ cho xe chạy an toàn.","");
        AddCauhoi("DT1","Trong các khái niệm dưới đây, “dải phân cách” được hiểu như thế nào là đúng?","Là bộ phận của đường để ngăn cách không cho các loại xe vào những nơi không được phép.","Là bộ phận của đường để phân tách phần đường xe chạy và hành lang an toàn giao thông.","Là bộ phận của đường để phân chia mặt đường thành hai chiều xe chạy riêng biệt hoặc để phân chia phần đường của xe cơ giới và xe thô sơ.","","","Là bộ phận của đường để phân chia mặt đường thành hai chiều xe chạy riêng biệt hoặc để phân chia phần đường của xe cơ giới và xe thô sơ.","");
        AddCauhoi("DT1","“Dải phân cách” trên đường bộ gồm những loại nào?","Dải phân cách gồm loại cố định và loại di động.","Dải phân cách gồm tường chống ồn, hộ lan cứng và hộ lan mềm.","Dải phân cách gồm giá long môn và biển báo hiệu đường bộ.","","","Dải phân cách gồm loại cố định và loại di động.","");
        AddCauhoi("DT1","Biển báo hiệu có dạng hình tròn, viền đỏ, nền trắng, trên nền có hình vẽ hoặc chữ số, chữ viết màu đen là loại biển gì dưới đây?","Biển báo nguy hiểm.","Biển báo cấm.","Biển báo hiệu lệnh.","Biển báo chỉ dẫn.","","Biển báo cấm.","bien_1");
        AddCauhoi("DT1","Người lái xe được hiểu như thế nào trong các khái niệm dưới đây?","Là người điều khiển xe cơ giới.","Là người điều khiển xe thô sơ.","Là người điều khiển xe có súc vật kéo.","","","Là người điều khiển xe cơ giới.","");
        AddCauhoi("DT1","Đường mà trên đó phương tiện tham gia giao thông được các phương tiện giao thông đến từ các hướng khác nhường đường khi qua nơi đường giao nhau, được cắm biển báo hiệu đường ưu tiên là loại đường gì?","Đường không ưu tiên","Đường tỉnh lộ.","Đường quốc lộ.","Đường ưu tiên.","","Đường ưu tiên.","");
        AddCauhoi("DT1","“Phương tiện tham gia giao thông đường bộ” gồm những loại nào?","Phương tiện giao thông cơ giới đường bộ.","Phương tiện giao thông thô sơ đường bộ và xe máy chuyên dùng.","Cả ý 1 và ý 2.","","","Cả ý 1 và ý 2.","");
    }
    private void AddCauHoiDeThi2()
    {
        AddCauhoi("DT2","Phần của đường bộ được sử dụng cho các phương tiện giao thông qua lại là gì?","Phần mặt đường và lề đường.","Phần đường xe chạy.","Phần đường xe cơ giới.","","s","Phần đường xe chạy.","");
        AddCauhoi("DT2","“Làn đường” là gì?","Là một phần của phần đường xe chạy được chia theo chiều dọc của đường, sử dụng cho xe chạy.","Là một phần của phần đường xe chạy được chia theo chiều dọc của đường, có bề rộng đủ cho xe chạy an toàn.","Là đường cho xe ô tô chạy, dừng, đỗ an toàn.","","","Là một phần của phần đường xe chạy được chia theo chiều dọc của đường, có bề rộng đủ cho xe chạy an toàn.","");
        AddCauhoi("DT2","Trong các khái niệm dưới đây, “dải phân cách” được hiểu như thế nào là đúng?","Là bộ phận của đường để ngăn cách không cho các loại xe vào những nơi không được phép.","Là bộ phận của đường để phân tách phần đường xe chạy và hành lang an toàn giao thông.","Là bộ phận của đường để phân chia mặt đường thành hai chiều xe chạy riêng biệt hoặc để phân chia phần đường của xe cơ giới và xe thô sơ.","","","Là bộ phận của đường để phân chia mặt đường thành hai chiều xe chạy riêng biệt hoặc để phân chia phần đường của xe cơ giới và xe thô sơ.","");
        AddCauhoi("DT2","“Dải phân cách” trên đường bộ gồm những loại nào?","Dải phân cách gồm loại cố định và loại di động.","Dải phân cách gồm tường chống ồn, hộ lan cứng và hộ lan mềm.","Dải phân cách gồm giá long môn và biển báo hiệu đường bộ.","","","Dải phân cách gồm loại cố định và loại di động.","");
        AddCauhoi("DT2","Biển báo hiệu có dạng hình tròn, viền đỏ, nền trắng, trên nền có hình vẽ hoặc chữ số, chữ viết màu đen là loại biển gì dưới đây?","Biển báo nguy hiểm.","Biển báo cấm.","Biển báo hiệu lệnh.","Biển báo chỉ dẫn.","","Biển báo cấm.","bien_1");
        AddCauhoi("DT2","Người lái xe được hiểu như thế nào trong các khái niệm dưới đây?","Là người điều khiển xe cơ giới.","Là người điều khiển xe thô sơ.","Là người điều khiển xe có súc vật kéo.","","","Là người điều khiển xe cơ giới.","");
        AddCauhoi("DT2","Đường mà trên đó phương tiện tham gia giao thông được các phương tiện giao thông đến từ các hướng khác nhường đường khi qua nơi đường giao nhau, được cắm biển báo hiệu đường ưu tiên là loại đường gì?","Đường không ưu tiên","Đường tỉnh lộ.","Đường quốc lộ.","Đường ưu tiên.","","Đường ưu tiên.","");
        AddCauhoi("DT2","“Phương tiện tham gia giao thông đường bộ” gồm những loại nào?","Phương tiện giao thông cơ giới đường bộ.","Phương tiện giao thông thô sơ đường bộ và xe máy chuyên dùng.","Cả ý 1 và ý 2.","","","Cả ý 1 và ý 2.","");
    }
    private void AddCauHoiDeThi3()
    {
        AddCauhoi("DT3","Phần của đường bộ được sử dụng cho các phương tiện giao thông qua lại là gì?","Phần mặt đường và lề đường.","Phần đường xe chạy.","Phần đường xe cơ giới.","","s","Phần đường xe chạy.","");
        AddCauhoi("DT3","“Làn đường” là gì?","Là một phần của phần đường xe chạy được chia theo chiều dọc của đường, sử dụng cho xe chạy.","Là một phần của phần đường xe chạy được chia theo chiều dọc của đường, có bề rộng đủ cho xe chạy an toàn.","Là đường cho xe ô tô chạy, dừng, đỗ an toàn.","","","Là một phần của phần đường xe chạy được chia theo chiều dọc của đường, có bề rộng đủ cho xe chạy an toàn.","");
        AddCauhoi("DT3","Trong các khái niệm dưới đây, “dải phân cách” được hiểu như thế nào là đúng?","Là bộ phận của đường để ngăn cách không cho các loại xe vào những nơi không được phép.","Là bộ phận của đường để phân tách phần đường xe chạy và hành lang an toàn giao thông.","Là bộ phận của đường để phân chia mặt đường thành hai chiều xe chạy riêng biệt hoặc để phân chia phần đường của xe cơ giới và xe thô sơ.","","","Là bộ phận của đường để phân chia mặt đường thành hai chiều xe chạy riêng biệt hoặc để phân chia phần đường của xe cơ giới và xe thô sơ.","");
        AddCauhoi("DT3","“Dải phân cách” trên đường bộ gồm những loại nào?","Dải phân cách gồm loại cố định và loại di động.","Dải phân cách gồm tường chống ồn, hộ lan cứng và hộ lan mềm.","Dải phân cách gồm giá long môn và biển báo hiệu đường bộ.","","","Dải phân cách gồm loại cố định và loại di động.","");
        AddCauhoi("DT3","Biển báo hiệu có dạng hình tròn, viền đỏ, nền trắng, trên nền có hình vẽ hoặc chữ số, chữ viết màu đen là loại biển gì dưới đây?","Biển báo nguy hiểm.","Biển báo cấm.","Biển báo hiệu lệnh.","Biển báo chỉ dẫn.","","Biển báo cấm.","bien_1");
        AddCauhoi("DT3","Người lái xe được hiểu như thế nào trong các khái niệm dưới đây?","Là người điều khiển xe cơ giới.","Là người điều khiển xe thô sơ.","Là người điều khiển xe có súc vật kéo.","","","Là người điều khiển xe cơ giới.","");
        AddCauhoi("DT3","Đường mà trên đó phương tiện tham gia giao thông được các phương tiện giao thông đến từ các hướng khác nhường đường khi qua nơi đường giao nhau, được cắm biển báo hiệu đường ưu tiên là loại đường gì?","Đường không ưu tiên","Đường tỉnh lộ.","Đường quốc lộ.","Đường ưu tiên.","","Đường ưu tiên.","");
        AddCauhoi("DT3","“Phương tiện tham gia giao thông đường bộ” gồm những loại nào?","Phương tiện giao thông cơ giới đường bộ.","Phương tiện giao thông thô sơ đường bộ và xe máy chuyên dùng.","Cả ý 1 và ý 2.","","","Cả ý 1 và ý 2.","");
    }
    private void AddCauHoiDeThi4()
    {
        AddCauhoi("DT4","Phần của đường bộ được sử dụng cho các phương tiện giao thông qua lại là gì?","Phần mặt đường và lề đường.","Phần đường xe chạy.","Phần đường xe cơ giới.","","s","Phần đường xe chạy.","");
        AddCauhoi("DT4","“Làn đường” là gì?","Là một phần của phần đường xe chạy được chia theo chiều dọc của đường, sử dụng cho xe chạy.","Là một phần của phần đường xe chạy được chia theo chiều dọc của đường, có bề rộng đủ cho xe chạy an toàn.","Là đường cho xe ô tô chạy, dừng, đỗ an toàn.","","","Là một phần của phần đường xe chạy được chia theo chiều dọc của đường, có bề rộng đủ cho xe chạy an toàn.","");
        AddCauhoi("DT4","Trong các khái niệm dưới đây, “dải phân cách” được hiểu như thế nào là đúng?","Là bộ phận của đường để ngăn cách không cho các loại xe vào những nơi không được phép.","Là bộ phận của đường để phân tách phần đường xe chạy và hành lang an toàn giao thông.","Là bộ phận của đường để phân chia mặt đường thành hai chiều xe chạy riêng biệt hoặc để phân chia phần đường của xe cơ giới và xe thô sơ.","","","Là bộ phận của đường để phân chia mặt đường thành hai chiều xe chạy riêng biệt hoặc để phân chia phần đường của xe cơ giới và xe thô sơ.","");
        AddCauhoi("DT4","“Dải phân cách” trên đường bộ gồm những loại nào?","Dải phân cách gồm loại cố định và loại di động.","Dải phân cách gồm tường chống ồn, hộ lan cứng và hộ lan mềm.","Dải phân cách gồm giá long môn và biển báo hiệu đường bộ.","","","Dải phân cách gồm loại cố định và loại di động.","");
        AddCauhoi("DT4","Biển báo hiệu có dạng hình tròn, viền đỏ, nền trắng, trên nền có hình vẽ hoặc chữ số, chữ viết màu đen là loại biển gì dưới đây?","Biển báo nguy hiểm.","Biển báo cấm.","Biển báo hiệu lệnh.","Biển báo chỉ dẫn.","","Biển báo cấm.","bien_1");
        AddCauhoi("DT4","Người lái xe được hiểu như thế nào trong các khái niệm dưới đây?","Là người điều khiển xe cơ giới.","Là người điều khiển xe thô sơ.","Là người điều khiển xe có súc vật kéo.","","","Là người điều khiển xe cơ giới.","");
        AddCauhoi("DT4","Đường mà trên đó phương tiện tham gia giao thông được các phương tiện giao thông đến từ các hướng khác nhường đường khi qua nơi đường giao nhau, được cắm biển báo hiệu đường ưu tiên là loại đường gì?","Đường không ưu tiên","Đường tỉnh lộ.","Đường quốc lộ.","Đường ưu tiên.","","Đường ưu tiên.","");
        AddCauhoi("DT4","“Phương tiện tham gia giao thông đường bộ” gồm những loại nào?","Phương tiện giao thông cơ giới đường bộ.","Phương tiện giao thông thô sơ đường bộ và xe máy chuyên dùng.","Cả ý 1 và ý 2.","","","Cả ý 1 và ý 2.","");
    }
    public List<Question> getAllQuestionByMaDeThi(String MaDeThi) {
        List<Question> questionList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        // Thay đổi Query để lấy câu hỏi theo mã đề thi
        String Query = "SELECT * FROM " + TABLE_CAUHOI + " WHERE " + COLUMN_CAUHOI_MA_DETHI + " = ?";
        Cursor cursor = db.rawQuery(Query, new String[]{MaDeThi});
        if (cursor.moveToFirst()) {
            do {
//                Log.d("0",cursor.getString(0));
//                Log.d("1",cursor.getString(1));
//                Log.d("2",cursor.getString(2));
//                Log.d("3",cursor.getString(3));
//                Log.d("4",cursor.getString(4));
//                Log.d("5",cursor.getString(5));
//                Log.d("6",cursor.getString(6));
//                Log.d("7",cursor.getString(7));
//                Log.d("8",cursor.getString(8));
//                Log.d("9",cursor.getString(9));
                questionList.add(new Question(
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5),
                        cursor.getString(6),
                        cursor.getString(8),
                        cursor.getString(9),
                        cursor.getString(7)
                ));
            } while (cursor.moveToNext());
        }
        cursor.close(); // Đóng con trỏ khi đã sử dụng xong
        return questionList;
    }
    public void deleteQuestion()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CAUHOI, null, null);
        db.close();
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
