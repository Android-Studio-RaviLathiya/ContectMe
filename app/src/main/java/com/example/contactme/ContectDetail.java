package com.example.contactme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class ContectDetail extends AppCompatActivity {

    String uid, uid1, uid2, uid3, uid4, uid5, uid6, uid7, uid8, uid9;
    TextView mnumber, hnumber,cnumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contect_detail);

        mnumber = findViewById(R.id.mnumber);
        hnumber = findViewById(R.id.hnumber);
        cnumber = findViewById(R.id.cnumber);


        //status colour
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.black));
        }

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {

//            uid = bundle.getString("gender");
            uid1 = bundle.getString("fname");
            uid2 = bundle.getString("mname");
            uid3 = bundle.getString("sname");
            uid4 = bundle.getString("mnumber");
            uid5 = bundle.getString("hnumber");
            uid6 = bundle.getString("cnumber");
            uid7 = bundle.getString("haddress");
            uid8 = bundle.getString("caddress");
            uid9 = bundle.getString("email");

        }

        mnumber.setText(uid4);
        hnumber.setText(uid5);
        cnumber.setText(uid6);


    }
}
