package com.msmi.intentimplicit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn_implicit_kontak;
    Button btn_implicit_web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_implicit_kontak = (Button) findViewById(R.id.btn_implicit_kontak);
        btn_implicit_kontak.setOnClickListener(this);
        btn_implicit_web = (Button) findViewById(R.id.btn_implicit_web);
        btn_implicit_web.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_implicit_kontak:
                Intent implicit_kontak = new Intent(Intent.ACTION_PICK);
                implicit_kontak.setType(ContactsContract.Contacts.CONTENT_TYPE);
                if (implicit_kontak.resolveActivity(getPackageManager()) != null) {
                    startActivity(implicit_kontak);
                }
                break;
            case R.id.btn_implicit_web:
                Intent implicit_web = new Intent(Intent.ACTION_VIEW, Uri.parse("https://uinsgd.ac.id"));
                if (implicit_web.resolveActivity(getPackageManager()) != null) {
                    startActivity(implicit_web);
                }
                break;
            default:
                break;
        }
    }
}
