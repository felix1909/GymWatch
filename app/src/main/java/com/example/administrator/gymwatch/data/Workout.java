package com.example.administrator.gymwatch.data;

import android.icu.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Administrator on 1/25/2018.
 */

public class Workout {

    private static List<Workout> workouts = new ArrayList<>();

    public SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
    //private Date creationDate = new Date();
    private int duration = 50;
    private String name;
    private Calendar creationDate;
    private List<Exercise> exercises = new ArrayList<>();
    private String avg_duration;

    public static List<Workout> getWorkouts() {
        return workouts;
    }

    public static void addWorkout(Workout w) {
        workouts.add(w);
    }

    public static void addWorkouts(List<Workout> newWorkouts) {
        workouts.addAll(newWorkouts);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(String name) {
        this.duration = duration;
    }

    public Calendar getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Calendar creationDate) {
        this.creationDate = creationDate;
    }

    public String getReadableCreationDate() {
        return simpleDateFormat.format(creationDate);
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }

    public void addExercise(Exercise exercise) {
        exercises.add(exercise);
    }

    public int size() {
        return size();
    }
}
