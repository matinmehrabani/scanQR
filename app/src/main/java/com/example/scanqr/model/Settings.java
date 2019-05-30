package com.example.scanqr.model;

public class Settings {

    private String title;
private int type;
private int image;
private String name;
public static final int ONE_TYPE=1;
public static final int Two_TYPE=2;

    public Settings(String title,int type,int image,String name) {
        this.title = title;
        this.type=type;
        this.image=image;
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
