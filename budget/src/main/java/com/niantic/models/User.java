package com.niantic.models;

public class User {
    int user_id;
    String first_name;
    String last_name;
    String full_name;

    public User(){}
    public User (int user_id , String first_name, String last_name, String full_name)
    {
        this.user_id = user_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.full_name = full_name;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }
}
