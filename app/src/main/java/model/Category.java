package model;

public class Category {

    private int Id;
    private String language;
    private String category;

    public Category(int id, String language, String category) {
        this.Id = id;
        this.language = language;
        this.category = category;
    }

    public Category(){

    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
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
}
