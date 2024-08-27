package com.example.buddycall.Remote;

import com.example.buddycall.utils.SuccessCallBack;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseClient {

    private final DatabaseReference dbref = FirebaseDatabase.getInstance().getReference();

    public void login(String username, SuccessCallBack callback){
        dbref.child("users").child(username).setValue(true).addOnSuccessListener(task ->{
            callback.onSuccess();
        }).addOnFailureListener(e -> {

        });
    }

    public void sendmsgtootheruser(){

    }

    public void observeIncomingLatestEvent (){

    }
}
