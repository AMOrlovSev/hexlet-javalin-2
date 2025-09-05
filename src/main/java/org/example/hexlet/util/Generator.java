package org.example.hexlet.util;

import org.example.hexlet.model.User;

import java.util.List;
import java.util.ArrayList;

import static org.example.hexlet.util.Security.encrypt;


public class Generator {

    public static List<User> getUsers() {
        List<User> users = new ArrayList<>();

        users.add(new User("admin", "email@ex1.com", encrypt("secret")));
        users.add(new User("mike", "email@ex2.com", encrypt("superpass")));
        users.add(new User("kate", "email@ex3.com", encrypt("strongpass")));

        return users;
    }
}