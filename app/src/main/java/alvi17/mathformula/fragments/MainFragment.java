package alvi17.mathformula.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import alvi17.mathformula.R;

/**
 * Created by Alvi17 on 6/20/2015.
 */
public class MainFragment extends Fragment{
    public MainFragment()
    {

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.home_fragment, container, false);
        final  WebView w=(WebView)rootView.findViewById(R.id.webView);
        w.getSettings().setJavaScriptEnabled(true);
      //  w.getSettings().setBuiltInZoomControls(true);
        w.loadDataWithBaseURL("http://bar", "<script type='text/x-mathjax-config'>"
                + "MathJax.Hub.Config({ "
                + "showMathMenu: false, "

                + "TeX: { extensions: ['AMSmath.js','AMSsymbols.js',"
                + "'noErrors.js','noUndefined.js'] } "
                + "});</script>"
                + "<script type='text/javascript' "
                + "src='file:///android_asset/MathJax.js'"
                + "></script>", "text/html", "utf-8", "");
        w.setWebViewClient(new WebViewClient() {


            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                if (!url.startsWith("http://bar")) return;
                w.loadUrl("file:///android_asset/test/sample-tex.html");
            }
        });
                return rootView;
    }
}
