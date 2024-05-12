package com.sana.registrationspk;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.Toast;

public class SubmitForm extends AppCompatActivity {
    WebView mWebView;

    public ValueCallback<Uri[]> uploadMessage;
    private ValueCallback<Uri> mUploadMessage;
    public static final int REQUEST_SELECT_FILE = 100;
    private final static int FILECHOOSER_RESULTCODE = 1;
    private ProgressDialog progress;
    private final String TAG = SubmitForm.class.getSimpleName();

    private String URL = "";
    private LinearLayout mlLayoutRequestError = null;
    private Handler mhErrorLayoutHide = null;

    private boolean mbErrorOccured = false;
    private boolean mbReloadPressed = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_form);
        mWebView = findViewById(R.id.webview);
        URL=getIntent().getExtras().getString("url");

        mWebView.setWebViewClient(new MyWebViewClient());
        WebSettings settings = mWebView.getSettings();
        settings.setJavaScriptEnabled(true);

        mWebView.setWebChromeClient(getChromeClient());

        mWebView.loadUrl(URL);
        mWebView.getSettings().setDomStorageEnabled(true);
        mWebView.getSettings().setAllowContentAccess(true);
        mWebView.getSettings().setAllowFileAccess(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        return super.onSupportNavigateUp();
    }

 /*
 @Override
     public void onClick(View v) {
         int id = v.getId();

         if (id == R.id.btnRetry) {
             if (!mbErrorOccured) {
                 return;
             }

             mbReloadPressed = true;
             mWebView.reload();
             mbErrorOccured = false;
         }
     }
*/

     @Override
     public void onBackPressed() {
             finish();
     }

     class MyWebViewClient extends WebViewClient {
         @Override
         public boolean shouldOverrideUrlLoading(WebView view, String url) {
             return super.shouldOverrideUrlLoading(view, url);
         }

         @Override
         public void onPageStarted(WebView view, String url, Bitmap favicon) {
             super.onPageStarted(view, url, favicon);

             progress=new ProgressDialog(SubmitForm.this);
             progress.setMessage("Loading");
             progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
             progress.setIndeterminate(true);

             progress.show();
         }

         @Override
         public void onLoadResource(WebView view, String url) {
             mWebView.loadUrl("javascript:(function() { " +
                     "document.getElementsByClassName('will-remove-on-mobile')[0].remove();" +
                     "})()");

             mWebView.loadUrl("javascript:(function() { " +
                     "document.getElementsByClassName('will-remove-on-mobile-footer')[0].remove();" +
                     "})()");

             super.onLoadResource(view, url);
         }

         @Override
         public void onPageFinished(WebView view, String url) {
//             mWebView.loadUrl("javascript:(function() { " +
//                     "document.getElementsByClassName('wpb_wrapper')[0].remove();" +
//                     "})()");
//             mWebView.loadUrl("javascript:(function() { " +
//                     "document.getElementsByClassName('bt-header-mobile')[0].remove();" +
//                     "})()");
//             mWebView.loadUrl("javascript:(function() { " +
//                     "document.getElementsByClassName('bt-header bt-header-v1 bt-stick')[0].remove();" +
//                     "})()");
//             mWebView.loadUrl("javascript:(function() { " +
//                     "document.getElementsByClassName('bt-footer bt-footer-v1')[0].remove();" +
//                     "})()");

             mWebView.loadUrl("javascript:(function() { " +
                     "document.getElementsByClassName('will-remove-on-mobile')[0].remove();" +
                     "})()");

             mWebView.loadUrl("javascript:(function() { " +
                     "document.getElementsByClassName('will-remove-on-mobile-footer')[0].remove();" +
                     "})()");
             progress.dismiss();


             if (mbErrorOccured == false && mbReloadPressed) {

                 hideErrorLayout();
                 mbReloadPressed = false;
             }

             super.onPageFinished(view, url);
         }

         @Override
         public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
             mbErrorOccured = true;
             showErrorLayout();
             super.onReceivedError(view, errorCode, description, failingUrl);
         }
     }

     private WebChromeClient getChromeClient() {
         final ProgressDialog progressDialog = new ProgressDialog(SubmitForm.this);
         progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
         progressDialog.setCancelable(false);

         return new WebChromeClient() {
             @Override
             public void onProgressChanged(WebView view, int newProgress) {
                 super.onProgressChanged(view, newProgress);
             }


             protected void openFileChooser(ValueCallback uploadMsg, String acceptType) {
                 mUploadMessage = uploadMsg;
                 Intent i = new Intent(Intent.ACTION_GET_CONTENT);
                 i.addCategory(Intent.CATEGORY_OPENABLE);
                 i.setType("image/*");
                 startActivityForResult(Intent.createChooser(i, "File Chooser"), FILECHOOSER_RESULTCODE);
             }


             // For Lollipop 5.0+ Devices
             @TargetApi(Build.VERSION_CODES.LOLLIPOP)
             public boolean onShowFileChooser(WebView mWebView, ValueCallback<Uri[]> filePathCallback, FileChooserParams fileChooserParams) {
                 if (uploadMessage != null) {
                     uploadMessage.onReceiveValue(null);
                     uploadMessage = null;
                 }

                 uploadMessage = filePathCallback;

                 Intent intent = fileChooserParams.createIntent();
                 try {
                     startActivityForResult(intent, REQUEST_SELECT_FILE);
                 } catch (ActivityNotFoundException e) {
                     uploadMessage = null;
                     Toast.makeText(SubmitForm.this, "Cannot Open File Chooser", Toast.LENGTH_LONG).show();
                     return false;
                 }
                 return true;
             }

             //For Android 4.1 only
             protected void openFileChooser(ValueCallback<Uri> uploadMsg, String acceptType, String capture) {
                 mUploadMessage = uploadMsg;
                 Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                 intent.addCategory(Intent.CATEGORY_OPENABLE);
                 intent.setType("image/*");
                 startActivityForResult(Intent.createChooser(intent, "File Chooser"), FILECHOOSER_RESULTCODE);
             }

             protected void openFileChooser(ValueCallback<Uri> uploadMsg) {
                 mUploadMessage = uploadMsg;
                 Intent i = new Intent(Intent.ACTION_GET_CONTENT);
                 i.addCategory(Intent.CATEGORY_OPENABLE);
                 i.setType("image/*");
                 startActivityForResult(Intent.createChooser(i, "File Chooser"), FILECHOOSER_RESULTCODE);
             }


         };
     }

     private void showErrorLayout() {
         mlLayoutRequestError.setVisibility(View.VISIBLE);
     }

     private void hideErrorLayout() {
         mhErrorLayoutHide.sendEmptyMessageDelayed(10000, 200);
     }

     private Handler getErrorLayoutHideHandler() {
         return new Handler() {
             @Override
             public void handleMessage(Message msg) {
                 mlLayoutRequestError.setVisibility(View.GONE);
                 super.handleMessage(msg);
             }
         };
     }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (requestCode == REQUEST_SELECT_FILE) {
                if (uploadMessage == null)
                    return;
                uploadMessage.onReceiveValue(WebChromeClient.FileChooserParams.parseResult(resultCode, intent));
                uploadMessage = null;
            }
        } else if (requestCode == FILECHOOSER_RESULTCODE) {
            if (null == mUploadMessage)
                return;
            // Use MainActivity.RESULT_OK if you're implementing WebView inside Fragment
            // Use RESULT_OK only if you're implementing WebView inside an Activity
            Uri result = intent == null || resultCode != SubmitForm.RESULT_OK ? null : intent.getData();
            mUploadMessage.onReceiveValue(result);
            mUploadMessage = null;
        } else
            Toast.makeText(SubmitForm.this, "Failed to Upload Image", Toast.LENGTH_LONG).show();
    }
    }
