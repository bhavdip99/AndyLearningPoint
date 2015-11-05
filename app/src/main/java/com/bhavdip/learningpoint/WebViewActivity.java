package com.bhavdip.learningpoint;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

public class WebViewActivity extends Activity {

    WebView webview;
    TextView txt;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_web);
        Intent in = getIntent();
        String page_url = in.getStringExtra("link");
        Log.i("display", "url :" + page_url);

//        String summary = "<html><body>";
//        summary += "<p>Do you undearstand what it means to be lonely? Someone asked me once and I said that I can never be lonely. Listening to the song by Boys To Men-&#8221;Show me the meaning of being lonely,&#8221; would make you know how loneliness feels but that&#8217;s not what loneliness means. Someone<a href=\"http://www.krsnaknows.com/what-it-means-to-be-lonely/\" class=\"read-more\">Read the Rest...</a></p><p>The post <a href=\"http://www.krsnaknows.com/what-it-means-to-be-lonely/\">What It Means To Be Lonely?</a> appeared first on <a href=\"http://www.krsnaknows.com\">KrsnaKnows</a>.</p>";
//        summary.replaceAll("\"", "\\\"\"");
//        Log.i("TAG", "Desc" + summary);
//        Toast.makeText(this, summary, Toast.LENGTH_LONG).show();
//        summary += "</body></html>";
        webview = (WebView) findViewById(R.id.webpage);
        txt = (TextView) findViewById(R.id.textView1);

//		webview.setWebViewClient(new HelloWebViewClient());
        webview.setWebViewClient(new WebViewClient());
        webview.getSettings().setJavaScriptEnabled(true);
//        webview.loadData(summary, "text/html", "UTF-8");
//		txt.setText(summary);
		webview.loadUrl("https://www.facebook.com");
    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        webview.clearHistory();
        webview.clearFormData();
        webview.clearCache(true);
    }

    public class HelloWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
