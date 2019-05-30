package com.example.lesson42;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Intent intent;
    private String message;
    private Bundle extras;
    private EditText _etName, _etAddress, _etPhone, _etNote;
    private TextView _tvOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeViews();
        initializeObjects();
        if(extras != null) {
            message = extras.getString(Main2Activity.EXTRA_MESSAGE);
            _tvOrder.setText(message);
        }


    }

    private void initializeViews() {
        _tvOrder = findViewById(R.id.tvOrder);
        _etName = findViewById(R.id.etName);
        _etAddress = findViewById(R.id.etAddress);
        _etPhone = findViewById(R.id.etPhone);
        _etNote = findViewById(R.id.etNote);
    }

    private void initializeObjects() {
        intent = getIntent();
        extras = intent.getExtras();
    }

    private void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.rdbSameDay:
                if (checked)
                    displayToast(getString(R.string.same_day_messenger_service_label));
                break;
            case R.id.rdbNextDay:
                if (checked)
                    displayToast(getString(R.string.next_day_ground_delivery_label));
                break;
            case R.id.rdbPickUp:
                if (checked)
                    displayToast(getString(R.string.pick_up_label));
                break;
            default:
                break;
        }
    }

}
