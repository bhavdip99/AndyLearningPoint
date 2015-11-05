package com.bhavdip.learningpoint;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;

public class Stock extends ListActivity {

	// Refresh activity
	private final Handler handler = new Handler();

	// Progress Dialog
	private ProgressDialog pDialog;

	// Creating JSON Parser object
//	JSONParser jsonParser = new JSONParser();

	ArrayList<HashMap<String, String>> inboxList;

	// products JSONArray
	JSONArray inbox = null;

	// Inbox JSON url
	private static final String INBOX_URL = "http://patelbhavdip.tk/jigs/product.php";

	// ALL JSON node names
	private static final String TAG_PRODUCT = "products";
	private static final String TAG_STOREID = "storeId";
	private static final String TAG_NAME = "productName";
	private static final String TAG_QTY = "productQty";
	private static final String TAG_PRICE = "productPrice";
	private static final String TAG_TOTAL = "productTotal";

	static final String[] FRUITS = new String[] {"Apple", "Avocado",
			"Banana", "Blueberry", "Coconut", "Durian", "Guava", "Kiwifruit",
			"Jackfruit", "Mango", "Olive", "Pear", "Sugar-apple" };
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.stock);

		// Hashmap for ListView
		inboxList = new ArrayList<HashMap<String, String>>();

		// Loading INBOX in Background Thread
		pDialog = new ProgressDialog(Stock.this);
		pDialog.setMessage("Loading Product ...");
		pDialog.setIndeterminate(false);
		pDialog.setCancelable(false);
		pDialog.show();
//		doTheAutoRefresh();
		// new LoadInbox().execute();

	}

}
