package org.example.hexlet.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class LoginPage {
    private String name;
    private String error;
}
