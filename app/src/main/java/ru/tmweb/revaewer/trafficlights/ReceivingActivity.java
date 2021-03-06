package ru.tmweb.revaewer.trafficlights;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import ru.tmweb.revaewer.trafficlights.data.TrafficContract.GuestEntry;
import ru.tmweb.revaewer.trafficlights.data.TrafficDbHelper;

public class ReceivingActivity extends AppCompatActivity {

    private TrafficDbHelper mDbHelper;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Set PORTRAIT orientation for this Activity
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiving);

        // ActionBar supported
        ActionBar actionBar = getSupportActionBar ();
        assert actionBar != null;

        // setTitle in ActionBar
        actionBar.setTitle (getString (R.string.title_recevity));

        // Add back button in actionBar
        actionBar.setDisplayHomeAsUpEnabled (true);
        actionBar.setDisplayShowHomeEnabled (true);


        // FloatingActionButton для вызова фармы
        FloatingActionButton fab = findViewById (R.id.fab);
        fab.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (ReceivingActivity.this, SecondActivity.class);
                startActivity (intent);
            }
        });

        mDbHelper = new TrafficDbHelper (this);

    }

    @Override
    protected void onStart() {
        super.onStart ();
        displayDatabaseInfo();
    }

    private void displayDatabaseInfo() {
        // Создание и открытие для чтения базу данных
        SQLiteDatabase db = mDbHelper.getReadableDatabase ();

        // Условие для выборки - список столбцов
        String[] projection = {
                GuestEntry._ID,
                GuestEntry.COLUMN_NAME,
                GuestEntry.COLUMN_CITY,
                GuestEntry.COLUMN_GENDER,
                GuestEntry.COLUMN_AGE
        };

        // Запрос
        Cursor cursor = db.query (
                GuestEntry.TABLE_NAME,  // Таблица
                projection,             // Столбцы
                null,          // Столбцы для условия WHERE
                null,      // Значение для условия WHERE
                null,          // Don't group the rows
                null,           // Don't filter by row groups
                null            // Порядок сортировки
        );

        TextView displayTextView = findViewById (R.id.textViewRecevityInfo);


        try{
            displayTextView.setText ("Таблица содердит " + cursor.getCount () + " Гостей\n\n");
            displayTextView.append (GuestEntry._ID + " - " +
                    GuestEntry.COLUMN_NAME + " - " +
                    GuestEntry.COLUMN_CITY + " - " +
                    GuestEntry.COLUMN_GENDER + " - " +
                    GuestEntry.COLUMN_AGE + "\n"
            );

            // Индексы столбцов
            int idColumnIndex = cursor.getColumnIndex (GuestEntry._ID);
            int nameColumnIndex = cursor.getColumnIndex (GuestEntry.COLUMN_NAME);
            int cityColumnIndex = cursor.getColumnIndex (GuestEntry.COLUMN_CITY);
            int genderColumnIndex = cursor.getColumnIndex (GuestEntry.COLUMN_GENDER);
            int ageColumnIndex = cursor.getColumnIndex (GuestEntry.COLUMN_AGE);

            // Проход по всем рядам
            while (cursor.moveToNext ()) {
                // Использование индекса для получения строки или числа
                int currentID = cursor.getInt (idColumnIndex);
                String currentName = cursor.getString (nameColumnIndex);
                String currentCity = cursor.getString (cityColumnIndex);
                int currentGender = cursor.getInt (genderColumnIndex);
                int currentAge = cursor.getInt (ageColumnIndex);

                // вывод на экран
                displayTextView.append ("\n" + currentID + " - " +
                        currentName + " - " +
                        currentCity + " - " +
                        currentGender + " - " +
                        currentAge);
            }

        } finally {
            // Закрытие курсора после чтения
            cursor.close ();
        }
    }

    // ActionBar BackButton onBackPressed
    public boolean onSupportNavigateUp() {
        onBackPressed ();
        return true;
    }
}