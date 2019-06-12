package com.example.scanqr.model;

public class Setting {

    private String mTitle;
    private int mType;
    private int mImage;
    private String mName;
    public static final int ONE_TYPE = 1;
    public static final int Two_TYPE = 2;

    public Setting(String title, int type, int image, String name) {
        this.mTitle = title;
        this.mType = type;
        this.mImage = image;
        this.mName = name;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getName() {
        return mName;
    }

    public int getImage() {
        return mImage;
    }

    public String getTitle() {
        return mTitle;
    }

    public int getType() {
        return mType;
    }
}
