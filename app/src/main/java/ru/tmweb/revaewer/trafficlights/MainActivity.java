package ru.tmweb.revaewer.trafficlights;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements OnClickListener {

    private TextView mInfoTextView;
    private ImageButton trafficLightIcon;

    // Double Back to exit
    private static long back_pressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Activity status Information text
        mInfoTextView = findViewById(R.id.mInfoTextView);
        mInfoTextView.setText(R.string.text_view_light_off);

        //Activity Icon Traffic Light
        trafficLightIcon = findViewById(R.id.iBTrafficLight);
        trafficLightIcon.setBackgroundTintList(getResources().getColorStateList(R.color.colorGrey));


        // Обработчик сразу для 3х кнопок. Объявление делается обязательно в методе OnCreate
        final Button redButton = findViewById(R.id.btn_red);
        final Button yellowButton = findViewById(R.id.btn_yellow);
        final Button greenButton = findViewById(R.id.btn_green);

        // устанавливаем один обработчик для всех кнопок
        redButton.setOnClickListener(this);
        yellowButton.setOnClickListener(this);
        greenButton.setOnClickListener(this);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_bar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // получим идентификатор выбранного пункта меню
        int id = item.getItemId();

        switch (id) {
            case R.id.itemMenuActionBarSend:
                //Intent SecondActivity
                Intent SecondStartActivity = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(SecondStartActivity);
                break;
            case R.id.itemMenuActionBarAbout:
                //Intent About Activity
                Intent AboutStartActivity = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(AboutStartActivity);
                break;
                default:
                    return super.onOptionsItemSelected(item);
        }

        return false;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_red:
                mInfoTextView.setText(R.string.red);
                trafficLightIcon.setBackgroundTintList(getResources().getColorStateList(R.color.colorRed));
                break;
            case R.id.btn_yellow:
                mInfoTextView.setText(R.string.yellow);
                trafficLightIcon.setBackgroundTintList(getResources().getColorStateList(R.color.colorYellow));
                break;
            case R.id.btn_green:
                mInfoTextView.setText(R.string.green);
                trafficLightIcon.setBackgroundTintList(getResources().getColorStateList(R.color.colorGreen));
                break;

                default: break;
        }

    }

    // Double Back to exit
    @Override
    public void onBackPressed() {
        if (back_pressed + 2000 > System.currentTimeMillis()) super.onBackPressed();
        else Toast.makeText(getBaseContext(), R.string.toast_to_exit, Toast.LENGTH_SHORT).show();
        back_pressed = System.currentTimeMillis();
    }

    //Intent About Activity
    //Intent AboutStartActivity = new Intent(MainActivity.this, AboutActivity.class);
    //startActivity(AboutStartActivity);
}