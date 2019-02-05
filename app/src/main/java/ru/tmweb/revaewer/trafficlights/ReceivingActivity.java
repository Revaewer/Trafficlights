package ru.tmweb.revaewer.trafficlights;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ReceivingActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiving);

        // По умолчанию
        String uFrom = "Обезьянка";
        String uFor = "Вам";
        String uDesc = "так что будьте внимательны";

        // Получение данных из другой активности
        if (getIntent().getStringExtra("uFrom").length () != 0) {uFrom = getIntent().getStringExtra("uFrom");}
        if (getIntent().getStringExtra("uFor").length () != 0) {uFor = getIntent().getStringExtra("uFor");}
        if (getIntent().getStringExtra("uDesc").length () != 0) {uDesc = getIntent().getStringExtra("uDesc");}


        TextView infoTextViewUFrom = findViewById(R.id.TextViewUFrom);
        TextView infoTextViewUFor = findViewById(R.id.TextViewUFor);
        TextView infoTextViewUDesc = findViewById(R.id.TextViewUDesc);

        //setText
        infoTextViewUFrom.setText(uFrom);
        infoTextViewUFor.setText(uFor);
        infoTextViewUDesc.setText(uDesc);
    }
}