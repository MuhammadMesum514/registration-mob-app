package com.sana.registrationspk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class FedralBoard extends AppCompatActivity {
    CardView fedralBoardForFresh;
    CardView fedralBoardForRenewal;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_fedral_board);
        this.fedralBoardForFresh = (CardView) findViewById(  R.id.fedralBoardForFresh);
        this.fedralBoardForRenewal = (CardView) findViewById(  R.id.fedralBoardForRenewal);
        this.fedralBoardForFresh.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
               // FedralBoard.this.startActivity(new Intent(FedralBoard.this, FedralBoardForFresh.class));
                startActivity(new Intent(getApplicationContext(),SubmitForm.class).putExtra("url", "https://registrations.pk/federal-board-affiliation-fresh"));
                startActivity(new Intent(getApplicationContext(),SubmitForm.class).putExtra("url", "https://registrations.pk/federal-board-affiliation-fresh "));
            }
        });
        this.fedralBoardForRenewal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
             //   FedralBoard.this.startActivity(new Intent(FedralBoard.this, FedralBoardForRenewal.class));
                startActivity(new Intent(getApplicationContext(),SubmitForm.class).putExtra("url", "https://registrations.pk/federal-board-affiliation-renewal"));

            }
        });
    }
}
