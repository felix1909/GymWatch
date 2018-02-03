package com.example.administrator.gymwatch.data;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Administrator on 1/25/2018.
 */

public class TestUtil {


    //    List<Exercise> squats;
//    List<Exercise> latzug;
//    List<Exercise> bench_press;
//    List<Exercise> brust;
//    List<Exercise> dips;
//    List<Exercise> curls;
//    List<Exercise> sit_ups;
//    List<Exercise> back;
    public static List<Workout> createWorkouts() {

        List<Workout> workouts = new ArrayList<>();
        workouts.add(createWorkout("Workout 1", Calendar.getInstance(), createExercises()));
        workouts.add(createWorkout("Workout 2", Calendar.getInstance(), createExercises()));
        workouts.add(createWorkout("Workout 3", Calendar.getInstance(), createExercises()));
        return workouts;
    }

    private static List<Exercise> createExercises() {
        List<Exercise> exercises = new ArrayList<>();
        exercises.add(createExercise("squats", 12, 25));
        exercises.add(createExercise("latzug", 12, 25));
        exercises.add(createExercise("dips", 12, 20));
        exercises.add(createExercise("back", 10, 30));
        return exercises;
    }


    private static Exercise createExercise(String name, int reps, float weight) {
        Exercise exercise = new Exercise();
        exercise.setName(name);
        exercise.setReps(reps);
        exercise.setWeight(weight);
        return exercise;
    }

    // Workouts
    public static Workout createWorkout(String name, Calendar creationDate, List<Exercise> exercises) {
        Workout newWorkout = new Workout();
        newWorkout.setName(name);
        newWorkout.setCreationDate(creationDate);
        newWorkout.setExercises(exercises);
        return newWorkout;
    }

}
