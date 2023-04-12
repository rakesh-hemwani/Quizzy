package com.example.quizz;

import android.util.Log;

public class QuizModel {
    private int  mquestions;
    private String manswer;

    public QuizModel(int question,String answer){

        mquestions=question;
        manswer=answer;

    }

    public int getMquestions() {
        return mquestions;
    }

    public void setMquestions(int mquestions) {
        this.mquestions = mquestions;
    }

    public String isManswer() {
        Log.i("bh",manswer);
        return manswer;
    }

    public void setManswer(String manswer) {
        this.manswer = manswer;
    }
}
