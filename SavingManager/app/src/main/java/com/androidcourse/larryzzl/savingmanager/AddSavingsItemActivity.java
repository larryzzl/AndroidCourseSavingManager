package com.androidcourse.larryzzl.savingmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddSavingsItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_savings_item);

        setupUI();
    }

    private void setupUI() {
        TextView txtBank = (TextView)findViewById(R.id.txtBank);
        EditText editBank = (EditText)findViewById(R.id.editBank);

        editBank.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(AddSavingsItemActivity.this, "Android Simple Toast", Toast.LENGTH_LONG).show();
            }
        });
    }
}
