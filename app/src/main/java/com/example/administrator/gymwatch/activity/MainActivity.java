package com.example.administrator.gymwatch.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.administrator.gymwatch.R;
import com.example.administrator.gymwatch.WorkoutCreationDialogListener;
import com.example.administrator.gymwatch.data.TestUtil;
import com.example.administrator.gymwatch.data.Workout;

/**
 * Entry point of the app
 * Lists all the available workouts
 */
public class MainActivity extends AppCompatActivity implements WorkoutCreationDialogListener {

    private static boolean dataAddedAlready = false;
    private String[] data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Insert test data
        if (!dataAddedAlready) {
            Workout.addWorkouts(TestUtil.createWorkouts());
            dataAddedAlready = true;
        }

        FloatingActionButton fab = findViewById(R.id.add_workout_btn);
        fab.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                new WorkoutCreationDialog().show(getFragmentManager(), "foo");
            }
        });


        //Data
        // Get dummy data from TestUtil
//        List<Workout> workouts = TestUtil.createWorkouts();

        if (Workout.getWorkouts() != null && Workout.getWorkouts().size() > 0) {
            data = new String[Workout.getWorkouts().size()];

            int i = 0;
            for (Workout w : Workout.getWorkouts()) {
                data[i++] = w.getName() + " |" + " ( ͡° ͜ʖ ͡°)  " + " | " + "avg. duration: " + w.getDuration() + "min.";
            }

//List
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, data);

            // Adapter
            ListView listView = (ListView) findViewById(R.id.workoutView);
            listView.setAdapter(adapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Log.d("", "++++++++++++CLICK!!!");


                    Intent myIntent = new Intent(MainActivity.this, WorkoutOverviewActivity.class);
                    myIntent.putExtra("WO_NAME", i);
                    startActivity(myIntent);
                }
            });
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDialogPositiveClick(String woName) {
        saveWorkout(woName);
    }

    @Override
    public void onDialogNegativeClick() {

    }

    /**
     * @param woName the workout to save and add
     */
    private void saveWorkout(String woName) {
        Log.d("", "onClick: saveDialogBtn");
        // 1. use it in my new WO
        Workout w = new Workout();
        w.setName(woName);

        Workout.addWorkout(w);


        // 2. get the name and display it
        Context context = getApplicationContext();
        CharSequence text = "Workout '" + woName + "' added";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        Intent refresh = new Intent(this, MainActivity.class);
        startActivity(refresh);//Start the same Activity
        finish();
    }


}
