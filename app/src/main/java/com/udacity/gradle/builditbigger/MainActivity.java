package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.chefmic.joketeller.TellJokeActivity;
import com.chefmic.myapplication.backend.myApi.MyApi;

public class MainActivity extends AppCompatActivity implements FetchJokeAsyncTask.LoadJokeCallback {

    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = (ProgressBar) findViewById(R.id.joke_progress_bar);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        if (progressBar.getVisibility() == View.VISIBLE) {
            return;
        }
        FetchJokeAsyncTask task = new FetchJokeAsyncTask(this);
        task.execute((Void) null);
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void onJokeLoaded(String joke) {
        Intent intent = new Intent(MainActivity.this, TellJokeActivity.class);
        intent.putExtra(TellJokeActivity.JOKE, joke);
        startActivity(intent);
        progressBar.setVisibility(View.GONE);
    }
}
