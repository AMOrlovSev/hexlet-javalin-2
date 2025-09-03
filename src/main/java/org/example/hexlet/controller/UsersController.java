package org.example.hexlet.controller;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;
import io.javalin.validation.ValidationException;
import org.example.hexlet.NamedRoutes;
import org.example.hexlet.dto.users.BuildUserPage;
import org.example.hexlet.dto.users.EditUserPage;
import org.example.hexlet.dto.users.UserPage;
import org.example.hexlet.dto.users.UsersPage;
import org.example.hexlet.model.User;
import org.example.hexlet.repository.UserRepository;

import java.util.stream.Collectors;

import static io.javalin.rendering.template.TemplateUtil.model;

public class UsersController {
    public static void index(Context ctx) {
        var users = UserRepository.getEntities();
        var term = ctx.queryParam("term");
        if (term != null) {
            users = users.stream()
                    .filter(user -> user.getName().toLowerCase().contains(term.toLowerCase()))
                    .collect(Collectors.toList());
        }
        var page = new UsersPage(users, term);
        ctx.render("users/index.jte", model("page", page));
    }

    public static void build(Context ctx) {
        var page = new BuildUserPage();
        ctx.render("users/build.jte", model("page", page));
    }

    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var user = UserRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Entity with id = " + id + " not found"));
        var page = new UserPage(user);
        ctx.render("users/show.jte", model("page", page));
    }

    public static void create(Context ctx) {
        var name = ctx.formParam("name").trim();
        var email = ctx.formParam("email").trim().toLowerCase();

        try {
            var passwordConfirmation = ctx.formParam("passwordConfirmation");
            var password = ctx.formParamAsClass("password", String.class)
                    .check(value -> value.equals(passwordConfirmation), "Пароли не совпадают")
                    .get();
            var user = new User(name, email, password);
            UserRepository.save(user);
            ctx.redirect(NamedRoutes.usersPath());
        } catch (ValidationException e) {
            var page = new BuildUserPage(name, email, e.getErrors());
            ctx.render("users/build.jte", model("page", page));
        }
    }

    public static void edit(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var user = UserRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Entity with id = " + id + " not found"));
        // Используйте EditUserPage вместо UserPage
        var page = new EditUserPage(user, null); // null для errors, так как их пока нет
        ctx.render("users/edit.jte", model("page", page));
    }


    public static void update(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var name = ctx.formParam("name").trim();
        var email = ctx.formParam("email").trim().toLowerCase();
        var password = ctx.formParam("password");
        var passwordConfirmation = ctx.formParam("passwordConfirmation");

        try {
            var user = UserRepository.find(id)
                    .orElseThrow(() -> new NotFoundResponse("Entity with id = " + id + " not found"));

            // Валидируем пароль только если он был введен
            if (!password.isEmpty()) {
                ctx.formParamAsClass("password", String.class)
                        .check(value -> value.equals(passwordConfirmation), "Пароли не совпадают")
                        .get();
                user.setPassword(password);
            }

            user.setName(name);
            user.setEmail(email);
            UserRepository.save(user);
            ctx.redirect(NamedRoutes.usersPath());

        } catch (ValidationException e) {
            var user = UserRepository.find(id)
                    .orElseThrow(() -> new NotFoundResponse("Entity with id = " + id + " not found"));
            var page = new EditUserPage(user, e.getErrors());
            ctx.render("users/edit.jte", model("page", page));
        }
    }

    public static void destroy(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        UserRepository.delete(id);
        ctx.redirect(NamedRoutes.usersPath());
    }
}