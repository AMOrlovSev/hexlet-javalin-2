package org.example.hexlet.controller;

import io.javalin.http.Context;
import org.example.hexlet.dto.MainPage;

import static io.javalin.rendering.template.TemplateUtil.model;

public class RootController {
    public static void index(Context ctx) {
        var visited = Boolean.valueOf(ctx.cookie("visited"));
        var page = new MainPage(visited, ctx.sessionAttribute("currentUser"));
        ctx.render("index.jte", model("page", page));
        ctx.cookie("visited", String.valueOf(true));
    }
}
