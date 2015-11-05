package com.bhavdip.learningpoint;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

;

/**
 * Created by Bhavdip Bhalodia on 09-10-2015.
 */
public class SpinnerExample extends Activity implements AdapterView.OnItemSelectedListener {
    String values[] = {"January", "July", "June", "Ravi", "Ravinder", "Abhishek", "Abhinav", "Harkishore", "Hardev"};
    TextView txt_selected;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_example);

        Spinner spinner = (Spinner) findViewById(R.id.spinner1);
        txt_selected = (TextView) findViewById(R.id.txt_selected);
        ArrayAdapter<?> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, values);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {

        Toast.makeText(getApplicationContext(),adapterView.getItemAtPosition(pos)+" Selected", Toast.LENGTH_SHORT).show();
        txt_selected.setText(adapterView.getItemAtPosition(pos).toString());
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}