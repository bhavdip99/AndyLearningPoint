package com.bhavdip.learningpoint;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Production extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.product_list);
		
		ListView listView1 = (ListView) findViewById(R.id.list);
        
		Product prod_data[] = new Product[]
		        {
		            new Product(1, "23-04-2013",12),
		            new Product(2, "23-04-2192",113),
		            new Product(3, "23-04-2014",14),
		            new Product(4, "23-04-2015",153),
		            new Product(5, "23-04-2016",1324),
		        };
		
		 ArrayAdapter<Product> adapter = new ArrayAdapter<Product>(this,
                 android.R.layout.simple_list_item_1, prod_data);
		 
		 listView1.setAdapter(adapter);
	}
}