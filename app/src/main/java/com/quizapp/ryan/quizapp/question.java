package com.quizapp.ryan.quizapp;

/**
 * Created by ryann on 11/22/2016.
 */

public class question {
    question(int textResId, boolean answerTrue){
        this.mAnswerTrue = answerTrue;
        this.mTextResId  = textResId;
    }

    public int getTextResId(){ return mTextResId;}
    public void setTextResId(int textResId){ this.mTextResId = textResId;}

    public boolean getAnswerTrue(){return this.mAnswerTrue;}
    public void    setAnswerTrue(boolean answerTrue){this.mAnswerTrue = answerTrue;}

    private int mTextResId;
    private boolean mAnswerTrue;
}
