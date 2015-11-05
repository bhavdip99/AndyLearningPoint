package com.bhavdip.learningpoint;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.TextView;


public class WelcomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        GridView gridView = (GridView) findViewById(R.id.gridView);
//        gridView.setAdapter(new WelcomeLayoutAdapter(this,20));

//        gridView.setAdapter(new WelcomeAdapter(this));

//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked);
//
//        adapter.add("Home");
//        adapter.add("Doctor");
//        adapter.add("Doctor1");
//        adapter.add("Contact");
//        adapter.add("AboutUs");
//        adapter.add("Logout");
//
//        gridView.setAdapter(adapter);

        String username = null;
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            username = bundle.getString("username");
        }

        TextView welcome = (TextView) findViewById(R.id.txt_welcome);

        welcome.setText("Welcome, " + username);

    }
}
