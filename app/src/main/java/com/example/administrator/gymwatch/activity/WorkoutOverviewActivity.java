package com.example.administrator.gymwatch.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.administrator.gymwatch.R;
import com.example.administrator.gymwatch.data.Exercise;
import com.example.administrator.gymwatch.data.Workout;

/**
 * Details of one Workout
 */
public class WorkoutOverviewActivity extends Activity {

    private String[] data;

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_overview);

        final int index = getIntent().getIntExtra("WO_NAME", 0);
        Workout workout = Workout.getWorkouts().get(index);

        if (workout.getExercises() != null && workout.getExercises().size() > 0) {

            data = new String[workout.getExercises().size()];

            int i = 0;
            for (Exercise e : workout.getExercises()) {
                data[i++] = e.getName() + " | Weight: " + e.getWeight() + "kg" + " | Reps: " + e.getReps();
            }

//List
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, data);

            // Adapter
            ListView listView = (ListView) findViewById(R.id.exerciseView);
            listView.setAdapter(adapter);


            FloatingActionButton fab = findViewById(R.id.add_exercise_btn);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent myIntent = new Intent(WorkoutOverviewActivity.this, ExerciseCreationActivity.class);
                    myIntent.putExtra("WO_NAME", index);
                    startActivity(myIntent);
                }
            });
        }
    }
}