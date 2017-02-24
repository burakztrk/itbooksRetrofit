package com.ozturkburak.itbooksretrofit.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class BookInfo implements Serializable{
    private static final long serialVersionUID = 1L;

    @SerializedName("ID")
    @Expose
    private String iD;

    @SerializedName("Title")
    @Expose
    private String title;

    @SerializedName("Description")
    @Expose
    private String description;

    @SerializedName("Image")
    @Expose
    private String image;

    @SerializedName("isbn")
    @Expose
    private String isbn;

    @SerializedName("SubTitle")
    @Expose
    private String subTitle;

    /**
     * No args constructor for use in serialization
     *
     */
    public BookInfo() {
    }

    /**
     *
     * @param subTitle
     * @param title
     * @param description
     * @param isbn
     * @param image
     * @param iD
     */
    public BookInfo(String iD, String title, String description, String image, String isbn, String subTitle) {
        super();
        this.iD = iD;
        this.title = title;
        this.description = description;
        this.image = image;
        this.isbn = isbn;
        this.subTitle = subTitle;
    }

    public String getID() {
        return iD;
    }

    public void setID(String iD) {
        this.iD = iD;
    }

    public BookInfo withID(String iD) {
        this.iD = iD;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BookInfo withTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BookInfo withDescription(String description) {
        this.description = description;
        return this;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public BookInfo withImage(String image) {
        this.image = image;
        return this;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public BookInfo withIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public BookInfo withSubTitle(String subTitle) {
        this.subTitle = subTitle;
        return this;
    }

    @Override
    public String toString() {
        return String.format("%s ",title );
    }
}
