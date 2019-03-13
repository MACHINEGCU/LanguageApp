package model;

public class Question {

    private int id;
    private String language;
    private String category;
    private String question;
    private String answer;
    private String subAnswer;
    private String additionalInfoOne;
    private String additionalInfoTwo;
    private String additionalInfoThree;

    public Question() { }

    public Question(int id, String language, String category, String question) {
        this.id = id;
        this.language = language;
        this.category = category;
        this.question = question;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public String getSubAnswer() {
        return subAnswer;
    }

    public void setSubAnswer(String subAnswer) {
        this.subAnswer = subAnswer;
    }

    public String getAdditionalInfoOne() {
        return additionalInfoOne;
    }

    public void setAdditionalInfoOne(String additionalInfoOne) {
        this.additionalInfoOne = additionalInfoOne;
    }

    public String getAdditionalInfoTwo() {
        return additionalInfoTwo;
    }

    public void setAdditionalInfoTwo(String additionalInfoTwo) {
        this.additionalInfoTwo = additionalInfoTwo;
    }

    public String getAdditionalInfoThree() {
        return additionalInfoThree;
    }

    public void setAdditionalInfoThree(String additionalInfoThree) {
        this.additionalInfoThree = additionalInfoThree;
    }

    public String getAdditionalInfoFour() {
        return additionalInfoFour;
    }

    public void setAdditionalInfoFour(String additionalInfoFour) {
        this.additionalInfoFour = additionalInfoFour;
    }

    private String additionalInfoFour;
}
