package org.example.hexlet.controller;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;
import io.javalin.validation.ValidationException;
import org.example.hexlet.util.NamedRoutes;
import org.example.hexlet.dto.courses.BuildCoursePage;
import org.example.hexlet.dto.courses.CoursePage;
import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.dto.courses.EditCoursePage;
import org.example.hexlet.model.Course;
import org.example.hexlet.repository.CourseRepository;

import java.util.stream.Collectors;

import static io.javalin.rendering.template.TemplateUtil.model;

public class CoursesController {
    public static void index(Context ctx) {
        var courses = CourseRepository.getEntities();
        var term = ctx.queryParam("term");
        if (term != null) {
            courses = courses.stream()
                    .filter(course -> course.getName().toLowerCase().contains(term.toLowerCase()))
                    .collect(Collectors.toList());
        }
        var page = new CoursesPage(courses, term);
        ctx.render("courses/index.jte", model("page", page));
    }

    public static void build(Context ctx) {
        var page = new BuildCoursePage();
        ctx.render("courses/build.jte", model("page", page));
    }

    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var course = CourseRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Entity with id = " + id + " not found"));
        var page = new CoursePage(course);
        ctx.render("courses/show.jte", model("page", page));
    }

    public static void create(Context ctx) {
        try {
            var name = ctx.formParamAsClass("name", String.class)
                    .check(value -> value.trim().length() > 2, "Имя должно быть более 2х символов")
                    .get();
            var description = ctx.formParamAsClass("description", String.class)
                    .check(value -> value.trim().length() > 10, "Описание должно быть более 10 символов")
                    .get();
            var course = new Course(name, description);
            CourseRepository.save(course);
            ctx.redirect(NamedRoutes.coursesPath());
        } catch (ValidationException e) {
            var name = ctx.formParam("name").trim();
            var description = ctx.formParam("description").trim();
            var page = new BuildCoursePage(name, description, e.getErrors());
            ctx.render("courses/build.jte", model("page", page));
        }
    }

    public static void edit(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var course = CourseRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Entity with id = " + id + " not found"));

        var page = new EditCoursePage(course, null); // null для errors, так как их пока нет
        ctx.render("courses/edit.jte", model("page", page));
    }

    public static void update(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var name = ctx.formParam("name").trim();
        var description = ctx.formParam("description").trim().toLowerCase();


        try {
            var course = CourseRepository.find(id)
                    .orElseThrow(() -> new NotFoundResponse("Entity with id = " + id + " not found"));

            course.setName(name);
            course.setDescription(description);
            CourseRepository.save(course);
            ctx.redirect(NamedRoutes.coursesPath());

        } catch (ValidationException e) {
            var course = CourseRepository.find(id)
                    .orElseThrow(() -> new NotFoundResponse("Entity with id = " + id + " not found"));
            var page = new EditCoursePage(course, e.getErrors());
            ctx.render("courses/edit.jte", model("page", page));
        }
    }

    public static void destroy(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        CourseRepository.delete(id);
        ctx.redirect(NamedRoutes.coursesPath());
    }
}
