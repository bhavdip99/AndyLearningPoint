package com.bhavdip.learningpoint;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkUtils {
	private Context _context;

	public NetworkUtils(Context context) {
		super();
		this._context = context;
	}

	public boolean isConnectingToInternet() {

		ConnectivityManager connectivity = (ConnectivityManager) _context.getSystemService(Context.CONNECTIVITY_SERVICE);
		if (connectivity != null) {
			NetworkInfo[] info = connectivity.getAllNetworkInfo();
			if (info != null)
				for (int i = 0; i < info.length; i++)
					if (info[i].getState() == NetworkInfo.State.CONNECTED) {
						return true;
					}
		}
		return false;
	}
	@SuppressWarnings("deprecation")
	public void showAlertDialog(final Context context, String title, String message, Boolean status) {

        AlertDialog alertDialog = new AlertDialog.Builder(context).create();
 
        // Setting Dialog
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        alertDialog.setIcon((status) ? R.drawable.success : R.drawable.fail);
 
        // Setting OK Button
        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            	Intent intent = new Intent(context,MapImage.class);
            	context.startActivity(intent);
            }
        });
        // Showing Alert Message
        alertDialog.show();
    }
}
