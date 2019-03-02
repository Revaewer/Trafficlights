package ru.tmweb.revaewer.trafficlights.data;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import ru.tmweb.revaewer.trafficlights.data.TrafficContract.GuestEntry;

public class TrafficDbHelper extends SQLiteOpenHelper {

    public final static String LOG_TAG = TrafficDbHelper.class.getSimpleName ();

    /**
    * Имя файла базы данных
    */
    private static final String DATABASE_NAME = "traffic.db";

    /**
    * Версия базы данных. При изменении схемы увеличить единицу.
    */
    private static final int DATABASE_VERSION = 1;

    /**
     * Конструктор {@link TrafficDbHelper}.
     *
     * @param context Контекст приложения
     */
    public TrafficDbHelper (Context context) {
        super (context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * Вызывается при создании базы данных
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Строка для создании таблицы
        String SQL_CREATE_GUEST_TABLE = "CREATE TABLE " + GuestEntry.TABLE_NAME + " ("
                + GuestEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + GuestEntry.COLUMN_NAME + " TEXT NOT NULL, "
                + GuestEntry.COLUMN_CITY + " TEXT NOT NULL, "
                + GuestEntry.COLUMN_GENDER + " INTEGER NOT NULL DEFAULT 3, "
                + GuestEntry.COLUMN_AGE + " INTEGER NOT NULL DEFAULT 0); ";

        // Запуск создания таблицы
        db.execSQL (SQL_CREATE_GUEST_TABLE);
    }

    /**
     * Вызывается при обновлении схемы базы данных
     */

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Запись в журнал
        Log.w ("SQLite", "Update from version " + oldVersion + " On Version " + newVersion);

        // Удаление старой таблицы и создание новой
//        db.execSQL ("DROP TABLE IF IT EXISTS " + DATABASE_TABLE);

        // Создание новой таблицы
        onCreate (db);
    }
}
