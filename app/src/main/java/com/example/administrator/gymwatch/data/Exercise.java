package com.example.administrator.gymwatch.data;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Administrator on 1/25/2018.
 */

public class Exercise {

    private static List<Exercise> exercises = new ArrayList<>();
    private String name;
    private String description;
    private String picture;
    private Calendar date;
    private int reps;
    private float weight;

    public void addExercise(Exercise e) {
        exercises.add(e);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public int get(int wo_index) {
        return wo_index;

    }

    public int size() {
        return size();
    }
}

