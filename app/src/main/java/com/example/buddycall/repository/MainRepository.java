package com.example.buddycall.repository;

import com.example.buddycall.Remote.FirebaseClient;
import com.example.buddycall.utils.SuccessCallBack;

public class MainRepository {

    private FirebaseClient firebaseClient;
    private String currentUsername;
    private static MainRepository instance;

    private MainRepository() {
        // Initialize FirebaseClient here
        firebaseClient = new FirebaseClient();
    }

    private void updateCurrentUsername(String username) {
        this.currentUsername = username;
    }

    public static MainRepository getInstance() {
        if (instance == null) {
            instance = new MainRepository();
        }
        return instance;
    }

    public void login(String username, SuccessCallBack callback) {
        firebaseClient.login(username, () -> {
            updateCurrentUsername(username);
            callback.onSuccess();
        });
    }
}
