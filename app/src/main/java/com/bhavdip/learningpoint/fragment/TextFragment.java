package com.bhavdip.learningpoint.fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bhavdip.learningpoint.R;

/**
 * Created by Bhavdip Bhalodia on 05-11-2015.
 */
public class TextFragment extends Fragment {
    TextView text,vers;

    @Override

    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.text_fragment, container, false);
        text= (TextView) view.findViewById(R.id.AndroidOs);
        vers= (TextView)view.findViewById(R.id.Version);


        return view;

    }
    public void change(String txt, String txt1){
        text.setText(txt);
        vers.setText(txt1);

    }
}