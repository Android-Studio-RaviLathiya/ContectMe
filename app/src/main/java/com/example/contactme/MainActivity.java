package com.example.contactme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView fname, sname, mobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fname = findViewById(R.id.fname);
        sname = findViewById(R.id.sname);
        mobile = findViewById(R.id.mobile);


        fname.setText(MyPrefrence.getname());
        sname.setText(MyPrefrence.getsname());
        mobile.setText(MyPrefrence.getmobile());

        //status colour
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.black));
        }
    }

    public void contect(View view) {
        startActivity(new Intent(MainActivity.this, ShowContectActivity.class));

    }

    public void callpad(View view) {
        startActivity(new Intent(MainActivity.this, DialNumberActivity.class));

    }

    public void favourite(View view) {
        startActivity(new Intent(MainActivity.this, FavouriteActivity.class));

    }

    public void newshop(View view) {
        startActivity(new Intent(MainActivity.this, NearShopActivity.class));

    }

    public void emergency(View view) {
        startActivity(new Intent(MainActivity.this, EmergencyActivity.class));

    }

    public void block(View view) {
        startActivity(new Intent(MainActivity.this, BlockActivity.class));

    }

    public void message(View view) {
        startActivity(new Intent(MainActivity.this, MessageActivty.class));

    }

    public void logout(View view) {
        MyPrefrence.setLogin(false);
        startActivity(new Intent(MainActivity.this, LoginActivity.class));
        finish();


    }

    public void edit(View view) {
        startActivity(new Intent(MainActivity.this, EditActivity.class));

    }
}
