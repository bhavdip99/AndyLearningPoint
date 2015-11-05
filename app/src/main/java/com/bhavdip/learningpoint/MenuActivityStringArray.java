package com.bhavdip.learningpoint;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Bhavdip Bhalodia on 08-10-2015.
 */
public class MenuActivityStringArray extends ListActivity {
//    public String[] listChapter = {"MainActivity", "AndroidLifeCycle", "IntentAction", "ListExample", "SpinnerExample",
//            "AlertDialogExample","ServiceExample","CustomToastExample","AlertDialogExample"};
    public String[] listChapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listChapter = getResources().getStringArray(R.array.chapter_list);
        setListAdapter(new ArrayAdapter<String>(MenuActivityStringArray.this, android.R.layout.simple_list_item_1, listChapter));

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        String cheese = listChapter[position];
        Class myClass = getClassDetails(cheese);
        Intent myIntent = new Intent(MenuActivityStringArray.this, myClass);
        startActivity(myIntent);

    }

    private Class getClassDetails(String cheese) {
        Class myClass = null;
        Log.v("Service", getBaseContext().toString());
        try {
            myClass = Class.forName("com.bhavdip.learningpoint." + cheese);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return myClass;
    }
}
