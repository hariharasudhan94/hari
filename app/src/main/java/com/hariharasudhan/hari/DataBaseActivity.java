package com.hariharasudhan.hari;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DataBaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_base);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String name = extras.getString(AddUserActivity.userName);
        String age = extras.getString(AddUserActivity.userAge);
        String gender = extras.getString(AddUserActivity.userGender);
        String dob = extras.getString(AddUserActivity.userDob);
        TextView textView = new TextView(this);
        textView.setText(name);

        TextView textView2 = new TextView(this);
        textView.setText(age);

        TextView textView3 = new TextView(this);
        textView.setText(gender);

        TextView textView4 = new TextView(this);
        textView.setText(dob);

        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.activity_data_base);
        viewGroup.addView(textView);
        viewGroup.addView(textView2);
        viewGroup.addView(textView3);
        viewGroup.addView(textView4);
    }
}
