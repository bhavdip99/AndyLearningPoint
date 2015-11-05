package com.bhavdip.learningpoint;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Bhavdip Bhalodia on 08-10-2015.
 */
public class MenuActivity extends ListActivity {
    public String[] listChapter = {"MainActivity", "AndroidLifeCycle", "IntentAction", "ListExample", "SpinnerExample",
            "AlertDialogExample","ServiceExample","CustomToastExample","CustomListExample"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<>(MenuActivity.this, android.R.layout.simple_list_item_1, listChapter));

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Class myClass = null;
        String cheese = listChapter[position];
        try {
            myClass = Class.forName("com.bhavdip.learningpoint." + cheese);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Intent myIntent = new Intent(MenuActivity.this, myClass);
        startActivity(myIntent);

    }
}
