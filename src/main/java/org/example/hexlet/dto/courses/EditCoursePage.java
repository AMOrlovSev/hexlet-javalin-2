package org.example.hexlet.dto.courses;

import io.javalin.validation.ValidationError;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.hexlet.model.Course;
import org.example.hexlet.model.User;

import java.util.List;
import java.util.Map;

@NoArgsConstructor
@Getter
public class EditCoursePage {
    private Course course;
    private Map<String, List<ValidationError<Object>>> errors;

    public EditCoursePage(Course course, Map<String, List<ValidationError<Object>>> errors) {
        this.course = course;
        this.errors = errors;
    }
}
