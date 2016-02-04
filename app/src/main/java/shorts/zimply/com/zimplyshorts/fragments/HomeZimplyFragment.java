package shorts.zimply.com.zimplyshorts.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import shorts.zimply.com.zimplyshorts.R;
import shorts.zimply.com.zimplyshorts.objects.HomeActivityObjectSingle;

/**
 * Created by Ashish Goel on 2/4/2016.
 */
public class HomeZimplyFragment extends Fragment {

    HomeActivityObjectSingle mData;
    int position;

    WebView webView;

    public static HomeZimplyFragment newInstance(Bundle b) {
        HomeZimplyFragment frg = new HomeZimplyFragment();
        frg.setArguments(b);
        return frg;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.home_activity_view_pager_item_zimply, container, false);

        webView = (WebView) v.findViewById(R.id.webview);

        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mData = getArguments().getParcelable("obj");
        position = getArguments().getInt("pos");

        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadsImagesAutomatically(true);

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

        webView.loadUrl(mData.getImg());
    }
}
