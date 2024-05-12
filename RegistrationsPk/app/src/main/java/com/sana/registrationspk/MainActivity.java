package com.sana.registrationspk;


import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.sana.registrationspk.ModelClass.The_Slide_Items_Model_Class;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    CardView buildingFitness;
    BottomNavigationView buttomNevigation;
    CardView collegeRegistration;
    ImageView facebook;
    CardView fedralBoard;
    CardView hygienic;
    /* access modifiers changed from: private */
    public List<The_Slide_Items_Model_Class> listItems;
    /* access modifiers changed from: private */
    public ViewPager page;
    CardView peipris;
    CardView peira;
    CardView rawalpindiboard;
    CardView schoolRegistration;
    private TabLayout tabLayout;
    ImageView website;
    ImageView whatsapp;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        permissionsGrant(MainActivity.this);
        this.schoolRegistration = findViewById(R.id.schoolRegistration);
        this.collegeRegistration = (CardView) findViewById(R.id.collegeregistration);
        this.fedralBoard = (CardView) findViewById(R.id.fedralBoard);
        this.rawalpindiboard = (CardView) findViewById(R.id.rawalpindiboard);
        this.buildingFitness = (CardView) findViewById(R.id.buildigFitness);
        this.hygienic = (CardView) findViewById(R.id.hygienic);
        this.peira = (CardView) findViewById(R.id.checkListPeira);
        this.peipris = (CardView) findViewById(R.id.checkListPeipris);
        this.facebook = (ImageView) findViewById(R.id.imgfacebook);
        this.whatsapp = (ImageView) findViewById(R.id.imgwhatsapp);
        this.website = (ImageView) findViewById(R.id.imgwebsite);
        this.page = (ViewPager) findViewById(R.id.my_pager);
        ArrayList arrayList = new ArrayList();
        this.listItems = arrayList;
        arrayList.add(new The_Slide_Items_Model_Class(R.drawable.r1, "Slider 1 Title"));
        this.listItems.add(new The_Slide_Items_Model_Class(R.drawable.r2, "Slider 2 Title"));
        this.listItems.add(new The_Slide_Items_Model_Class(R.drawable.r3, "Slider 3 Title"));
        this.listItems.add(new The_Slide_Items_Model_Class(R.drawable.r4, "Slider 4 Title"));
        this.listItems.add(new The_Slide_Items_Model_Class(R.drawable.r5, "Slider 5 Title"));
        this.listItems.add(new The_Slide_Items_Model_Class(R.drawable.r6, "Slider 6 Title"));
        this.listItems.add(new The_Slide_Items_Model_Class(R.drawable.r7, "Slider 7 Title"));
        this.listItems.add(new The_Slide_Items_Model_Class(R.drawable.r8, "Slider 8 Title"));
        this.listItems.add(new The_Slide_Items_Model_Class(R.drawable.r9, "Slider 9 Title"));
        this.listItems.add(new The_Slide_Items_Model_Class(R.drawable.r10, "Slider 10 Title"));
        this.page.setAdapter(new The_Slide_items_Pager_Adapter(this, this.listItems));
        new Timer().scheduleAtFixedRate(new The_slide_timer(), 2000, 3000);
        this.facebook.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Open Facebook", Toast.LENGTH_SHORT).show();
                Intent f = new Intent("android.intent.action.VIEW");
                f.setData(Uri.parse("http://www.facebook.com/registration.com.pk"));
                MainActivity.this.startActivity(f);
            }
        });
        this.whatsapp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Open WhatsApp", Toast.LENGTH_SHORT).show();
                Intent w = new Intent("android.intent.action.VIEW");
                w.setData(Uri.parse("https://api.whatsapp.com/send?phone=%2B923330311155&data=AWCR-Jc43MnWMrTEN0JfTJPYP-IS6XUEm6PJLDfpd_UQwc6NZHyFySQeSVSQADrebRNNgN1ZvvidKGSws10fwFq9malqwm8kJk_xhbw6UA25F1J-fIL-niAzBPEhqRmlBkBHfMQWAYm5cHSqfftSy6ElPzeSSAA09b44oRhr2H0NlM5K4K7mz17r58zol4EefNy8B8fL8kAglHXYKihj0NYhTxLTxgUH_cveruoOxJdNSLe8_bI-eCDAWQNNCIMk8GGiIbk__tj3A8-nWpWjWe-lwBHBpFH4OuKGQEVdinbbketM3DVuI9kUET-r6Fx6I9s&source=FB_Page&app=facebook&entry_point=page_cta&fbclid=IwAR1Az4eu1JqfqSlXdaZbiQtxzMWNTGDeOVs-IIqiLXpzemvk3trDuQzc8Og"));
                MainActivity.this.startActivity(w);
            }
        });
        this.website.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Open Website", Toast.LENGTH_SHORT).show();
                Intent r = new Intent("android.intent.action.VIEW");
                r.setData(Uri.parse("https://registrations.pk/frontend/"));
                MainActivity.this.startActivity(r);
            }
        });
        this.schoolRegistration.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.startActivity(new Intent(MainActivity.this, SchoolRegistration.class));
            }
        });
        this.collegeRegistration.setOnClickListener(view -> MainActivity.this.startActivity(new Intent(MainActivity.this, CollegeRegistration.class)));
        this.fedralBoard.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.startActivity(new Intent(MainActivity.this, FedralBoard.class));
            }
        });
        this.rawalpindiboard.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.startActivity(new Intent(MainActivity.this, RawalPindiBoard.class));
            }
        });
        this.buildingFitness.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //  MainActivity.this.startActivity(new Intent(MainActivity.this, BuildingFitnessCertificate.class));

                startActivity(new Intent(getApplicationContext(), SubmitForm.class).putExtra("url", "https://registrations.pk/building-evaluation"));

            }

        });
        this.hygienic.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //    MainActivity.this.startActivity(new Intent(MainActivity.this, HygienicCertificate.class));
                startActivity(new Intent(getApplicationContext(), SubmitForm.class).putExtra("url", "https://registrations.pk/home/hygienic-form"));

            }
        });
        this.peira.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.startActivity(new Intent(MainActivity.this, Peira.class));
            }
        });
        this.peipris.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.startActivity(new Intent(MainActivity.this, Pepris.class));
            }
        });
    }

    public void onBackPressed() {
        showAppDialog();
    }

    private void showAppDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.setContentView(R.layout.popup_closeapp);
        ((Button) dialog.findViewById(R.id.popup_btnno)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        ((Button) dialog.findViewById(R.id.popup_btnyes)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dialog.dismiss();
                MainActivity.this.finish();
            }
        });
        dialog.show();
    }

    public class The_slide_timer extends TimerTask {
        public The_slide_timer() {
        }

        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                public void run() {
                    if (MainActivity.this.page.getCurrentItem() < MainActivity.this.listItems.size() - 1) {
                        MainActivity.this.page.setCurrentItem(MainActivity.this.page.getCurrentItem() + 1);
                    } else {
                        MainActivity.this.page.setCurrentItem(0);
                    }
                }
            });
        }
    }



    public static boolean permissionsGrant(Context context) {
        int permissionsReadStorage = ContextCompat.checkSelfPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE);

        List<String> listPermissionsNeeded = new ArrayList<>();

        if (permissionsReadStorage != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.READ_EXTERNAL_STORAGE);
        }

        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions((Activity) context, listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]),252);
            return false;
        }
        return true;
    }
}



