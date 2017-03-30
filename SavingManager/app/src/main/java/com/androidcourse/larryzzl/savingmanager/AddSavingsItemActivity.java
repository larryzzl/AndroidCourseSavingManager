package com.androidcourse.larryzzl.savingmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddSavingsItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_savings_item);

        setupUI();
    }

    private void setupUI() {

        EditText editBank = (EditText)findViewById(R.id.editBank);
        editBank.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(AddSavingsItemActivity.this, "Input Bank", Toast.LENGTH_LONG).show();
            }
        });

        EditText editStartDate = (EditText)findViewById(R.id.editStartDate);
        editStartDate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(AddSavingsItemActivity.this, "Input StartDate", Toast.LENGTH_LONG).show();
            }
        });

        EditText editEndDate = (EditText)findViewById(R.id.editEndDate);
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
