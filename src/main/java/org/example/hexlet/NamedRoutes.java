package org.example.hexlet;

public class NamedRoutes {
    public static String coursesPath() {
        return "/courses";
    }

    public static String buildCoursePath() {
        return "/courses/build";
    }

    public static String editCoursePath(Long id) {
        return editCoursePath(String.valueOf(id));
    }

    public static String editCoursePath(String id) {
        return "/courses/" + id + "/edit";
    }

    public static String coursePath(Long id) {
        return coursePath(String.valueOf(id));
    }

    public static String coursePath(String id) {
        return "/courses/" + id;
    }



    public static String usersPath() {
        return "/users";
    }

    public static String buildUserPath() {
        return "/users/build";
    }

    public static String editUserPath(Long id) {
        return editUserPath(String.valueOf(id));
    }

    public static String editUserPath(String id) {
        return "/users/" + id + "/edit";
    }

    public static String userPath(Long id) {
        return userPath(String.valueOf(id));
    }

    public static String userPath(String id) {
        return "/users/" + id;
    }



    public static String rootPath() {
        return "/";
    }



    public static String postsPath() {
        return "/posts";
    }

    public static String buildPostPath() {
        return "/posts/build";
    }

    public static String postPath(Long id) {
        return postPath(String.valueOf(id));
    }

    public static String postPath(String id) {
        return "/posts/" + id;
    }

    public static String editPostPath(Long id) {
        return editPostPath(String.valueOf(id));
    }

    public static String editPostPath(String id) {
        return "/posts/" + id + "/edit";
    }



    public static String sessionsPath() {
        return "/sessions";
    }

    public static String buildSessionPath() {
        return "/sessions/build";
    }
}
