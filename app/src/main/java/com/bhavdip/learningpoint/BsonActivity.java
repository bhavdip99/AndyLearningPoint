package com.bhavdip.learningpoint;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.Toast;

public class BsonActivity extends Activity {
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
	// Inflate the layout for this fragment

	    return inflater.inflate(R.layout.product_list_item, container, false);     
	}
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_);

		GridView gridview = (GridView) findViewById(R.id.gridview);
		gridview.setAdapter(new ImageAdapter(this));

		gridview.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
			
				switch (position) {
				case 0:
					Intent prod=new Intent(BsonActivity.this, Production.class);
	                prod.putExtra("Index", position);
	                startActivity(prod);
	                
					Toast.makeText(BsonActivity.this,
							"Production at position :", Toast.LENGTH_SHORT)
							.show();
					break;
				case 1:
					Intent stock=new Intent(BsonActivity.this, Stock.class);
					stock.putExtra("Index", position);
	                startActivity(stock);
	                
					Toast.makeText(BsonActivity.this, "stock at position :",
							Toast.LENGTH_SHORT).show();
					break;
//				case 2:
//					Intent invoice=new Intent(BsonActivity.this, InvoiceList.class);
//	                invoice.putExtra("Index", position);
//	                startActivity(invoice);
//					Toast.makeText(BsonActivity.this, "invoice at position :",
//							Toast.LENGTH_SHORT).show();
//					break;
//				case 3:
//					Intent prof=new Intent(BsonActivity.this, Profile.class);
//					prof.putExtra("Index", position);
//	                startActivity(prof);
//					Toast.makeText(BsonActivity.this, "profile at position :",
//							Toast.LENGTH_SHORT).show();
//					break;
//				case 4:
//					Intent ledger=new Intent(BsonActivity.this, Ledger.class);
//					ledger.putExtra("Index", position);
//	                startActivity(ledger);
//
//					Toast.makeText(BsonActivity.this, "ledger at position :",
//							Toast.LENGTH_SHORT).show();
//					break;
//				case 5:
//					Intent market=new Intent(BsonActivity.this, Market.class);
//					market.putExtra("Index", position);
//	                startActivity(market);
//					Toast.makeText(BsonActivity.this, "market at position :",
//							Toast.LENGTH_SHORT).show();
//					break;
//				case 6:
//					Intent history=new Intent(BsonActivity.this, History.class);
//					history.putExtra("Index", position);
//	                startActivity(history);
//					Toast.makeText(BsonActivity.this, "history at position :",
//							Toast.LENGTH_SHORT).show();
//					break;
//				case 7:
//					Intent setting=new Intent(BsonActivity.this, Setting.class);
//					setting.putExtra("Index", position);
//	                startActivity(setting);
//					Toast.makeText(BsonActivity.this, "setting at position :",
//							Toast.LENGTH_SHORT).show();
//					break;
//				case 8:
//					Intent logout=new Intent(BsonActivity.this, Login.class);
//					logout.putExtra("Index", position);
//	                startActivity(logout);
//					Toast.makeText(BsonActivity.this, "logout at position :",
//							Toast.LENGTH_SHORT).show();
//					break;
				}
			}
		});
	}
}
