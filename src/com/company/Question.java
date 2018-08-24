package com.company;

public class Question {

    //nazwa pytania
    private String content;
    private boolean correct;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public Question(String content, boolean correct) {

        this.content = content;
        this.correct = correct;
    }
}
