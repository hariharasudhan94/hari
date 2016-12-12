package com.hariharasudhan.hari;

import android.app.DatePickerDialog;
import android.app.Dialog;
//import android.app.DialogFragment;
import android.support.v4.app.DialogFragment;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

public class AddUserActivity extends AppCompatActivity {


    public final static String userName = "hk";

    public static String userAge = "";

    public static String userGender = "";

    public static String userDob = "";


    public static EditText selectedDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        selectedDate = (EditText) findViewById(R.id.user_dob);

        Spinner userGender = (Spinner) findViewById(R.id.user_gender);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.user_gender, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        userGender.setAdapter(adapter);

        Button userAddButton = (Button) findViewById(R.id.add_user_button);
        userAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText user_name = (EditText) findViewById(R.id.user_name);
                EditText user_age = (EditText) findViewById(R.id.user_age);
                Spinner user_gender = (Spinner) findViewById(R.id.user_gender);
                EditText user_dob = (EditText) findViewById(R.id.user_dob);
                Bundle bundle = new Bundle();
                Intent intent = new Intent(AddUserActivity.this, DataBaseActivity.class);
                bundle.putString(AddUserActivity.userName, user_name.getText().toString());
                bundle.putString(AddUserActivity.userAge, user_age.getText().toString());
                bundle.putString(AddUserActivity.userGender, user_gender.getSelectedItem().toString());
                bundle.putString(AddUserActivity.userDob, user_dob.getText().toString());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }


    public static class DataPickerFragment extends DialogFragment
                                            implements DatePickerDialog.OnDateSetListener{

        @RequiresApi(api = Build.VERSION_CODES.N)
        public Dialog onCreateDialog(Bundle savedInstanceState)
        {
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int date = c.get(Calendar.DAY_OF_MONTH);

            return new DatePickerDialog(getActivity(), this, year, month, date);
        }

        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                selectedDate.setText(String.valueOf(year) + "/" + String.valueOf(month + 1) + "/" + String.valueOf(dayOfMonth));
        }
    }



    public void showDatePickerDialog(View v)
    {
        DialogFragment fragment = new DataPickerFragment();
        fragment.show(getSupportFragmentManager(),"datePicker");
    }
}
