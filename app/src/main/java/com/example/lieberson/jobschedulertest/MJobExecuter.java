package com.example.lieberson.jobschedulertest;

import android.os.AsyncTask;

public class MJobExecuter extends AsyncTask<Void, Void, String>{

    @Override
    protected String doInBackground(Void... voids) {

        return "Background Long Running Task Finishes...";
    }
}
