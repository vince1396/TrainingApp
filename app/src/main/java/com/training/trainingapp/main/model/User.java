package com.training.trainingapp.main.model;

public class User {

    private String mFirstName;
    private int mScore;


    public int getScore()
    {
        return mScore;
    }

    public void setScore(int mScore)
    {
        this.mScore = mScore;
    }

    public String getFirstName()

    {
        return mFirstName;
    }

    public void setFirstName(String firstName)

    {
        mFirstName = firstName;
    }
}
