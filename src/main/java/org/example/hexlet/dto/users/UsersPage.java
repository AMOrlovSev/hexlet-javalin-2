package org.example.hexlet.dto.users;

import java.util.List;

import org.example.hexlet.dto.BasePage;
import org.example.hexlet.model.User;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UsersPage extends BasePage {
    public List<User> users;
    private String term;
}