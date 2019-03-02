package ru.tmweb.revaewer.trafficlights;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        // ActionBar supported
                ActionBar actionBar = getSupportActionBar ();
                assert actionBar != null;

                // setTitle in ActionBar
                // actionBar.setTitle (getString (R.string.title_activity) );

                // Add back button in actionBar
                actionBar.setDisplayHomeAsUpEnabled (true);
                actionBar.setDisplayShowHomeEnabled (true);
    }

    // ActionBar BackButton onBackPressed
    public boolean onSupportNavigateUp() {
            onBackPressed ();
            return true;
        }
}
