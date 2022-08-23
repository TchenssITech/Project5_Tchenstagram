package com.tchenssitech.jtchenjiny.tchenstagram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignupActivity extends AppCompatActivity {

    public static final String TAG = "SignUpActivity";
    private TextView tvNewAccount;
    private EditText etEmail;
    private EditText etNewUsername;
    private EditText etNewPass;
    private Button btnSignup;
    private TextView tvCancel;
    private Button btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        tvNewAccount = findViewById(R.id.tvNewAccount);
        etEmail = findViewById(R.id.etEmail);
        etNewUsername = findViewById(R.id.etNewUsername);
        etNewPass = findViewById(R.id.etNewPass);
        btnSignup = findViewById(R.id.btnSignUp);
        tvCancel = findViewById(R.id.tvCancel);
        btnCancel = findViewById(R.id.btnCancel);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG,"onClick SignUp button");
                String email = etEmail.getText().toString();
                String username = etNewUsername.getText().toString();
                String password = etNewPass.getText().toString();
                signUpUser(email, username,password);



            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG,"onClick SignUp button");
                startActivity(new Intent(SignupActivity.this, LoginActivity.class));
            }
        });


    }



    private void signUpUser(String email, String username, String password) {
        Log.i(TAG,"Attempting to signup user"+username);
        ParseUser user = new ParseUser();
        // Set core properties
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);

        // Invoke signUpInBackground
        user.signUpInBackground(new SignUpCallback() {
            public void done(ParseException e) {
                if (e == null) {
                    // Hooray! Let them use the app now, if sign-up properly.
                    Log.i(TAG, "User Sign up success" );
                    goMainActivity();
                    Toast.makeText(SignupActivity.this, "SignUp Success!", Toast.LENGTH_SHORT).show();

                } else {
                    // Sign up didn't succeed. Look at the ParseException
                    Log.e(TAG, "Error signing up new User ", e);
                    Toast.makeText(SignupActivity.this, "Error signing up ", Toast.LENGTH_SHORT).show();
                    // to figure out what went wrong
                }
            }
        });


    }
    private void goMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

}