package com.example.isaia.socialbuff;

/**
 * Created by dominicdeckys on 4/26/17.
 * DO NOT MODIFY THIS FILE
 */

public class User {
    private String name;
    private String email;
    private String password;
    private int age;
    private String major;
    private int year;
    private int id;
    public static User getCurrentUser() {return UserDatabase.getCurrentUser();}
    public User(String name1, String email1, String password1, int age1, String major1, int year1, int id1) {
        name = name1;
        age = age1;
        major = major1;
        year = year1;
        id = id1;
        email = email1;
        password = password1;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getMajor() {
        return major;
    }
    public int getYear() {
        return year;
    }
    public int getID() {
        return id;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
}