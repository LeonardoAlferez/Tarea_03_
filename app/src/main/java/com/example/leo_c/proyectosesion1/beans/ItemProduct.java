package com.example.leo_c.proyectosesion1.beans;

import android.graphics.drawable.Drawable;
import android.media.Image;

/**
 * Created by leo_c on 26/02/2018.
 */

public class ItemProduct {
    private int local_image;
    private int image;
    private String title;
    private String store;
    private String phone;
    private String location;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String description;


    public void setImage(int image) {
        this.image = image;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ItemProduct(){}

    public int getLocal_image() {
        return local_image;
    }

    public void setLocal_image(int local_image) {
        this.local_image = local_image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ItemProduct(String title, String store, String location, String phone, int image,String description, int local_image) {
        this.title = title;
        this.store = store;
        this.phone = phone;
        this.location = location;
        this.image = image;
        this.local_image = local_image;
        this.description = description;
    }

    @Override
    public String toString() {
        return "ItemProduct{" +
                "tittle :" + title + '\'' +
                ", store :" + store + '\'' +
                ", location :" + location + '\'' +
                ", phone :" + phone + '\'' +
                ", Description : "+description+
                '}';
    }

    public String getTittle() {
        return title;
    }

    public void setTittle(String tittle) {
        this.title = tittle;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public int getImage() {
        return image;
    }
}