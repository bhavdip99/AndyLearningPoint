package com.bhavdip.learningpoint;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

	private static final String DB_NAME = "MyDB.db";
	private static final int DB_VERSION = 1;

	private static final String DB_CREATE = "CREATE TABLE inventory (_id integer primary key autoincrement,"
			+ " itemType text NOT NULL," + " quantity integer NOT NULL"+ " price integer NOT NULL);";

	public DatabaseHelper(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(DB_CREATE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS inventory");
		onCreate(db);
	}

}
