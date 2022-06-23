package com.example.recyclerview;

import java.io.Serializable;

public class ContactModel implements Serializable {
    public String avatar;
    public String name;
    public String surname;
    public String post;
    public String description;

    public ContactModel(String avatar, String name, String surname, String post, String description) {
        this.avatar = avatar;
        this.name = name;
        this.surname = surname;
        this.post = post;
        this.description = description;
    }
}
