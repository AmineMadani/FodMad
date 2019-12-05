package com.fodmad.newsapp.models;

public class ListCategory {

    private String title;
    private String description;
    private int images;
    String catName;

    public ListCategory(String title, String description, int images, String catName){
        this.title=title;
        this.description=description;
        this.images=images;
        this.catName=catName;
    }


    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getImages() {
        return images;
    }

    public String getCatName() {
        return catName;
    }
}
