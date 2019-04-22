package model;

public class Answer {

    private String question;
    private String answerDescription;
    private String subTitle;

    public Answer() { }

    public Answer(String question,  String answerDescription) {
        this.question = question;
        this.answerDescription = answerDescription;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswerDescription() {
        return answerDescription;
    }

    public void setAnswerDescription(String answerDescription) {
        this.answerDescription = answerDescription;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

}
