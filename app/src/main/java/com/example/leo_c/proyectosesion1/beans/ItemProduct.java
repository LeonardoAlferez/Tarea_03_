package com.example.leo_c.proyectosesion1.beans;

import android.content.ClipData;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by leo_c on 26/02/2018.
 */

public class ItemProduct implements Parcelable{
    private int code;
    private String title;
    private String description;
    private Integer image;
    private Store store;
    private Category category;

    public ItemProduct(){
        code = 0;
        image = 0;
        title = "";
        store = null;
        category = null;
        description = "";
    }

    public ItemProduct(int code, String title, String description, Integer image, Store store, Category category) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.image = image;
        this.store = store;
        this.category = category;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "ItemProduct{" +
                "code=" + code +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", image=" + image +
                ", store=" + store.getName() +
                ", category=" + category.getName() +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.code);
        dest.writeString(this.title);
        dest.writeString(this.description);
        dest.writeValue(this.image);
        dest.writeParcelable(this.store, flags);
        dest.writeParcelable(this.category, flags);
    }

    protected ItemProduct(Parcel in) {
        this.code = in.readInt();
        this.title = in.readString();
        this.description = in.readString();
        this.image = (Integer) in.readValue(Integer.class.getClassLoader());
        this.store = in.readParcelable(Store.class.getClassLoader());
        this.category = in.readParcelable(Category.class.getClassLoader());
    }

    public static final Creator<ItemProduct> CREATOR = new Creator<ItemProduct>() {
        @Override
        public ItemProduct createFromParcel(Parcel source) {
            return new ItemProduct(source);
        }

        @Override
        public ItemProduct[] newArray(int size) {
            return new ItemProduct[size];
        }
    };

}
