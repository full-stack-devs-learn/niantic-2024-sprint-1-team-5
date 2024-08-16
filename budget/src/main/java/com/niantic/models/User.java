package com.niantic.models;

public class User {
    int userId;
    String firstName;
    String lastName;
    String fullName;

    public User() {
    }

    public User(int user_id, String first_name, String last_name, String full_name) {
        this.userId = user_id;
        this.firstName = first_name;
        this.lastName = last_name;
        this.fullName = full_name;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}