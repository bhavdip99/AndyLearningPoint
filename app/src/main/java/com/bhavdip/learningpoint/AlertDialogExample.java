package com.bhavdip.learningpoint;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Bhavdip Bhalodia on 09-10-2015.
 */
public class AlertDialogExample extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void close(View v) {
        onCreateDialog(10);
    }

    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case 10:
                Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Activity will close!!!");
                builder.setTitle("Warning...");
                builder.setIcon(R.mipmap.ic_launcher);
                //button
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "Nothing happened", Toast.LENGTH_LONG).show();

                    }
                });

                //button
                builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();

                    }
                });
                //button
                builder.setNeutralButton("Thinking", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "i have to think", Toast.LENGTH_LONG).show();

                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();

        }
        return super.onCreateDialog(id);

    }

}