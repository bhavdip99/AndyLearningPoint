package com.bhavdip.learningpoint;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

public class DatabaseControl {

    private static final String KEY_ROWID = "_id";
    private static final String KEY_ITEMTYPE = "itemType";
    private static final String KEY_QUANTITY = "quantity";

    // private static final String KEY_USERNAME="username";
    // private static final String KEY_FIRSTNAME="first_name";
    // private static final String KEY_LASTNAME="last_name";
    // private static final String KEY_FBID="fbid";
    // private static final String KEY_BIRTHDAY="birthday";
    // private static final String KEY_EMAIL="email";

    // Table name
    private static final String DB_TABLE = "inventory";
    private static final String DB_PRODUCT_TABLE = "product";

    private Context context;
    private SQLiteDatabase database;
    private DatabaseHelper dbHelper;     //Class that contains create db, table and etc.

    public DatabaseControl(Context context) {
        this.context = context;
    }

    public DatabaseControl open() throws SQLiteException {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;

    }

    public void close() {
        dbHelper.close();
    }

    public long addItem(String type, int quantity) {
        ContentValues setUpVals = createContentValues(type, quantity);

        return database.insert(DB_TABLE, null, setUpVals);
    }

    public boolean updateItem(long id, String type, int quantity) {
        ContentValues updateVals = createContentValues(type, quantity);

        return database
                .update(DB_TABLE, updateVals, KEY_ROWID + "=" + id, null) > 0;

    }

    public long fetchIntemIdByType(String type) {
        Cursor dbCursor;
        long id = 0;

        try {
            dbCursor = database.query(true, DB_TABLE,
                    new String[]{KEY_ROWID}, KEY_ITEMTYPE + "= '" + type
                            + "'", null, null, null, null, null);
            dbCursor.moveToFirst();
            id = dbCursor.getLong(dbCursor.getColumnIndex(KEY_ROWID));
        } catch (SQLiteException e) {
            id = -1;
        } catch (IndexOutOfBoundsException e) {
            id = -1;
        }

        return id;
    }

    public String fetchAllItem() {
        String allData = "";
        Cursor dbCursor;

        try {
            dbCursor = database.query(DB_TABLE, new String[]{KEY_ROWID,
                    KEY_ITEMTYPE, KEY_QUANTITY}, null, null, null, null, null);

            int iRow = dbCursor.getColumnIndex(KEY_ROWID);
            int iType = dbCursor.getColumnIndex(KEY_ITEMTYPE);
            int iQuantity = dbCursor.getColumnIndex(KEY_QUANTITY);

            for (dbCursor.moveToFirst(); !dbCursor.isAfterLast(); dbCursor
                    .moveToNext()) {
                allData = allData + " " + dbCursor.getString(iRow) + "\t "
                        + dbCursor.getString(iType) + "\t\t\t"
                        + dbCursor.getString(iQuantity) + "\n";

            }
        } catch (Exception e) {
            allData = "";
        }
        return allData;

    }

    public boolean deleteItem(long id) {

        return database.delete(DB_TABLE, KEY_ROWID + "=" + id, null) > 0;
    }

    private ContentValues createContentValues(String type, int quantity) {
        ContentValues values = new ContentValues();
        values.put(KEY_ITEMTYPE, type);
        values.put(KEY_QUANTITY, quantity);
        return values;
    }

}
