package com.chefmic.joketeller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class TellJokeActivity extends AppCompatActivity {

    public static final String JOKE = "joke";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tell_joke);

        if (getIntent() != null) {
            String joke = getIntent().getStringExtra(JOKE);
            ((TextView) findViewById(R.id.joke)).setText(joke);
        }
    }
}
