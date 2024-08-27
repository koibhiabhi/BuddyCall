package com.example.buddycall.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.buddycall.databinding.ActivityCallBinding;

public class Call extends AppCompatActivity {

    ActivityCallBinding views;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        views = ActivityCallBinding.inflate(getLayoutInflater());
        setContentView(views.getRoot());
        init();
    }

    private void init(){
        // Initialize views and set up any necessary listeners
        // Example:
        // views.someButton.setOnClickListener(new View.OnClickListener() {
        //     @Override
        //     public void onClick(View v) {
        //         // Handle button click
        //     }
        // });
    }
}
