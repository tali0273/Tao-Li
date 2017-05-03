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
    /**
     * Gets the user's name
     * @return name of the user
     */
    public String getName() {
        return name;
    }
    /**
     * Gets the user's age
     * @return age of the user
     */
    public int getAge() {
        return age;
    }
    /**
     * Gets the user's major
     * @return major of the user
     */
    public String getMajor() {
        return major;
    }
    /**
     * Gets the user's year
     * @return year of the user
     */
    public int getYear() {
        return year;
    }
    /**
     * Gets the user's ID
     * @return ID of the user
     */
    public int getID() {
        return id;
    }
    /**
     * Gets the user's email
     * @return email of the user
     */
    public String getEmail() {
        return email;
    }
    /**
     * Gets the user's password
     * @return password of the user
     */
    public String getPassword() {
        return password;
    }
}