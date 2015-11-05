package com.bhavdip.learningpoint;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

;

/**
 * Created by Bhavdip Bhalodia on 09-10-2015.
 */
public class ListExample extends Activity implements AdapterView.OnItemClickListener {
    String values[] = {"January", "July", "June", "Ravi", "Ravinder", "Abhishek", "Abhinav", "Harkishore", "Hardev"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_example);

        ListView lv=(ListView)findViewById(R.id.listView1);
//Adapter will use to adapt string and pass to list
        ArrayAdapter<?> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, values);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        String name = (String) adapterView.getItemAtPosition(position);
        Toast.makeText(getApplicationContext(), "Happy Navratri " + name, Toast.LENGTH_SHORT).show();
    }
}