package com.example.wang_.regexapp;

import android.content.Intent;
import android.service.autofill.FieldClassification;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MainActivity extends AppCompatActivity {

    EditText usr_Txt, email_Txt, pwd_Txt, dob_Txt;
    String usr, email, pwd, dob, error_msg;
    Button submit_Btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        usr_Txt = findViewById(R.id.usr_txt);
        email_Txt = findViewById(R.id.email_txt);
        pwd_Txt = findViewById(R.id.pwd_txt);
        dob_Txt = findViewById(R.id.dob_txt);
        submit_Btn = findViewById(R.id.submit_btn);
        //String email = "wang131@dragon.com";
        error_msg = new String();

        submit_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                usr = usr_Txt.getText().toString();
                email = email_Txt.getText().toString();
                pwd = pwd_Txt.getText().toString();
                dob = dob_Txt.getText().toString();


                Pattern p_email = Pattern.compile("[\\S&&[^@]]*@[\\w]*.com$");
                Matcher m_email = p_email.matcher(email);
                boolean b_email = m_email.matches();
                if(!b_email){
                   error_msg= error_msg.concat("Invalid Email \n ");
                }

                Pattern p_usr = Pattern.compile("[\\w]*");
                Matcher m_usr = p_usr.matcher(usr);
                boolean b_usr = m_usr.matches();
                if(!b_usr){
                    error_msg= error_msg.concat("Invalid Username \n");
                }

                Pattern p_pwd_len = Pattern.compile("[\\S]{6,}");
                Matcher m_pwd_len = p_pwd_len.matcher(pwd);
                boolean b_pwd_len = m_pwd_len.matches();
                if(!b_pwd_len){
                    error_msg= error_msg.concat("Password is too short \n");
                }


                Pattern p_pwd_spe = Pattern.compile("[\\S]*[\\W][\\S]*");
                Matcher m_pwd_spe = p_pwd_spe.matcher(pwd);
                boolean b_pwd_spe = m_pwd_spe.matches();
                if(!b_pwd_spe){
                    error_msg= error_msg.concat("Password must contain special char \n");
                }


                Pattern p_dob = Pattern.compile("(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])-(19|20)\\d{2}");
                Matcher m_dob = p_dob.matcher(dob);
                boolean b_dob = m_dob.matches();
                if(!b_dob){
                    error_msg= error_msg.concat("Invalid Date of Birth \n");
                }


                if(b_email&&b_usr&&b_pwd_len&&b_pwd_spe&&b_dob){
                    Toast.makeText(MainActivity.this, "Valid ", Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(MainActivity.this, SecActivity.class);
                    i.putExtra("usr", usr);
                    i.putExtra("email", email);
                    i.putExtra("dob", dob);
                    startActivity(i);

                }
                else{
                    Toast.makeText(MainActivity.this, error_msg, Toast.LENGTH_SHORT).show();
                    error_msg = new String();
                }




            }
        });




        //Toast.makeText(this, ""+ b_ending+" " , Toast.LENGTH_SHORT).show();

    }




}
