package com.bhavdip.learningpoint;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.bhavdip.learningpoint.storage.Contact;
import com.bhavdip.learningpoint.storage.DatabaseHandler;

import java.util.List;


public class AndroidSQLiteTutorialActivity extends Activity {
    /** Called when the activity is first created. */
    EditText edtName,edtNo;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_sqlite);

        edtName = (EditText)findViewById(R.id.editName);
        edtNo = (EditText)findViewById(R.id.editNo);
        Button btnInsert = (Button)findViewById(R.id.btnInsert);

        final DatabaseHandler db = new DatabaseHandler(this);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.d("Insert: ", "Inserting ..");
                db.addContact(new Contact(edtName.getText().toString().trim(), edtNo.getText().toString().trim()));
            }
        });
        
        /**
         * CRUD Operations
         * */
//        // Inserting Contacts
//        Log.d("Insert: ", "Inserting ..");
//        db.addContact(new Contact("Ravi", "9100000000"));
//        db.addContact(new Contact("Srinivas", "9199999999"));
//        db.addContact(new Contact("Tommy", "9522222222"));
//        db.addContact(new Contact("Karthik", "9533333333"));
 
        // Reading all contacts
        Log.d("Reading: ", "Reading all contacts..");
        List<Contact> contacts = db.getAllContacts();       
 
        for (Contact cn : contacts) {
            String log = "Id: "+cn.getID()+" ,Name: " + cn.getName() + " ,Phone: " + cn.getPhoneNumber();
                // Writing Contacts to log
        Log.d("Name: ", log);
        
        }
    }
}