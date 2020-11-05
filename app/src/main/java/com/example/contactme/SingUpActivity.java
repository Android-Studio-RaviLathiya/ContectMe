package com.example.contactme;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

import in.mayanknagwanshi.imagepicker.ImageSelectActivity;

public class SingUpActivity extends AppCompatActivity {

    EditText et_firstname, et_lastname, et_phonenumber, et_email, et_password, et_conpassword, et_dob;
    Spinner sp;
    Button go;
    ImageView btn_date, img;
    RadioButton mr, ms;
    CheckBox cb;
    String gender, filePath;
    ArrayList<String> arrayList = new ArrayList<>();
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    int d, m, y;
    Calendar calendar = Calendar.getInstance();
    SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);

        et_firstname = findViewById(R.id.et_firstname);
        et_lastname = findViewById(R.id.et_lastname);
        et_phonenumber = findViewById(R.id.et_phonenumber);
        et_email = findViewById(R.id.et_email);
        et_password = findViewById(R.id.et_password);
        et_conpassword = findViewById(R.id.et_conpassword);
        et_dob = findViewById(R.id.et_dob);

        sp = findViewById(R.id.sp);
        btn_date = findViewById(R.id.btn_date);
        go = findViewById(R.id.go);
        mr = findViewById(R.id.mr);
        ms = findViewById(R.id.ms);
        cb = findViewById(R.id.cb);
        img = findViewById(R.id.img);

        db = openOrCreateDatabase("Data.db", MODE_PRIVATE, null);


        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String fn = et_firstname.getText().toString().trim();
                String ln = et_lastname.getText().toString().trim();
                String ph = et_phonenumber.getText().toString().trim();
                String mail = et_email.getText().toString().trim();
                String pass = et_password.getText().toString().trim();
                String cpass = et_conpassword.getText().toString().trim();
                String date = et_dob.getText().toString().trim();

                if (mr.isChecked()) {
                    gender = "Male";
                } else if (ms.isChecked()) {
                    gender = "FeMale";
                }


                if (gender.equals("")) {
                    Toast.makeText(SingUpActivity.this, "Gender Reuired", Toast.LENGTH_SHORT).show();
                } else if (fn.equals("")) {
                    Toast.makeText(SingUpActivity.this, "Field Name", Toast.LENGTH_SHORT).show();

                } else if (ln.equals("")) {
                    Toast.makeText(SingUpActivity.this, "Field Last Name", Toast.LENGTH_SHORT).show();

                } else if (ph.equals("")) {
                    Toast.makeText(SingUpActivity.this, "Field Phone Number", Toast.LENGTH_SHORT).show();

                } else if (ph.length() < 10) {
                    Toast.makeText(SingUpActivity.this, "Not Valid Number", Toast.LENGTH_SHORT).show();

                } else if (mail.equals("")) {
                    Toast.makeText(SingUpActivity.this, "Field Email", Toast.LENGTH_SHORT).show();

                } else if (!mail.matches(emailPattern)) {
                    Toast.makeText(SingUpActivity.this, "Not Valid Email", Toast.LENGTH_SHORT).show();

                } else if (pass.equals("")) {
                    Toast.makeText(SingUpActivity.this, "Field Password", Toast.LENGTH_SHORT).show();

                } else if (cpass.equals("")) {
                    Toast.makeText(SingUpActivity.this, "Field Confome Password", Toast.LENGTH_SHORT).show();

                } else if (!cpass.equals(pass)) {
                    Toast.makeText(SingUpActivity.this, "Not Match Password", Toast.LENGTH_SHORT).show();

                } else if (date.equals("")) {
                    et_dob.setError("Select Date");

                } else if (!cb.isChecked()) {
                    Toast.makeText(SingUpActivity.this, "Accept Term and Condition", Toast.LENGTH_SHORT).show();

                } else {
                    Cursor c = db.rawQuery("select * from newuser where email='" + et_email + "'", null);

                    if (c != null) {
                        if (c.moveToNext()) {

                            Toast.makeText(SingUpActivity.this, "Alredy", Toast.LENGTH_SHORT).show();

                        } else {
                            db.execSQL("INSERT INTO newuser(img,gender,fn,ln,mob,email,pass,dob) values('" + filePath + "','" + gender + "','" + fn + "','" + ln + "','" + ph + "','" + mail + "','" + pass + "','" + date + "')");


                            Intent intent = new Intent(SingUpActivity.this, LoginActivity.class);
                            startActivity(intent);
                            finish();

                            MyPrefrence.setname(fn);
                            MyPrefrence.setmobile(ph);
                            MyPrefrence.setemail(mail);
                            MyPrefrence.setpass(pass);
                            MyPrefrence.setsname(ln);

                        }
                    }
                }
            }

        });


        /*photo picker*/

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SingUpActivity.this, ImageSelectActivity.class);
                intent.putExtra(ImageSelectActivity.FLAG_COMPRESS, false);//default is true
                intent.putExtra(ImageSelectActivity.FLAG_CAMERA, true);//default is true
                intent.putExtra(ImageSelectActivity.FLAG_GALLERY, true);//default is true
                startActivityForResult(intent, 1213);
            }
        });





        /*Date of Birthday date picker*/

        btn_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                y = calendar.get(Calendar.YEAR);
                m = calendar.get(Calendar.MONTH);
                d = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(SingUpActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                        et_dob.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                    }
                }, y, m, d);
                datePickerDialog.show();
            }
        });


        /*Spinner Mobile number*/

        arrayList.add("+91");
        arrayList.add("+213");
        arrayList.add("+93");
        arrayList.add("+376");
        arrayList.add("+223");
        arrayList.add("+444");
        arrayList.add("+1");
        arrayList.add("+90");
        arrayList.add("+41");
        arrayList.add("+291");
        arrayList.add("+881");
        arrayList.add("+599");
        arrayList.add("+31");
        arrayList.add("+07");

        for (
                int i = 0; i < arrayList.size(); i++) {
            Log.e("corde", "contry" + arrayList.get(i));
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(SingUpActivity.this, R.layout.support_simple_spinner_dropdown_item, arrayList);
        sp.setAdapter(arrayAdapter);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position,
                                       long id) {
                Toast.makeText(SingUpActivity.this, "" + arrayList.get(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1213 && resultCode == Activity.RESULT_OK) {
            String filePath = data.getStringExtra(ImageSelectActivity.RESULT_FILE_PATH);


            Bitmap selectedImage = BitmapFactory.decodeFile(filePath);
            img.setImageBitmap(selectedImage);
        }
    }
}
