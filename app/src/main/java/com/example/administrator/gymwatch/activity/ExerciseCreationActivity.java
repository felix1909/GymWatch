package com.example.administrator.gymwatch.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.gymwatch.R;
import com.example.administrator.gymwatch.data.Exercise;
import com.example.administrator.gymwatch.data.Workout;

/**
 * Details of one Workout
 */
public class ExerciseCreationActivity extends Activity {

    private String[] data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_input);

        int index = getIntent().getIntExtra("WO_NAME", 0);
        final Workout workout = Workout.getWorkouts().get(index);


        FloatingActionButton fab = findViewById(R.id.save_workout_btn);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Exercise exo = new Exercise();

                //Name
                TextView tv = findViewById(R.id.exercise_name_txt);
                exo.setName(tv.getText().toString());
                //Reps
                TextView reps = findViewById(R.id.exercise_reps);
                exo.setReps(Integer.parseInt(reps.getText().toString()));
                //Weight
                TextView weight = findViewById(R.id.exercise_weight);
                exo.setWeight(Float.parseFloat(weight.getText().toString()));
                //Description
                TextView description = findViewById(R.id.exercises_description_txt);
                exo.setDescription(description.getText().toString());
                //Picture
                ImageView pic = findViewById(R.id.ExercisePicture);
                exo.setPicture("TODO: implement pictures...");

                workout.addExercise(exo);
                Log.d("", "*****************CLICKED!");
                Intent myIntent = new Intent(ExerciseCreationActivity.this, WorkoutOverviewActivity.class);
                startActivity(myIntent);
            }
        });
    }
}
