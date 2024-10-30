package com.jah.jismail3;

/**
 * Name: Jahangir Ismail
 * ID: A00036852
 * Assignment 3
 * User class to deconstruct the incoming JSON
 */

public class User {

    private String name;


    public User() {
        name = "";
    }

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
