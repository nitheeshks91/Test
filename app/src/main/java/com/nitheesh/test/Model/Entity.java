package com.nitheesh.test.Model;

import android.graphics.Bitmap;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by 08468 on 5/24/2016.
 */
public class Entity implements Serializable {

    @SerializedName("gender")
    String gender;

    @SerializedName("number")
    int number;

    @SerializedName("thumbnail")
    String thumbnail;

    @SerializedName("picture")
    String picture;

    @SerializedName("descritpion")
    String descritpion;

    Bitmap bitmap;

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "gender='" + gender + '\'' +
                ", number=" + number +
                ", thumbnail='" + thumbnail + '\'' +
                ", picture='" + picture + '\'' +
                ", descritpion='" + descritpion + '\'' +
                '}';
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getDescritpion() {
        return descritpion;
    }

    public void setDescritpion(String descritpion) {
        this.descritpion = descritpion;
    }
}
