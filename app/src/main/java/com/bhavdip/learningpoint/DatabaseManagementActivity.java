package com.bhavdip.learningpoint;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class DatabaseManagementActivity extends Activity {

    private EditText typeInput;
    private EditText qtyInput;
    private DatabaseControl dbControl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_management);

        dbControl = new DatabaseControl(this);
        typeInput = (EditText) findViewById(R.id.itemType);
        qtyInput = (EditText) findViewById(R.id.Quantity);
    }

    public void onClick(View arg) {
        String typeData = typeInput.getText().toString().toLowerCase();
        String qtyData = qtyInput.getText().toString();
        Dialog notice = new Dialog(this);
        TextView msgBody = new TextView(this);
        msgBody.setTextSize(20);
        long tempVal = 0;

        switch (arg.getId()) {
            case R.id.addItem:
                try {
                    int qtyDataAsnum = Integer.parseInt(qtyData);
                    dbControl.open();

                    if ((tempVal = dbControl.fetchIntemIdByType(typeData)) != -1) {

                        if (dbControl.updateItem(tempVal, typeData, qtyDataAsnum)) {
                            notice.setTitle("Item Updated");
                            msgBody.setText("Item already existed, therefore was updated instead");
                        } else {
                            notice.setTitle("Update Failed.!");
                            msgBody.setText("Item Already existed, update attempted built failed.!");
                        }

                    } else {
                        long rowId = 0;

                        rowId = dbControl.addItem(typeData, qtyDataAsnum);
                        notice.setTitle("Item Inserted");
                        msgBody.setText("Item Inserted at " + rowId);
                    }
                    dbControl.close();

                } catch (SQLiteException e) {
                    e.printStackTrace();
                    notice.setTitle("Insert SQL Failed.!");
                    msgBody.setText("SQL Error.!");
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    notice.setTitle("Insert number Failed.!");
                    msgBody.setText("Quantity must be an integer values.!");

                }
                notice.setContentView(msgBody);
                notice.show();
                break;

            case R.id.updateItem:
                try {
                    int qtyDataAsnum = Integer.parseInt(qtyData);
                    dbControl.open();

                    if ((tempVal = dbControl.fetchIntemIdByType(typeData)) != -1) {

                        if (dbControl.updateItem(tempVal, typeData, qtyDataAsnum)) {
                            notice.setTitle("Item Updated");
                            msgBody.setText("Item has been updated");
                        } else {
                            notice.setTitle("Update Failed.!");
                            msgBody.setText("Failed update attemp. No Record Found.!");
                        }
                    } else {
                        notice.setTitle("Update Failed.!");
                        msgBody.setText("Item Does not exist.!");
                    }
                    dbControl.close();
                } catch (SQLiteException e) {
                    e.printStackTrace();
                    notice.setTitle("Update Failed");
                    msgBody.setText("SQL error");
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    notice.setTitle("Update Failed");
                    msgBody.setText("Quantity must be an integer values..!");
                }
                notice.setContentView(msgBody);
                notice.show();
                break;
            case R.id.deleteItem:
                try {
                    dbControl.open();

                    if ((tempVal = dbControl.fetchIntemIdByType(typeData)) != -1) {

                        if (dbControl.deleteItem(tempVal)) {
                            notice.setTitle("Item Deleted.!");
                            msgBody.setText("Item has been Deleted");
                        } else {
                            notice.setTitle("Deleted Failed.!");
                            msgBody.setText("Failed delete attemp. no record found.!");
                        }
                    } else {
                        notice.setTitle("delete Failed");
                        msgBody.setText("Item Does not Exist");
                    }
                    dbControl.close();

                } catch (SQLiteException e) {
                    e.printStackTrace();
                    notice.setTitle("Delete Failed");
                    msgBody.setText("SQL Error");
                }
                notice.setContentView(msgBody);
                notice.show();

                break;
            case R.id.viewData:
                Intent i = new Intent("androidTuto.bhavdip.facebookapps.VIEW");
                startActivity(i);

            default:
        }
    }
}
