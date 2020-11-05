package com.example.contactme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {


    EditText et_email, et_password;
    Button go;
    SQLiteDatabase db;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    TextView singup;

    CheckBox cb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        go = findViewById(R.id.go);
        et_email = findViewById(R.id.et_email);
        et_password = findViewById(R.id.et_password);
        singup = findViewById(R.id.sing);
        cb = findViewById(R.id.cb);

        singup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, SingUpActivity.class));
            }
        });

        db = openOrCreateDatabase("Data.db", MODE_PRIVATE, null);
        db.execSQL("create table if not exists newuser(id integer primary key autoincrement,img text,gender text,fn text,ln text,mob text,email text,pass text,dob text)");
        db.execSQL("create table if not exists addcontect(id integer primary key autoincrement,fname text,mname text,lname text,mnumber text,hnumber text,cnumber text,haddress text,caddress text,email text,uid text )");


        cb.setChecked(MyPrefrence.getbtn());

        if (MyPrefrence.getbtn()) {
            et_email.setText(MyPrefrence.getmobile());
            et_password.setText(MyPrefrence.getpass());
        }

        if (MyPrefrence.getLogin()) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    MyPrefrence.setbtn(true);
                    Toast.makeText(LoginActivity.this, "Remember", Toast.LENGTH_SHORT).show();
                } else {
                    MyPrefrence.setbtn(false);
                    Toast.makeText(LoginActivity.this, "Not Remember", Toast.LENGTH_SHORT).show();
                }
            }
        });
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String uname = et_email.getText().toString();
                String upass = et_password.getText().toString();

                if (uname.equals("")) {
                    Toast.makeText(LoginActivity.this, "Email Reuired", Toast.LENGTH_SHORT).show();
                } else if (!uname.matches(emailPattern)) {
                    Toast.makeText(LoginActivity.this, "Not Valid Email", Toast.LENGTH_SHORT).show();
                } else if (upass.equals("")) {
                    Toast.makeText(LoginActivity.this, "Password Reuired", Toast.LENGTH_SHORT).show();
                } else {

                    Cursor c = db.rawQuery("select * from newuser where email='" + uname + "' and pass='" + upass + "'", null);

                    if (c != null) {

                        MyPrefrence.setLogin(true);

                        if (MyPrefrence.getbtn()) {
                            MyPrefrence.setemail(uname);
                            MyPrefrence.setpass(upass);
                        }

                        if (c.moveToNext()) {
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();


                            Toast.makeText(LoginActivity.this, "Login", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(LoginActivity.this, "invalid", Toast.LENGTH_SHORT).show();
                        }
                    }
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
