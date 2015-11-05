package com.bhavdip.learningpoint;

;import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Bhavdip Bhalodia on 09-10-2015.
 */
public class IntentAction extends Activity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_action);

    }

    public void call(View v) {
        Intent i = null;
        switch (v.getId()) {
            case R.id.internet:
                i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.sadhaktechnologies.org/"));
                startActivity(i);
                break;
            case R.id.fb:
                i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.facebook.com"));
                startActivity(i);
                break;

            case R.id.bigb:
                i = new Intent(Intent.ACTION_CALL, Uri.parse("tel:+919892284595"));
                startActivity(i);
                break;
            case R.id.phone:
                i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:9892284595"));
                startActivity(i);
                break;
            case R.id.cam:
                i = new Intent("android.media.action.IMAGE_CAPTURE");
                startActivity(i);
                break;
        }
    }

    @Override
    public void onClick(View view) {

    }
}