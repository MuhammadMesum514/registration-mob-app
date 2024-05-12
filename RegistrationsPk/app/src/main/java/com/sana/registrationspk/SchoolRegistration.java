package com.sana.registrationspk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class SchoolRegistration extends AppCompatActivity {
    CardView schoolRegistrationForFresh;
    CardView schoolRegistrationForRenewal;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_registration);
        this.schoolRegistrationForFresh = (CardView) findViewById(R.id.schoolRegistrationForFresh);
        this.schoolRegistrationForRenewal = (CardView) findViewById(R.id.schoolRegistrationForRenewal);
        this.schoolRegistrationForFresh.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            //    SchoolRegistration.this.startActivity(new Intent(SchoolRegistration.this, SchoolRegistrationForFresh.class));

                startActivity(new Intent(getApplicationContext(),SubmitForm.class).putExtra("url", "https://registrations.pk/school-registration-fresh"));

            }
        });
        this.schoolRegistrationForRenewal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
              //  SchoolRegistration.this.startActivity(new Intent(SchoolRegistration.this, SchoolRegistrationForRenewal.class));
                startActivity(new Intent(getApplicationContext(),SubmitForm.class).putExtra("url", "https://registrations.pk/school-registration-renewal"));

            }
        });
    }
}
