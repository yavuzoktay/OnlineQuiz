package com.yavuzoktay.onlinequizz.Model;

/**
 * Created by Yavuz on 30.9.2017.
 */

public class QuesitonScore {
    private String Question_Score;
    private String User ;
    private  String Score ;


    public QuesitonScore() {
    }

    public QuesitonScore(String question_Score, String user, String score) {
        Question_Score = question_Score;
        User = user;
        Score = score;
    }

    public String getQuestion_Score() {
        return Question_Score;
    }

    public void setQuestion_Score(String question_Score) {
        Question_Score = question_Score;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String user) {
        User = user;
    }

    public String getScore() {
        return Score;
    }

    public void setScore(String score) {
        Score = score;
    }
}

