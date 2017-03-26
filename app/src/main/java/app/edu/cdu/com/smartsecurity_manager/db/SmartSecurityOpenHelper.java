package app.edu.cdu.com.smartsecurity_manager.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SmartSecurityOpenHelper extends SQLiteOpenHelper{

    /**
     * Account用户账号表
     * 用于保存本手机上多个用户的账号密码
     */
    //根据管理APP框架设计说明添加相应的字符串变量。
	public static final String CREATE_ACCOUNT = "create table Account("
            +"userId integer primary key autoincrement,"
            +"username varchar(20),"
            +"password varchar(20))"
            +"sex char(1)"
            +"time varchar(20)"
            +"type char(1)"
            +"email varchar(20)"
            +"state char(1)"
            +"deviceId integer";

    public SmartSecurityOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    
    @Override
    public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_ACCOUNT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    //创建用户表
    public void createAccount(SQLiteDatabase db){
    	 db.execSQL(CREATE_ACCOUNT);
    }
}