package com.training.trainingapp.main.controller;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.training.trainingapp.R;
import com.training.trainingapp.main.model.User;

public class MainActivity extends AppCompatActivity {

    private TextView mGreetingText;
    private EditText mNameInput;
    private Button mPlayButton;
    private User mUser;
    private static final int GAME_ACTIVITY_REQUEST_CODE = 42;
    private String mGreetings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //Binding View

        // =========================================================================================
        // Binding View content
        mGreetingText = findViewById(R.id.activity_main_greeting_txt);
        mNameInput    = findViewById(R.id.activity_main_name_input);
        mPlayButton   = findViewById(R.id.activity_main_play_btn);
        // =========================================================================================
        mUser = new User(); // Create user
        // =========================================================================================
        // Get user's preferences
        String prefName = getPreferences(MODE_PRIVATE).getString("firstName", null);
        int prefScore = getPreferences(MODE_PRIVATE).getInt("score", 0);

        if(prefName != null)
        {
            mUser.setFirstName(prefName);
            mUser.setScore(prefScore);

            mGreetings = "Welcome back " + mUser.getFirstName() + "\n Score : " + mUser.getScore();
            mGreetingText.setText(mGreetings);

            mNameInput.setText(mUser.getFirstName());
        }
        else
        {
            mGreetings = "Welcome! What's your name ?";
            mGreetingText.setText(mGreetings);
            mPlayButton.setEnabled(false); // Disable Button
        }
        // =========================================================================================

        // =========================================================================================
        // Listening to changing text on the name input
        mNameInput.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                // Enable button when at least 1 char is typed
                mPlayButton.setEnabled(s.toString().length() != 0);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        // =========================================================================================

        // =========================================================================================
        // When play button is hit
        mPlayButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // Update user first name
                mUser.setFirstName(mNameInput.getText().toString());

                // Starting GameActivity
                Intent gameActivity = new Intent(MainActivity.this, GameActivity.class);
                startActivityForResult(gameActivity, GAME_ACTIVITY_REQUEST_CODE);
            }
        });
        // =========================================================================================
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if (GAME_ACTIVITY_REQUEST_CODE == requestCode && RESULT_OK == resultCode)
        {
            // Fetch the score from the Intent
            int score = data.getIntExtra(GameActivity.BUNDLE_EXTRA_SCORE, 0);

            SharedPreferences preferences = getPreferences(MODE_PRIVATE);
            preferences.edit().putString("firstName", mUser.getFirstName()).apply();
            preferences.edit().putInt("score", score).apply();

            String firstName = getPreferences(MODE_PRIVATE).getString("firstName", null);

            mUser.setFirstName(firstName);
            mUser.setScore(score);
            mGreetings = "Welcome back " + mUser.getFirstName() + "\n Score : " + mUser.getScore();

            mGreetingText.setText(mGreetings);
        }
    }
}