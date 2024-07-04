package com.example.myassignment3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        auth = FirebaseAuth.getInstance();

        // Assuming you have email and password from your input fields
        String email = "user@example.com"; // Replace with your actual email input
        String password = "password123"; // Replace with your actual password input

        signInUser(email, password);
    }

    private void signInUser(String email, String password) {
        auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // User signed in successfully
                            Intent intent = new Intent(MainActivity.this, DashboardActivity.class);
                            startActivity(intent);
                            finish(); // Finish current activity so user can't go back to it
                        } else {
                            // Handle sign-in failure
                            String errorCode = task.getException().getMessage();
                            Toast.makeText(MainActivity.this, "Sign-in failed: " + errorCode, Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
}
