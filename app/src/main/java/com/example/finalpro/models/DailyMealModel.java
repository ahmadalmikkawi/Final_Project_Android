package com.example.finalpro.models;

public class DailyMealModel {

    int img;
    String name;
    String discount;
    String description;
    String type;


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

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DailyMealModel(int img, String name, String discount, String description, String type) {
        this.img = img;
        this.name = name;
        this.discount = discount;
        this.description = description;
        this.type = type;
    }

    public DailyMealModel(int img, String name, String discount, String description) {
        this.img = img;
        this.name = name;
        this.discount = discount;
        this.description = description;



    }
}
