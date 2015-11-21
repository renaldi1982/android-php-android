package renaldi.benzolgroup.com.enzonemockup.database;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class Table {

    protected String TABLE = "enfield_";
    protected String COLUMN_ID = "_id";
    protected String COLUMN_CREATED_DATE = "_created_date";

    protected String CREATE_TABLE = "create table "
            + TABLE
            + "("
            + COLUMN_ID + " integer primary key autoincrement,"
            + COLUMN_CREATED_DATE + " timestamp not null,";

    protected void onCreate(SQLiteDatabase database) {
        database.execSQL(CREATE_TABLE);
    }

    protected void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        Log.w(this.getClass().getName(), "Upgrading database from version: " + oldVersion
                + " to version: " + newVersion + " all data will be destroyed");
        database.execSQL("DROP TABLE IF EXISTS " + TABLE);
        onCreate(database);
    }


}
