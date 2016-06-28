package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;
/**
 * Created by chenyuan on 6/27/16.
 */
public class AsynTaskTest extends AndroidTestCase {

    public void testFetchJokeAsyncTask() throws InterruptedException {
        FetchJokeAsyncTask task = new FetchJokeAsyncTask(new FetchJokeAsyncTask.LoadJokeCallback() {
            @Override
            public void onJokeLoaded(String joke) {
                assertNotNull(joke);
            }
        });
        task.execute((Void) null);
    }
}
