package com.training.trainingapp.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.training.trainingapp.R;

public class GameActivity extends AppCompatActivity {

    private TextView questionText;
    private Button answer1Button;
    private Button answer2Button;
    private Button answer3Button;
    private Button answer4Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        questionText = findViewById(R.id.activity_game_question_text);
        answer1Button = findViewById(R.id.activity_game_answer1_btn);
        answer2Button = findViewById(R.id.activity_game_answer2_btn);
        answer3Button = findViewById(R.id.activity_game_answer3_btn);
        answer4Button = findViewById(R.id.activity_game_answer4_btn);


    }
}
