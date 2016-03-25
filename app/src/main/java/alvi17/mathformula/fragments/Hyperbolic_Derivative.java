package alvi17.mathformula.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import alvi17.mathformula.R;

/**
 * Created by User on 3/25/2016.
 */
public class Hyperbolic_Derivative extends Fragment{

    public Hyperbolic_Derivative()
    {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_main, container, false);
        final WebView w=(WebView)rootView.findViewById(R.id.fragmentwebView);
        TextView txt=(TextView)rootView.findViewById(R.id.titletextView);
        txt.setText("Hyperbolic Derivative");
        w.getSettings().setJavaScriptEnabled(true);
        w.getSettings().setBuiltInZoomControls(true);
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
                w.loadUrl("file:///android_asset/test/Hyperbolic_Derivatives.html");
            }
        });
        return rootView;
    }
}
