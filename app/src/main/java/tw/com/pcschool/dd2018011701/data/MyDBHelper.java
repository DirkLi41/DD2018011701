package tw.com.pcschool.dd2018011701.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Student on 2018/1/22.
 */

public class MyDBHelper extends SQLiteOpenHelper {
    final static String DB_NAME = "student.sqlite";
    final static int VERSION = 1;
    public MyDBHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE \"students\" ( `_id` INTEGER, `name` TEXT, `score` INTEGER, PRIMARY KEY(`_id`) )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
