package app.edu.cdu.com.smartsecurity_manager.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
public class SmartSecurityDB {

    /**
     * 数据库名称，版本
     */
    private static final String DB_NAME = "SmartSecurity";
    private static final int VERSION = 1;

    private SmartSecurityDB smartSecurityDB;
    private SQLiteDatabase db;


    /**
     * 将构造函数私有化
     * @param context
     */
    private SmartSecurityDB(Context context){
        SmartSecurityOpenHelper helper = new SmartSecurityOpenHelper(context,DB_NAME,null,VERSION);
        db = helper.getWritableDatabase();
    }

    /**
     * 获取SmartSecurityDB实例
     */
    public SmartSecurityDB getInstance(Context context){
        if (smartSecurityDB==null){
            smartSecurityDB = new SmartSecurityDB(context);
        }
        return smartSecurityDB;
    }

    public long addData(String table,String nullColumnhack,Object obj){
        ContentValues contentValues = new ContentValues();
        contentValues.put("xxx",obj.toString());
        return db.insert(table, nullColumnhack, contentValues);
    }
    public int deleteData(String table,String id){
        return db.delete(table,id,null);
    }
    public Cursor queryData(String table){
        return db.query(table,null,null,null,null,null,null);
    }

}
