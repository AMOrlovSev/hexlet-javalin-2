package org.example.hexlet;

import com.sun.tools.javac.Main;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;
import org.example.hexlet.controller.*;
import org.example.hexlet.util.NamedRoutes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

public class HelloWorld {

    private static final Logger logger = LoggerFactory.getLogger(HelloWorld.class);
    private static final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

    private static int getPort() {
        String port = System.getenv().getOrDefault("PORT", "7070");
        return Integer.valueOf(port);
    }

    private static String readResourceFile(String fileName) throws IOException {
        var inputStream = HelloWorld.class.getClassLoader().getResourceAsStream(fileName);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            return reader.lines().collect(Collectors.joining("\n"));
        }
    }

    public static void main(String[] args) throws IOException, SQLException {
        var app = getApp();

        app.start(getPort());
    }

    public static Javalin getApp() throws IOException, SQLException {
        // System.setProperty("h2.traceLevel", "TRACE_LEVEL_SYSTEM_OUT=4");

        var hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl("jdbc:h2:mem:project;DB_CLOSE_DELAY=-1;");

        var dataSource = new HikariDataSource(hikariConfig);
        var sql = readResourceFile("schema.sql");

        try (var connection = dataSource.getConnection();
             var statement = connection.createStatement()) {
            statement.execute(sql);
        }

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
            config.bundledPlugins.enableRouteOverview("/routes");
        });

        app.before(ctx -> {
            ctx.contentType("text/html; charset=utf-8");
        });


        // Middleware для всех запросов
        app.before(ctx -> {
            ctx.attribute("startTime", Instant.now());
            String timestamp = LocalDateTime.now().format(formatter);
            logger.info("[{}] → {} {} from {}", timestamp, ctx.method(), ctx.path(), ctx.ip());
        });

        app.after(ctx -> {
            Instant start = (Instant) ctx.attribute("startTime");
            long duration = Duration.between(start, Instant.now()).toMillis();
            String timestamp = LocalDateTime.now().format(formatter);

            logger.info("[{}] ← {} {} - Status: {} - {}ms",
                    timestamp, ctx.method(), ctx.path(), ctx.status(), duration);
        });


        app.get(NamedRoutes.coursesPath(), CoursesController::index);
        app.get(NamedRoutes.buildCoursePath(), CoursesController::build);
        app.get(NamedRoutes.coursePath("{id}"), CoursesController::show);
        app.post(NamedRoutes.coursesPath(), CoursesController::create);
        app.get(NamedRoutes.editCoursePath("{id}"), CoursesController::edit);
        app.patch(NamedRoutes.coursePath("{id}"), CoursesController::update);
        app.delete(NamedRoutes.coursePath("{id}"), CoursesController::destroy);


        app.get(NamedRoutes.usersPath(), UsersController::index);
        app.get(NamedRoutes.buildUserPath(), UsersController::build);
        app.get(NamedRoutes.userPath("{id}"), UsersController::show);
        app.post(NamedRoutes.usersPath(), UsersController::create);
        app.get(NamedRoutes.editUserPath("{id}"), UsersController::edit);
        app.patch(NamedRoutes.userPath("{id}"), UsersController::update);
        app.delete(NamedRoutes.userPath("{id}"), UsersController::destroy);


        app.get(NamedRoutes.rootPath(), RootController::index);


        app.get(NamedRoutes.buildPostPath(), PostsController::build);
        app.post(NamedRoutes.postsPath(), PostsController::create);
        app.get(NamedRoutes.postsPath(), PostsController::index);
        app.get(NamedRoutes.postPath("{id}"), PostsController::show);
        app.get(NamedRoutes.editPostPath("{id}"), PostsController::edit);
        app.post(NamedRoutes.postPath("{id}"), PostsController::update);

        app.get(NamedRoutes.buildSessionPath(), SessionsController::build);
        app.post(NamedRoutes.loginPath(), SessionsController::create);
        app.post(NamedRoutes.logoutPath(), SessionsController::destroy);

        return app;
    }
}
