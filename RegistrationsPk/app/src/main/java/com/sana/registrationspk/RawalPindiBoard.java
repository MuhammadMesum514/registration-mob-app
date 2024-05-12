package com.sana.registrationspk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class

RawalPindiBoard extends AppCompatActivity {
    CardView biserawalpindiforfresh;
    CardView biserawalpindiforrenewal;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rawal_pindi_board);
        this.biserawalpindiforfresh = (CardView) findViewById(R.id.rawalpindiBoardForFresh);
        this.biserawalpindiforrenewal = (CardView) findViewById(R.id.rawalpindiBoardForRenewal);
        this.biserawalpindiforfresh.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
              //  RawalPindiBoard.this.startActivity(new Intent(RawalPindiBoard.this, RawalpindiBoardForFresh.class));
                startActivity(new Intent(getApplicationContext(),SubmitForm.class).putExtra("url", "https://registrations.pk/rawalpindi-affiliation-fresh"));

            }
        });
        this.biserawalpindiforrenewal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            //    RawalPindiBoard.this.startActivity(new Intent(RawalPindiBoard.this, RawalpindiBoardForRenewal.class));
                startActivity(new Intent(getApplicationContext(),SubmitForm.class).putExtra("url", "https://registrations.pk/rawalpindi-board-affiliation-renewal"));

            }
        });
    }
}
