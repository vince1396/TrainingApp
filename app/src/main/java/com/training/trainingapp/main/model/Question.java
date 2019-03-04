package com.training.trainingapp.main.model;

import java.util.List;

public class Question {

    private String mQuestion;
    private List<String> mChoiceList;
    private int mAnswerIndex;

    public Question(String Question, List<String> ChoiceList, int AnswerIndex)
    {
        this.setQuestion(Question);
        this.setChoiceList(ChoiceList);
        this.setAnswerIndex(AnswerIndex);
    }

    public String getQuestion()
    {
        return mQuestion;
    }

    public void setQuestion(String question)
    {
        mQuestion = question;
    }

    public List<String> getChoiceList()
    {
        return mChoiceList;
    }

    public void setChoiceList(List<String> choiceList)
    {
        if (choiceList == null)
            throw new IllegalArgumentException("Array cannot be null");

        mChoiceList = choiceList;
    }

    public int getAnswerIndex()
    {
        return mAnswerIndex;
    }

    public void setAnswerIndex(int answerIndex)
    {
        if (answerIndex < 0 || answerIndex >= mChoiceList.size())
            throw new IllegalArgumentException("Answer index is out of bound");

        mAnswerIndex = answerIndex;
    }
}