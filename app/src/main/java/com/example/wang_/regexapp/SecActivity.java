package com.example.wang_.regexapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecActivity extends AppCompatActivity {

    TextView usr_Txt, email_Txt, dob_Txt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec);

        usr_Txt = findViewById(R.id.usr_txt);
        email_Txt = findViewById(R.id.email_txt);
        dob_Txt =findViewById(R.id.dob_txt);


        Bundle bundle = getIntent().getExtras();
        String usr = bundle.getString("usr");
        String email = bundle.getString("email");
        String dob = bundle.getString("dob");

        usr_Txt.setText(usr);
        email_Txt.setText(email);
        dob_Txt.setText(dob);

    }


}
