package org.example.hexlet.dto.courses;

import java.util.List;

import org.example.hexlet.model.Course;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CoursesPage {
    private List<Course> courses;
    private String header;
    public String term;
}