/*
package com.sana.registrationspk;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;

 public class MainActivity extends AppCompatActivity {
     WebView mWebView;

     private final String TAG = MainActivity.class.getSimpleName();

     private final String URL = "https://registrations.pk";
     private LinearLayout mlLayoutRequestError = null;
     private Handler mhErrorLayoutHide = null;

     private boolean mbErrorOccured = false;
     private boolean mbReloadPressed = false;


     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    //   mWebView = findViewById(R.id.webview);



        mWebView.setWebViewClient(new MyWebViewClient());
        WebSettings settings = mWebView.getSettings();
        settings.setJavaScriptEnabled(true);

        mWebView.setWebChromeClient(getChromeClient());

        mWebView.loadUrl(URL);
    }

     @Override
     public boolean onSupportNavigateUp() {
         return super.onSupportNavigateUp();
     }

    */
/* @Override
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
*//*

     @Override
     public void onBackPressed() {
         if (mWebView.canGoBack()) {
             mWebView.goBack();
             return;
         }
         else {
             finish();
         }

         super.onBackPressed();
     }

     class MyWebViewClient extends WebViewClient {
         @Override
         public boolean shouldOverrideUrlLoading(WebView view, String url) {
             return super.shouldOverrideUrlLoading(view, url);
         }

         @Override
         public void onPageStarted(WebView view, String url, Bitmap favicon) {
             super.onPageStarted(view, url, favicon);
         }

         @Override
         public void onLoadResource(WebView view, String url) {
             super.onLoadResource(view, url);
         }

         @Override
         public void onPageFinished(WebView view, String url) {
             mWebView.loadUrl("javascript:(function() { " +
                     "document.getElementsByClassName('wpb_wrapper')[0].remove();" +
                     "})()");
             mWebView.loadUrl("javascript:(function() { " +
                     "document.getElementsByClassName('bt-header-mobile')[0].remove();" +
                     "})()");
             mWebView.loadUrl("javascript:(function() { " +
                     "document.getElementsByClassName('bt-header bt-header-v1 bt-stick')[0].remove();" +
                     "})()");
             mWebView.loadUrl("javascript:(function() { " +
                     "document.getElementsByClassName('bt-footer bt-footer-v1')[0].remove();" +
                     "})()");

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
         final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
         progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
         progressDialog.setCancelable(false);

         return new WebChromeClient() {
             @Override
             public void onProgressChanged(WebView view, int newProgress) {
                 super.onProgressChanged(view, newProgress);
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

    }
*/
