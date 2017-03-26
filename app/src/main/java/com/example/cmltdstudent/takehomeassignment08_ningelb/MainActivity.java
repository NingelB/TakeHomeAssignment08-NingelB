package com.example.cmltdstudent.takehomeassignment08_ningelb;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference titleRef = database.getReference("Title");
    private DatabaseReference foodRef = database.getReference("Food");

    private TextView title;
    private TextView foodName;
    private TextView calories;
    private CheckBox healthy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = (TextView) findViewById(R.id.title);
        foodName = (TextView) findViewById(R.id.foodName);
        calories = (TextView) findViewById(R.id.calories);
        healthy = (CheckBox) findViewById(R.id.healthy);
    }

    // onClick
    public void set(View view)
    {

        titleRef.setValue(title.getText().toString());

    }

    public void add(View view)
    {
        String n =foodName.getText().toString();
        int p=Integer.parseInt(calories.getText().toString());
        boolean s=((CheckBox) findViewById(R.id.healthy)).isChecked();
        foodRef.push().setValue(new Food (n,p,s));
    }
}