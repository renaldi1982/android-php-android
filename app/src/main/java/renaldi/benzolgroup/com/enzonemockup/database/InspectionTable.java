package renaldi.benzolgroup.com.enzonemockup.database;

import android.database.sqlite.SQLiteDatabase;

public class InspectionTable extends Table {

    private static final String NAME = "inspection";
    protected String TABLE = super.TABLE + NAME;
    protected String COLUMN_ID = NAME + "_id";
    protected String COLUMN_CREATED_DATE = NAME + "_created_date";
    protected String COLUMN_INSPECTOR = NAME + "_name";
    protected String COLUMN_DATA = NAME + "_data";

    protected String CREATE_TABLE = super.CREATE_TABLE
            + COLUMN_INSPECTOR + " text not null,"
            + COLUMN_DATA + " text not null"
            + ");";

    public void onCreate(SQLiteDatabase database) {
        super.onCreate(database);
    }

    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        super.onUpgrade(database, oldVersion, newVersion);
    }
}
