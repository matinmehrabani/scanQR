package com.example.scanqr.model;

public class Setting {

    private int mTitle;
    private int mType;
    private int mImage;
    private int mName;
    public static final int ONE_TYPE = 1;
    public static final int Two_TYPE = 2;

    public Setting(int title, int type, int image, int name) {
        mTitle = title;
        mType = type;
        mImage = image;
        mName = name;
    }

    public void setName(int name) {
        mName = name;
    }

    public int getName() {
        return mName;
    }

    public int getImage() {
        return mImage;
    }

    public int getTitle() {
        return mTitle;
    }

    public int getType() {
        return mType;
    }
}
