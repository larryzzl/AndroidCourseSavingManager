package com.androidcourse.larryzzl.savingmanager;

import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

public class AddSavingsItemActivity extends AppCompatActivity {

    int year;
    int month;
    int day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_savings_item);

        Calendar calendar = Calendar.getInstance();
        AddSavingsItemActivity.this.year = calendar.get(Calendar.YEAR);
        AddSavingsItemActivity.this.month = calendar.get(Calendar.MONTH);
        AddSavingsItemActivity.this.day = calendar.get(Calendar.DAY_OF_MONTH);

        setupUI();
    }

    private void updateStartDate(int year, int monthOfYear, int dayOfMonth) {
        EditText editStartDate = (EditText)findViewById(R.id.editStartDate);
        editStartDate.setText(year + "-" + monthOfYear + "-" + dayOfMonth);
    }

    private void updateEndDate(int year, int monthOfYear, int dayOfMonth) {
        EditText editEndDate = (EditText)findViewById(R.id.editEndDate);
        editEndDate.setText(year + "-" + monthOfYear + "-" + dayOfMonth);
    }


    private void setupUI() {

        EditText editBank = (EditText)findViewById(R.id.editBank);
        editBank.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(AddSavingsItemActivity.this, "Input Bank", Toast.LENGTH_LONG).show();
            }
        });

        EditText editStartDate = (EditText)findViewById(R.id.editStartDate);
        editStartDate.setInputType(InputType.TYPE_NULL);
        editStartDate.setShowSoftInputOnFocus(false);
        editStartDate.setOnFocusChangeListener(new OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){

                    // Show date picker
                    DatePickerDialog datePicker = new DatePickerDialog(AddSavingsItemActivity.this, new OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                            AddSavingsItemActivity.this.updateStartDate(year, monthOfYear, dayOfMonth);
                        }
                    }, AddSavingsItemActivity.this.year, AddSavingsItemActivity.this.month, AddSavingsItemActivity.this.day);
                    datePicker.show();
                }
            }
        });

        EditText editEndDate = (EditText)findViewById(R.id.editEndDate);
        editEndDate.setInputType(InputType.TYPE_NULL);
        editEndDate.setShowSoftInputOnFocus(false);
        editEndDate.setOnFocusChangeListener(new OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){

                    // Show date picker
                    DatePickerDialog datePicker = new DatePickerDialog(AddSavingsItemActivity.this, new OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                            AddSavingsItemActivity.this.updateEndDate(year, monthOfYear, dayOfMonth);
                        }
                    }, AddSavingsItemActivity.this.year, AddSavingsItemActivity.this.month, AddSavingsItemActivity.this.day);
                    datePicker.show();
                }
            }
        });


        editEndDate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(AddSavingsItemActivity.this, "Input EndDate", Toast.LENGTH_LONG).show();
            }
        });

        EditText editAmount = (EditText)findViewById(R.id.editAmount);
        editAmount.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(AddSavingsItemActivity.this, "Input Amount", Toast.LENGTH_LONG).show();
            }
        });

        EditText editAnnual = (EditText)findViewById(R.id.editAnnual);
        editAnnual.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(AddSavingsItemActivity.this, "Input Annual", Toast.LENGTH_LONG).show();
            }
        });

        EditText editExpected = (EditText)findViewById(R.id.editExpected);
        editExpected.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(AddSavingsItemActivity.this, "Input Expected", Toast.LENGTH_LONG).show();
            }
        });
    }
}
