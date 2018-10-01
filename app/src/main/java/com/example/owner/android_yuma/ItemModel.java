package com.example.owner.android_yuma;

import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;

import java.io.Serializable;

public class ItemModel implements Serializable {
    @DrawableRes
    private int imageId;
    private String name;
    private String prefecture;

    public ItemModel(@DrawableRes int imageId, @NonNull String name, @NonNull String prefecture) {
        this.imageId = imageId;
        this.name = name;
        this.prefecture = prefecture;
    }

    @DrawableRes
    public int getImageId() {
        return imageId;
    }

    public void setImageId(@DrawableRes int imageId) {
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrefecture() {
        return prefecture;
    }

    public void setPrefecture(String prefecture) {
        this.prefecture = prefecture;
    }
}
