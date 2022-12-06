package com.cantinatoshio.app.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.widget.Toast;

public class LoginTabela extends SQLiteOpenHelper
{

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "login.db";


    public LoginTabela(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String SQL_TABLE =
                "CREATE TABLE " + LoginConstants.LoginProperties.TABLE_NAME+ "(" +
                        LoginConstants.LoginProperties.COLUMN_STATUS + " INT NOT NULL);";

                db.execSQL(SQL_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {

    }

    //criando novos métodos de input e leitura



    public void setLogin(int status)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        if(getLoginRows())
        {
            String sql = "UPDATE " + LoginConstants.LoginProperties.TABLE_NAME +
                    " SET " + LoginConstants.LoginProperties.COLUMN_STATUS + " = "
                    + status;
            db.execSQL(sql);
        }
        else
        {
            ContentValues values = new ContentValues();
            values.put(LoginConstants.LoginProperties.COLUMN_STATUS, status);
            db.insert(LoginConstants.LoginProperties.TABLE_NAME, null, values);
        }
    }

    public Cursor getLogin()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "SELECT * FROM " + LoginConstants.LoginProperties.TABLE_NAME;
        Cursor cursor = db.rawQuery(sql, null);
        return cursor;
    }

    public boolean getLoginRows()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "SELECT * FROM " + LoginConstants.LoginProperties.TABLE_NAME;
        Cursor cursor = db.rawQuery(sql, null);
        return cursor.getCount() > 0;
    }



}
