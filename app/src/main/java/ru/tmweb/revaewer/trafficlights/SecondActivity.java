package ru.tmweb.revaewer.trafficlights;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import ru.tmweb.revaewer.trafficlights.data.TrafficContract;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mNameEditText;
    private EditText mCityEditText;
    private EditText mAgeEditText;

    private Spinner mGenderSpinner;

    private int mGender = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Set PORTRAIT orientation for this Activity
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //Send form SecondActivity btn_sent - OnClickListener
        final Button btnSend = findViewById(R.id.btnSend);
        btnSend.setOnClickListener (this);

        // ActionBar supported
        ActionBar actionBar = getSupportActionBar ();
        assert actionBar != null;

        // setTitle in ActionBar
        actionBar.setTitle (getString (R.string.title_seccond) );

        // Add back button in actionBar
        actionBar.setDisplayHomeAsUpEnabled (true);
        actionBar.setDisplayShowHomeEnabled (true);


        mNameEditText = findViewById (R.id.editTextYouName);
        mCityEditText = findViewById (R.id.editTextWhom);
        mAgeEditText = findViewById (R.id.editTextDesc);
        mGenderSpinner = findViewById (R.id.spinner_gender);

        setupSpinner();

    }

    /**
     * Настраиваем spinner для выбора пола у гостя.
     */

    private void setupSpinner() {

        ArrayAdapter genderSpinnerAdapter = ArrayAdapter.createFromResource (this, R.array.array_gender_options, android.R.layout.simple_dropdown_item_1line);

        mGenderSpinner.setAdapter (genderSpinnerAdapter);
        mGenderSpinner.setSelection (2);

        mGenderSpinner.setOnItemSelectedListener (new AdapterView.OnItemSelectedListener () {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selection = (String) parent.getItemAtPosition (position);
                if ( !TextUtils.isEmpty (selection)) {
                    if ( selection.equals (getString (R.string.gender_female)) ) {
//                        mGender = 0; // Кошка
                        mGender = TrafficContract.GuestEntry.GENDER_FEMALE;
                    } else if ( selection.equals (R.string.gender_male) ) {
//                        mGender = 1; // Кот
                        mGender = TrafficContract.GuestEntry.GENDER_MALE;
                    } else {
//                        mGender = 2; // Неизвестно
                        mGender = TrafficContract.GuestEntry.GENDER_UNKNOWN;
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                mGender = 2; // Неизвестно

            }
        });

    }



    public void onClick(View v){
        switch (v.getId()) {
            /*
            case R.id.btnSend:

                EditText uFromEditText = findViewById (R.id.editTextYouName);
                EditText uForEditText = findViewById (R.id.editTextWhom);
                EditText uDescEditText = findViewById (R.id.editTextDesc);

                Intent ReceivingStartActivity = new Intent(SecondActivity.this, ReceivingActivity.class);

                ReceivingStartActivity.putExtra("uFrom", uFromEditText.getText().toString());
                ReceivingStartActivity.putExtra("uFor", uForEditText.getText().toString());
                ReceivingStartActivity.putExtra("uDesc", uDescEditText.getText().toString());

                startActivity(ReceivingStartActivity);
            break;
            //*/
        }

    }


    // ActionBar BackButton onBackPressed
    public boolean onSupportNavigateUp() {
        onBackPressed ();
        return true;
    }

}