package com.example.prayerlearner1;

public class QaModelClass {
    String scholarname,username,question,answer,questime,anstime;

    public String getScholarname() {
        return scholarname;
    }

    public void setScholarname(String scholarname) {
        this.scholarname = scholarname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getQuestime() {
        return questime;
    }

    public void setQuestime(String questime) {
        this.questime = questime;
    }

    public String getAnstime() {
        return anstime;
    }

    public void setAnstime(String anstime) {
        this.anstime = anstime;
    }

    public QaModelClass() {
    }

    public QaModelClass(String scholarname, String username, String question, String answer, String questime, String anstime) {
        this.scholarname = scholarname;
        this.username = username;
        this.question = question;
        this.answer = answer;
        this.questime = questime;
        this.anstime = anstime;
    }
}
