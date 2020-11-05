package com.example.contactme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class DialNumberActivity extends AppCompatActivity implements View.OnClickListener {

    public static final int REQUEST_CALL = 1;
    private EditText edittext;
    LinearLayout call;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dial_number);

        edittext = findViewById(R.id.edittext);
        call = findViewById(R.id.call);



        /*status colour*/
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.black));
        }

        /*back button*/
        ImageView back;
        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        initializeView();

    }



    private void initializeView() {
        edittext = findViewById(R.id.edittext);
        int idList[] = {R.id.one, R.id.two, R.id.three, R.id.four, R.id.five,
                R.id.six, R.id.seven, R.id.eghit, R.id.nine,
                R.id.star, R.id.ziro, R.id.hesh, R.id.call, R.id.delet};


        for (int d : idList) {
            View v = (View) findViewById(d);
            v.setOnClickListener(this);
        }
    }

    public void display(String val) {
        edittext.append(val);
    }

    private boolean checkCallPermission() {
        String permission = "android.permisson.CALL_PHONE";
        int res = getApplicationContext().checkCallingOrSelfPermission(permission);
        return (res == PackageManager.PERMISSION_GRANTED);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.one:
                display("1");
                break;
            case R.id.two:
                display("2");
                break;
            case R.id.three:
                display("3");
                break;
            case R.id.four:
                display("4");
                break;
            case R.id.five:
                display("5");
                break;
            case R.id.six:
                display("6");
                break;
            case R.id.seven:
                display("7");
                break;
            case R.id.eghit:
                display("8");
                break;
            case R.id.nine:
                display("9");
                break;
            case R.id.star:
                display("*");
                break;
            case R.id.ziro:
                display("0");
                break;
            case R.id.hesh:
                display("#");
                break;
            case R.id.call:
                if (edittext.getText().toString().isEmpty())

                    Toast.makeText(this, "Enter Number", Toast.LENGTH_SHORT).show();

                else if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) !=

                        PackageManager.PERMISSION_GRANTED
                ) {

                    ActivityCompat.requestPermissions(this, new String[]
                            {Manifest.permission.CALL_PHONE}, REQUEST_CALL);

                } else {

                    String dail = "tel:" +edittext;
                    startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dail)));


                }




                break;
            case R.id.delet:
                if (edittext.getText().toString().length() >= 1) {
                    String newScreen = edittext.getText().toString().substring(0, edittext.getText().toString().length() - 1);
                    edittext.setText(newScreen);
                }
                break;
            default:
                break;

        }

    }

    public void contect(View view) {

        startActivity(new Intent(DialNumberActivity.this, ShowContectActivity.class));

    }
}
