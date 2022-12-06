package com.cantinatoshio.app.Database;

import android.net.Uri;
import android.provider.BaseColumns;

public class LoginConstants
{
    public LoginConstants(){}

    public static final String CONTENT_AUTHORITY = "com.cantinatoshio.app";
    public static final Uri BASE_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    public static final String PATH = "Login";

    public static abstract class LoginProperties implements BaseColumns{

        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_URI, PATH);
        public static final String TABLE_NAME = "Login";
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_STATUS = "IsLogged";


    }


}
