package org.example.hexlet.controller;

import io.javalin.http.Context;

public class RootController {
    public static void index(Context ctx) {
        ctx.render("index.jte");
    }
}
