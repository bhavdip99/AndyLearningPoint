package com.bhavdip.learningpoint;

import android.location.Address;
import android.location.Geocoder;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

public class MapExplorer extends FragmentActivity{
	private static final String TAG = MapExplorer.class.getSimpleName();

	private GoogleMap mMap;
	private Button mSearchButton;
	private EditText mAddressEditText;
	private LatLng mLatLng;
	private MarkerOptions markerOptions;
	
	Boolean isInternetPresent = false;
	
	NetworkUtils util;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.map_explor);
		
		mAddressEditText = (EditText) findViewById(R.id.addressTextbox);
		mSearchButton = (Button)findViewById(R.id.searchButton);
		
        util = new NetworkUtils(getApplicationContext());
        
        isInternetPresent = util.isConnectingToInternet();
        if (isInternetPresent) {
//        	util.showAlertDialog(MapExplorer.this, "Internet Connection","You have internet connection", true);
    		setUpMapIfNeeded();
        } else {
            util.showAlertDialog(MapExplorer.this, "No Internet Connection","You don't have internet connection.", false);
        }


	}

	@Override
	protected void onResume() {
		super.onResume();
		if (isInternetPresent) {
//        	util.showAlertDialog(MapExplorer.this, "Internet Connection","You have internet connection", true);
    		setUpMapIfNeeded();
        } else {
            util.showAlertDialog(MapExplorer.this, "No Internet Connection","You don't have internet connection.", false);
        }
	}

	private void setUpMapIfNeeded() {
		// Do a null check to confirm that we have not already instantiated the
		// map.
		if (mMap == null) {
			// Try to obtain the map from the SupportMapFragment.
			mMap = ((SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
			// Check if we were successful in obtaining the map.
			setUpMap();
		}else{
			setUpMap_();
		}
	}

	private void setUpMap_() {
		// TODO Auto-generated method stub

		mSearchButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				String addressSearchString;
				addressSearchString = mAddressEditText.getText().toString();

				new GeocoderTask().execute(addressSearchString);

				InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
			}
		});
	}
	private class GeocoderTask extends AsyncTask<String, Void, List<Address>> {
		@Override
		protected List<Address> doInBackground(String... locationName) {
			// TODO Auto-generated method stub
		Geocoder geocoder = new Geocoder(MapExplorer.this);
		List<Address> addresses= null;
		try {
			addresses= geocoder.getFromLocationName(locationName[0], 3);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return addresses;
		}
		@Override
		protected void onPostExecute(List<Address> addresses) {
			// TODO Auto-generated method stub
			super.onPostExecute(addresses);
			if(addresses==null || addresses.size()==0){
				Toast.makeText(MapExplorer.this,getResources().getString(R.string.location_not_found),
						Toast.LENGTH_SHORT).show();
			}
			mMap.clear();

			for(int i = 0; i<addresses.size();i++){
				Address address = addresses.get(i);

				mLatLng = new LatLng(address.getLatitude(),address.getLongitude());
				String addressText = String.format("%s, %s",address.getMaxAddressLineIndex() > 0 ? address.getAddressLine(0) : "", address
						.getCountryName());
				markerOptions = new MarkerOptions();
				markerOptions.position(mLatLng);
				markerOptions.title(addressText);

				Marker marker= mMap.addMarker(markerOptions);
				marker.showInfoWindow();
				// Show the first location
				if (i == 0) {
					mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(mLatLng, 12));

					String addressSearchString = mAddressEditText.getText().toString();

					if (mLatLng != null) {
						Log.d(TAG, "Address: " + addressSearchString+ " - latitude: " + mLatLng.latitude
								+ " - longitude: " + mLatLng.longitude);
					}
				}
			}
		}
	}

	private void setUpMap() {
		markerOptions = new MarkerOptions();
		markerOptions.position(new LatLng(19.090177,72.868739));//19.0901816,72.8665504
		markerOptions.title("Mumbai Internation Airport");
		Marker marker = mMap.addMarker(markerOptions);
//		Marker marker =null;
		marker.showInfoWindow();
		mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(19.090177,72.868739), 12));
//		mMap.addMarker(new MarkerOptions().position(new LatLng(19.090177,72.868739)).title("Mumbai Internation Airport"));
	}
}
