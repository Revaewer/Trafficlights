package ru.tmweb.revaewer.trafficlights;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //Send form SecondActivity btn_sent - OnClickListener
        final Button btnSend = findViewById(R.id.btnSend);
        btnSend.setOnClickListener (this);

    }

    public void onClick(View v){
        switch (v.getId()) {
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
        }

    }

}