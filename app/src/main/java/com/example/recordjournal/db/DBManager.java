package com.example.recordjournal.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * @author hello word
 * @desc 作用描述
 * @date 2021/9/6
 */
public class DBManager {
    private static SQLiteDatabase db;
    /*初始化数据库对象*/
    public static void initDB(Context context){
        DBOpenHelper helper = new DBOpenHelper(context);//得到帮助类对象
        db=helper.getWritableDatabase();//得到数据库对象
    }
}
