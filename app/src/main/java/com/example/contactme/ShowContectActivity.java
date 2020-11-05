package com.example.contactme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.contactme.Adepter.AddContectAdepter;
import com.example.contactme.Adepter.AddContectItem;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class ShowContectActivity extends AppCompatActivity {

    FloatingActionButton btn_Addcontect;
    SQLiteDatabase db;
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_contect);

        rv = findViewById(R.id.rv);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(linearLayoutManager);


        db = openOrCreateDatabase("Data.db", MODE_PRIVATE, null);


        /*status colour*/
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.black));
        }

        /*back button*/
        TextView back;
        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        btn_Addcontect = findViewById(R.id.btn_Addcontect);

        btn_Addcontect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ShowContectActivity.this, AddContectActivity.class));

            }
        });

        addcontect();
    }


    ArrayList<AddContectItem> addContectItems = new ArrayList<>();

    private void addcontect() {

        addContectItems.clear();

        Cursor c = db.rawQuery("select * from addcontect", null);

        if (c != null) {

            while (c.moveToNext()) {

                AddContectItem cusmorItem = new AddContectItem(c.getString(0), c.getString(1), c.getString(2),c.getString(3),c.getString(4),c.getString(5),c.getString(6),c.getString(7),c.getString(8),c.getString(9));
                addContectItems.add(cusmorItem);

                Log.e("customr", "id" + c.getString(0));
                Log.e("customr", "First Name" + c.getString(1));
                Log.e("customr", "Last Name" + c.getString(2));
            }
            if (addContectItems.size() > 0) {
                AddContectAdepter custmorAdepter = new AddContectAdepter(addContectItems, ShowContectActivity.this);
                rv.setAdapter(custmorAdepter);
            } else {

                Toast toast = Toast.makeText(this, "No Data", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();

            }
        }
    }
}