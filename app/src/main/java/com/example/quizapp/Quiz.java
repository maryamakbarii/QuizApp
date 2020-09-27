package com.example.quizapp;

public class Quiz {
private int answerID;
private boolean answerTrue;

    public Quiz(int answerID, boolean answerTrue) {
        this.answerID = answerID;
        this.answerTrue = answerTrue;
    }

    public int getAnswerID() {
        return answerID;
    }

    public void setAnswerID(int answerID) {
        this.answerID = answerID;
    }

    public boolean isAnswerTrue() {
        return answerTrue;
    }

    public void setAnswerTrue(boolean answerTrue) {
        this.answerTrue = answerTrue;
    }
}
