package com.sana.registrationspk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class CollegeRegistration extends AppCompatActivity {
    CardView collegeRegistrationForFresh;
    CardView collegeRegistrationForRenewal;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_college_registration);
        this.collegeRegistrationForFresh = (CardView) findViewById(R.id.collegeRegistrationForFresh);
        this.collegeRegistrationForRenewal = (CardView) findViewById(R.id.collegeRegistrationForRenewal);
        this.collegeRegistrationForFresh.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
              //  CollegeRegistration.this.startActivity(new Intent(CollegeRegistration.this, CollegeRegistrationForFresh.class));
                startActivity(new Intent(getApplicationContext(),SubmitForm.class).putExtra("url", "https://registrations.pk/college-registration-fresh"));
            }
        });
        this.collegeRegistrationForRenewal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //CollegeRegistration.this.startActivity(new Intent(CollegeRegistration.this, CollegeRegistrationForRenewal.class));
                startActivity(new Intent(getApplicationContext(),SubmitForm.class).putExtra("url", "https://registrations.pk/college-registration-renewal"));

            }
        });
    }
}
