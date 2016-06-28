package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;

import com.chefmic.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

/**
 * Created by chenyuan on 6/27/16.
 */
public class FetchJokeAsyncTask extends AsyncTask<Void, Void, String> {

    interface LoadJokeCallback {

        void onJokeLoaded(String joke);

    }

    private LoadJokeCallback callback;

    private static MyApi myApiService;

    public FetchJokeAsyncTask(LoadJokeCallback callback) {
        this.callback = callback;
    }

    @Override
    protected String doInBackground(Void... params) {
        if (myApiService == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myApiService = builder.build();
        }
        try {
            return myApiService.getJoke().execute().getData();
        } catch (Exception e) {
            return "";
        }
    }

    @Override
    protected void onPostExecute(String s) {
        if (callback != null) {
            callback.onJokeLoaded(s);
        }
    }
}
