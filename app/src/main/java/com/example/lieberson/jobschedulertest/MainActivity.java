package com.example.lieberson.jobschedulertest;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button botaoSchedulerJob;
    private Button botaoClearJob;

    private static final int JOB_ID = 101;
    private JobScheduler jobScheduler;
    private JobInfo jobInfo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        botaoSchedulerJob = findViewById(R.id.btnSchedulerJob);
        botaoClearJob = findViewById(R.id.btnClearJob);

        ComponentName componentName = new ComponentName(this, MJobScheduler.class);
        JobInfo.Builder builder = new JobInfo.Builder(JOB_ID, componentName);

        builder.setPeriodic(5000);
        builder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY);
        builder.setPersisted(true);

        jobInfo = builder.build();
        jobScheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);

        botaoSchedulerJob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                jobScheduler.schedule(jobInfo);
                Toast.makeText(getApplicationContext(), "Job Scheduled...", Toast.LENGTH_SHORT).show();

            }
        });


        botaoClearJob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                jobScheduler.cancel(JOB_ID);
                Toast.makeText(getApplicationContext(), "Job Canceled...", Toast.LENGTH_SHORT).show();

            }
        });

    }
}
