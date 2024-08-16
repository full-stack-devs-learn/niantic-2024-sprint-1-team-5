package com.niantic.models;

public class Subcategory {
    private int subcategoryId;
    private String categoryName;
    private int categoryOwner;
    private int parentId;

    public Subcategory() {

    }

    public Subcategory(int categoryId, String categoryName, int categoryOwner, int parentId) {
        this.subcategoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryOwner = categoryOwner;
        this.parentId = parentId;
    }

    public int getSubcategoryId() {
        return subcategoryId;
    }

    public void setSubcategoryId(int subcategoryId) {
        this.subcategoryId = subcategoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getCategoryOwner() {
        return categoryOwner;
    }

    public void setCategoryOwner(int categoryOwner) {
        this.categoryOwner = categoryOwner;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }
}