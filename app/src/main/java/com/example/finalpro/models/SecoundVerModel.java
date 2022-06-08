package com.example.finalpro.models;

public class SecoundVerModel {

    int img;
    String name;
    String description;
    String rating;
    String timing;

    public SecoundVerModel(int img, String name, String description, String rating, String timing) {
        this.img = img;
        this.name = name;
        this.description = description;
        this.rating = rating;
        this.timing = timing;
    }


    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getTiming() {
        return timing;
    }

    public void setTiming(String timing) {
        this.timing = timing;
    }
}
