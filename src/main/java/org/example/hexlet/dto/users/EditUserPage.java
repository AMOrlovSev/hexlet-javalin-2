package org.example.hexlet.dto.users;

import io.javalin.validation.ValidationError;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.hexlet.model.User;

import java.util.List;
import java.util.Map;

@NoArgsConstructor
@Getter
public class EditUserPage {
    private org.example.hexlet.model.User user;
    private Map<String, List<ValidationError<Object>>> errors;

    public EditUserPage(User user, Map<String, List<ValidationError<Object>>> errors) {
        this.user = user;
        this.errors = errors;
    }
}