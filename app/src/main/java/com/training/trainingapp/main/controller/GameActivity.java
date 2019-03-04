package com.training.trainingapp.main.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.training.trainingapp.R;
import com.training.trainingapp.main.model.Question;
import com.training.trainingapp.main.model.QuestionBank;

import java.util.Arrays;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mQuestionText;
    private Button mAnswerButton1;
    private Button mAnswerButton2;
    private Button mAnswerButton3;
    private Button mAnswerButton4;
    private QuestionBank mQuestionBank;
    private Question mCurrentQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        mQuestionText = findViewById(R.id.activity_game_question_text);
        mAnswerButton1 = findViewById(R.id.activity_game_answer1_btn);
        mAnswerButton2 = findViewById(R.id.activity_game_answer2_btn);
        mAnswerButton3 = findViewById(R.id.activity_game_answer3_btn);
        mAnswerButton4 = findViewById(R.id.activity_game_answer4_btn);

        mQuestionBank = this.generateQuestions();
        mCurrentQuestion = mQuestionBank.getQuestion();
        this.displayQuestion(mCurrentQuestion);

        mAnswerButton1.setTag(0);
        mAnswerButton2.setTag(1);
        mAnswerButton3.setTag(2);
        mAnswerButton4.setTag(3);

        mAnswerButton1.setOnClickListener(this);
        mAnswerButton2.setOnClickListener(this);
        mAnswerButton3.setOnClickListener(this);
        mAnswerButton4.setOnClickListener(this);
    }

    public QuestionBank generateQuestions()
    {
        Question question1 = new Question("Who is the creator of Android?",
                Arrays.asList("Andy Rubin",
                        "Steve Wozniak",
                        "Jake Wharton",
                        "Paul Smith"),
                0);

        Question question2 = new Question("When did the first man land on the moon?",
                Arrays.asList("1958",
                        "1962",
                        "1967",
                        "1969"),
                3);

        Question question3 = new Question("What is the house number of The Simpsons?",
                Arrays.asList("42",
                        "101",
                        "666",
                        "742"),
                3);

        return new QuestionBank(Arrays.asList(question1,
                question2,
                question3));
    }

    private void displayQuestion(final Question question)
    {
        mQuestionText.setText(mCurrentQuestion.getQuestion());
        mAnswerButton1.setText(mCurrentQuestion.getChoiceList().get(0));
        mAnswerButton2.setText(mCurrentQuestion.getChoiceList().get(1));
        mAnswerButton3.setText(mCurrentQuestion.getChoiceList().get(2));
        mAnswerButton4.setText(mCurrentQuestion.getChoiceList().get(3));
    }

    @Override
    public void onClick(View v) {

        if((int)v.getTag() == mCurrentQuestion.getAnswerIndex())
        {
            Toast.makeText(this, "Correct !", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "Wrong !", Toast.LENGTH_SHORT).show();
        }
    }
}
