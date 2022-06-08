package com.example.finalpro.models;

public class HomeVerModel {
    int img;
    String name;
    String timing;
    String rating;
    String price;

    public HomeVerModel(int img, String name, String timing, String rating, String price) {
        this.img = img;
        this.name = name;
        this.timing = timing;
        this.rating = rating;
        this.price = price;
    }

    public HomeVerModel() {
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

    public String getTiming() {
        return timing;
    }

    public void setTiming(String timing) {
        this.timing = timing;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
