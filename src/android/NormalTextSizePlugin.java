package com.platogo.cordova.normaltextsize;

import org.json.JSONException;
import org.json.JSONArray;
import org.apache.cordova.*;
import android.webkit.WebView;
import android.webkit.WebSettings;

public class NormalTextSizePlugin extends CordovaPlugin {
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if ("initialize".equals(action)) {
            try {
                final WebView webView = (WebView) this.webView.getEngine().getView();
                webView.post(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            webView.setInitialScale(100);
                            WebSettings settings = webView.getSettings();
                            settings.setLoadWithOverviewMode(true);
                            settings.setTextZoom(100);
                        } catch (RuntimeException e) {
                            return;
                        }
                    }
                });
            } catch (RuntimeException e) {
                return false;
            }
            return true;
        }
        return false; // Returning false results in a "MethodNotFound" error.
    }
}