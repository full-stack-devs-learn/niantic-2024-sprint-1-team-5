package com.niantic.models;

public class Category {
    private int categoryId;
    private String categoryName;
    private int categoryOwner;

    public Category()
    {

    }

    public Category(int categoryId, String categoryName, int categoryOwner){
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryOwner = categoryOwner;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getCategoryOwner() {
        return categoryOwner;
    }

    public void setCategoryOwner(int categoryOwner) {
        this.categoryOwner = categoryOwner;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
