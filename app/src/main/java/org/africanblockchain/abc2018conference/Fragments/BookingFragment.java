package org.africanblockchain.abc2018conference.Fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import org.africanblockchain.abc2018conference.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BookingFragment extends Fragment {

    public WebView mWebView;
    public BookingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_booking, container, false);
        View v=inflater.inflate(R.layout.fragment_booking, container, false);
        mWebView = (WebView) v.findViewById(R.id.webView);
        mWebView.loadUrl("https://africanblockchain.org/book-a-seat/");

        // Enable Javascript
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // Force links and redirects to open in the WebView instead of in a browser
        mWebView.setWebViewClient(new WebViewClient());

        return v;
    }

}
