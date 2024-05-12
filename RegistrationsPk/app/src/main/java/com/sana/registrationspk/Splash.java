package com.sana.registrationspk;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class Splash extends AppCompatActivity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_splash);
//        getSupportActionBar().hide();
        new Handler().postDelayed(new Runnable() {
            public void run() {
                Splash.this.runOnUiThread(new Runnable() {
                    public void run() {
                        Splash.this.startActivity(new Intent(Splash.this, MainActivity.class));
                        Splash.this.finish();
                    }
                });
            }
        }, 3000);
    }
}
