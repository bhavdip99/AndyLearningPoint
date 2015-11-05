package com.bhavdip.learningpoint;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity implements View.OnClickListener {

    public static final String TAG = "MainActivity";
    EditText edtUsername, edtPassword;
    Button btnReset, btnSubmit;
    TextView txtRegistration,txtList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtRegistration = (TextView) findViewById(R.id.txt_registration);
        txtList = (TextView) findViewById(R.id.txt_list);

        edtUsername = (EditText) findViewById(R.id.edt_username);
        edtPassword = (EditText) findViewById(R.id.edt_password);

        btnReset = (Button) findViewById(R.id.btn_reset);
        btnSubmit = (Button) findViewById(R.id.btn_submit);

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtUsername.setText("");
                edtPassword.setText("");

                Toast.makeText(MainActivity.this, "Reset Clicked!!", Toast.LENGTH_SHORT).show();
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Submit clicked");
                String username = edtUsername.getText().toString();// bhavdip
                String password = edtPassword.getText().toString();// bhavdip123
                Toast.makeText(MainActivity.this, "Submit Clicked!!\n" + username, Toast.LENGTH_SHORT).show();

                if (!username.isEmpty()) {
                    if (!password.isEmpty()) {
                        if (username.equals("123") && password.equals("123")) {
                            Intent in = new Intent(MainActivity.this, WelcomeActivity.class);

                            /*Start passing values*/

                            in.putExtra("username",username);
                            //otherwise
//                            Bundle bundle = new Bundle();
//                            bundle.putString("username",username);

                            /*End passing values*/
//                            in.set
                            startActivity(in);
                        } else {
                            Toast.makeText(MainActivity.this, "PLease enter valid User name and password", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        edtPassword.setError("PLease Enter password");
                    }
                } else {
                    edtUsername.setError("PLease Enter user name");
                }
            }
        });


//        txtRegistration.setOnClickListener(this);
//        txtList.setOnClickListener(this);
    }
    public void imageClick(View v){
        Toast.makeText(MainActivity.this, "Clicked Image Button", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            /*case R.id.btn_reset:

                break;*/
            case R.id.txt_list:

//                startActivity(new Intent(MainActivity.this,ListViewActivity.class));
                break;
            case R.id.txt_registration:
//                startActivity(new Intent(MainActivity.this,RegistrationActivity.class));
//                this.finish();
                break;
            default:

        }
    }
    /*@Override
    public void onClick(View v) {

    }*/

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}
