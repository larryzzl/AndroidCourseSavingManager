package com.androidcourse.larryzzl.savingmanager;

import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.content.ContentValues;
import android.content.Intent;
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

import java.util.Date;

public class AddSavingsItemActivity extends AppCompatActivity {

    private int year;
    private int month;
    private int day;

    private Calendar mCalendar;
    private Date startDate;
    private Date endDate;
    private float amount;
    private float yield;
    private float interest;

    private EditText editBank;
    private EditText editStartDate;
    private EditText editEndDate;
    private EditText editAmount;
    private EditText editYield;
    private EditText editInterest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_savings_item);

        mCalendar = Calendar.getInstance();
        AddSavingsItemActivity.this.year = mCalendar.get(Calendar.YEAR);
        AddSavingsItemActivity.this.month = mCalendar.get(Calendar.MONTH);
        AddSavingsItemActivity.this.day = mCalendar.get(Calendar.DAY_OF_MONTH);

        setupUI();
    }

    private void updateStartDate(int year, int monthOfYear, int dayOfMonth) {
        mCalendar.set(year, monthOfYear, dayOfMonth);
        Date date = new Date(mCalendar.getTimeInMillis());
        editStartDate.setText(Utils.formatDate(date, "yyyy/MM/dd"));
        startDate = new Date(date.getTime());
    }

    private void updateEndDate(int year, int monthOfYear, int dayOfMonth) {
        mCalendar.set(year, monthOfYear, dayOfMonth);
        Date date = new Date(mCalendar.getTimeInMillis());
        editEndDate.setText(Utils.formatDate(date, "yyyy/MM/dd"));
        endDate = new Date(date.getTime());
    }


    private void setupUI() {

        editBank = (EditText)findViewById(R.id.editBank);
        editBank.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(AddSavingsItemActivity.this, "Input Bank", Toast.LENGTH_LONG).show();
            }
        });

        editStartDate = (EditText)findViewById(R.id.editStartDate);
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
                            updateStartDate(year, monthOfYear, dayOfMonth);
                        }
                    }, mCalendar.get(Calendar.YEAR), mCalendar.get(Calendar.MONTH), mCalendar.get(Calendar.DAY_OF_MONTH));
                    datePicker.show();
                }
            }
        });

        editEndDate = (EditText)findViewById(R.id.editEndDate);
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
                            updateEndDate(year, monthOfYear, dayOfMonth);
                        }
                    }, mCalendar.get(Calendar.YEAR), mCalendar.get(Calendar.MONTH), mCalendar.get(Calendar.DAY_OF_MONTH));
                    datePicker.show();
                }
            }
        });


        editEndDate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(AddSavingsItemActivity.this, "Input EndDate", Toast.LENGTH_LONG).show();
            }
        });

        editAmount = (EditText)findViewById(R.id.editAmount);
        editAmount.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(AddSavingsItemActivity.this, "Input Amount", Toast.LENGTH_LONG).show();
            }
        });

        editYield = (EditText)findViewById(R.id.editAnnual);
        editYield.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(AddSavingsItemActivity.this, "Input Yield", Toast.LENGTH_LONG).show();
            }
        });

        editInterest = (EditText)findViewById(R.id.editExpected);
        editInterest.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(AddSavingsItemActivity.this, "Input Interest", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void onCancelClick(View view) {
        onBackPressed();
    }

    public void onSaveClick(View view) {

        amount = Float.valueOf(editAmount.getText().toString());
        yield = Float.valueOf(editYield.getText().toString());

        //TODO: use a real algorithm to calc interest
        interest = 0.1f;

        ContentValues value = new ContentValues();
        value.put(SavingItemEntry.COLUMN_NAME_BANK_NAME, editBank.getText().toString());
        value.put(SavingItemEntry.COLUMN_NAME_AMOUNT, amount);
        value.put(SavingItemEntry.COLUMN_NAME_AMOUNT, yield);
        value.put(SavingItemEntry.COLUMN_NAME_AMOUNT, interest);
        value.put(SavingItemEntry.COLUMN_NAME_START_DATE, startDate.getTime());
        value.put(SavingItemEntry.COLUMN_NAME_END_DATE, endDate.getTime());

        getContentResolver().insert(SavingContentProvider.CONTENT_URI, value);

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
