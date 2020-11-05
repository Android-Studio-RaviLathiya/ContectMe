package com.example.contactme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class AddContectActivity extends AppCompatActivity {

    EditText et_lastname, et_middlename, et_firstname, et_mobilenumber, et_homenumber, et_compnynumber, et_homeaddress, et_compnyaddress, et_email;
    Button go;
    SQLiteDatabase db;
    String uid;
    RadioButton mr, ms;
    String gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contect);

        db = openOrCreateDatabase("Data.db", MODE_PRIVATE, null);


        et_lastname = findViewById(R.id.et_lastname);
        et_middlename = findViewById(R.id.et_middlename);
        et_firstname = findViewById(R.id.et_firstname);
        et_mobilenumber = findViewById(R.id.et_mobilenumber);
        et_homenumber = findViewById(R.id.et_homenumber);
        et_compnynumber = findViewById(R.id.et_compnynumber);
        et_compnyaddress = findViewById(R.id.et_compnyaddress);
        et_homeaddress = findViewById(R.id.et_homeaddress);
        et_email = findViewById(R.id.et_email);
        go = findViewById(R.id.go);
        mr = findViewById(R.id.mr);
        ms = findViewById(R.id.ms);




        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mr.isChecked()) {

                   String gender = "mr";
                } else if (ms.isChecked()) {
                   String gender = "ms";
                }


                String fname = et_firstname.getText().toString();
                String mname = et_middlename.getText().toString();
                String lname = et_lastname.getText().toString();
                String mnumber = et_mobilenumber.getText().toString();
                String hnumber = et_homenumber.getText().toString();
                String cnumber = et_compnynumber.getText().toString();
                String haddress = et_homeaddress.getText().toString();
                String caddress = et_compnyaddress.getText().toString();
                String email = et_email.getText().toString();

                if (fname.equals("")) {
                    Toast.makeText(AddContectActivity.this, "Field Name", Toast.LENGTH_SHORT).show();
                } else if (mnumber.equals("")) {
                    Toast.makeText(AddContectActivity.this, "Field Mobile Number", Toast.LENGTH_SHORT).show();
                } else {

                    db.execSQL("insert into addcontect(fname ,mname ,lname ,mnumber ,hnumber ,cnumber ,haddress,caddress ,email ,uid;) values('" + fname + "','" + mname + "','" + lname + "','" + mnumber + "','" + hnumber + "','" + cnumber + "','" + haddress + "','" + caddress + "','" + email + "','" + uid + "')");
                    Intent intent = new Intent(AddContectActivity.this, ShowContectActivity.class);
                    startActivity(intent);
                    finish();


                }
            }
        });


        //status colour
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.black));
        }
    }
}
