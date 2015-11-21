package renaldi.benzolgroup.com.enzonemockup;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class DBController  extends SQLiteOpenHelper {
    private static final String TAG = "EnzoneMockup: " + DBController.class.getSimpleName();
    private static final int VERSION = 12;
    private static SQLiteDatabase db;
    public DBController(Context applicationcontext) {
        super(applicationcontext, "users.db", null, VERSION);
    }
    //Creates Table
    @Override
    public void onCreate(SQLiteDatabase database) {
        Log.d(TAG,"DBController onCreate()");
        String query;
        query = "CREATE TABLE users ( id INTEGER, name TEXT)";
        database.execSQL(query);
        Log.d(TAG, "Database was created, on create finished");
    }
    @Override
    public void onUpgrade(SQLiteDatabase database, int version_old, int current_version) {
        String query;
        query = "DROP TABLE IF EXISTS users";
        database.execSQL(query);
        Log.d(TAG, "Database was deleted before creating a new one. old: " + version_old + ", new: " + current_version);
        onCreate(database);
    }

    /**
     * Inserts User into SQLite DB
     * @param queryValues
     */
    public void insertUser(HashMap<String, String> queryValues) {
        Log.d(TAG,"insert user to sqlite");
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id", queryValues.get("id"));
        values.put("name", queryValues.get("name"));
        database.insert("users", null, values);
        database.close();
    }

    /**
     * Get list of Users from SQLite DB as Array List
     * @return
     */
    public ArrayList<HashMap<String, String>> getAllUsers() {
        Log.d(TAG,"get all users from sqlite");
        ArrayList<HashMap<String, String>> usersList;
        usersList = new ArrayList<HashMap<String, String>>();
        String selectQuery = "SELECT  * FROM users";
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> map = new HashMap<String, String>();
                /*Log.d(TAG, cursor.getString(0));*/
                /*Log.d(TAG,"id: " + cursor.getString(0));
                Log.d(TAG,"name: " + cursor.getString(1));*/
                map.put("userId", cursor.getString(0));
                map.put("userName", cursor.getString(1));
                usersList.add(map);
            } while (cursor.moveToNext());
        }
        database.close();
        return usersList;
    }

}