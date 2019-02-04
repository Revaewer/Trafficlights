package ru.tmweb.revaewer.trafficlights;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ReceivingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiving);

        // По умолчанию
        String user = "Животные"; String gift = "дырки от бублика";

        // Получение данных из другой активности
        user = getIntent ().getExtras ().getString ("username");
        gift = getIntent ().getExtras ().getString ("gift");

        TextView infoReceivingTextView = findViewById(R.id.infoReceivingTextView);
        infoReceivingTextView.setText(user + " , вам передали " + gift);
    }
}
