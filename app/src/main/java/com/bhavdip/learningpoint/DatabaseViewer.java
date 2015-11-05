package com.bhavdip.learningpoint;

import android.app.Activity;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.widget.TextView;

public class DatabaseViewer extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_database_management);

		TextView content = (TextView) findViewById(R.id.dataOutput);

		DatabaseControl control = new DatabaseControl(this);

		String result = "_id\t ItemType\t\tQuantity \n";

		try {
			control.open();
			result = result + "" + control.fetchAllItem();
			control.close();
		} catch (SQLiteException e) {
			e.printStackTrace();
		}

		content.setText(result);
		// set the text of the database table output
	}
}
