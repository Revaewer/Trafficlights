package ru.tmweb.revaewer.trafficlights;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText userEditText;
    private EditText descEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        EditText editTextWhom = findViewById(R.id.edit_text_whom);
        EditText editTextDesc = findViewById(R.id.edit_text_desc);
        final Button btnSend = findViewById(R.id.btn_send);

        btnSend.setOnClickListener (this);

    }

    //*
    public void onClick(View v){
        switch (v.getId()) {
            case R.id.btn_send:
                //*
                userEditText = findViewById(R.id.edit_text_whom);
                descEditText = findViewById(R.id.edit_text_desc);
                //*/
                Intent ReceivingStartActivity = new Intent(SecondActivity.this, ReceivingActivity.class);
                //*
                ReceivingStartActivity.putExtra("username", userEditText.getText().toString());
                ReceivingStartActivity.putExtra("gift", descEditText.getText().toString());
                //*/
                startActivity(ReceivingStartActivity);
            break;
        }

    }


    //*/

}
