package org.example.hexlet.controller;

import io.javalin.http.Context;
import org.example.hexlet.dto.LoginPage;
import org.example.hexlet.repository.UserRepository;
import org.example.hexlet.util.NamedRoutes;

import static io.javalin.rendering.template.TemplateUtil.model;
import static org.example.hexlet.util.Security.encrypt;

public class SessionsController {

    public static void build(Context ctx) {
        var page = new LoginPage("", null);
        ctx.render("build.jte", model("page", page));
    }

    public static void create(Context ctx) {
        var name = ctx.formParam("name");
        var password = ctx.formParam("password");

        var user = UserRepository.findByName(name).orElse(null);

        if (user != null && user.getPassword().equals(encrypt(password))) {
            ctx.sessionAttribute("currentUser", user.getName());
            ctx.redirect(NamedRoutes.rootPath());
        } else {
            var errorMessage = "Wrong username or password";
            var page = new LoginPage(name, errorMessage);
            ctx.render("build.jte", model("page", page));
        }
    }

    public static void destroy(Context ctx) {
        ctx.sessionAttribute("currentUser", null);
        ctx.redirect(NamedRoutes.rootPath());
    }
}