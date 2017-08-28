package com.mahesh.roomdatabaseexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.mahesh.roomdatabaseexample.Database.AppDatabase;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppDatabase database = AppDatabase.getDatabase(getApplicationContext());
        for (int i = 0; i < 10; i++) {
            Task build = Task.builder().setId(i).setSummary("Testing " + i).setDescription("More ..." + i).build();
            database.taskModel().addTask(build);
        }
        List<Task> allTasks = database.taskModel().getAllTasks();
        TextView textView = (TextView) findViewById(R.id.tvTextview);
        textView.setText(allTasks.toString());
    }

    @Override
    protected void onDestroy() {
        AppDatabase.destroyInstance();
        super.onDestroy();
    }
}
