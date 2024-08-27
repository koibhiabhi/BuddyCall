package com.example.buddycall.UI;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.buddycall.databinding.ActivityLoginBinding;
import com.example.buddycall.repository.MainRepository;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;


public class login extends AppCompatActivity {

    ActivityLoginBinding views;

    private MainRepository mainRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        views = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(views.getRoot());

        init();
    }

    private void init(){

        mainRepository = MainRepository.getInstance();
        views.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Login to Firebase

                // Create a Map to store user data
                Map<String, Object> userData = new HashMap<>();
                userData.put("username", views.usernameed.getText().toString());
                // You can put other user data in this map as needed

                mainRepository.login(
                        views.usernameed.getText().toString(), ()->{
                            // Store user data in Firebase
                            DatabaseReference usersRef = FirebaseDatabase.getInstance().getReference("users");
                            usersRef.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(userData)
                                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void aVoid) {
                                            // If data stored successfully, move to Call activity
                                            startActivity(new Intent(login.this, Call.class));
                                        }
                                    })
                                    .addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            // Handle failure
                                            Toast.makeText(login.this, "Failed to store user data: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                                        }
                                    });
                        }
                );
            }
        });
    }
}
