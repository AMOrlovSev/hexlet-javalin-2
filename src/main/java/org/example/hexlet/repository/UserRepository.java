package org.example.hexlet.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.example.hexlet.model.User;
import org.example.hexlet.util.Generator;

public class UserRepository {
    private static List<User> entities = Generator.getUsers();

    public static void save(User user) {
        if (user.getId() == null) {
            // Новый пользователь
            user.setId((long) entities.size() + 1);
            user.setCreatedAt(LocalDateTime.now());
            entities.add(user);
        } else {
            // Обновление существующего пользователя
            update(user);
        }
    }

    public static List<User> search(String term) {
        var users = entities.stream()
                .filter(entity -> entity.getName().startsWith(term))
                .toList();
        return users;
    }

    public static Optional<User> find(Long id) {
        var maybeUser = entities.stream()
                .filter(entity -> entity.getId() == id)
                .findAny();
        return maybeUser;
    }

    public static Optional<User> findByName(String name) {
        return entities.stream()
                .filter(entity -> entity.getName().equals(name))
                .findAny();
    }

    public static boolean existsByName(String name) {
        return entities.stream()
                .anyMatch(value -> value.getName().equals(name));
    }

    public static void delete(Long id) {
        entities.removeIf(user -> user.getId() == id);
    }

    public static void removeAll() {
        entities = new ArrayList<User>();
    }

    public static List<User> getEntities() {
        return entities;
    }

    public static void update(User updatedUser) {
        for (int i = 0; i < entities.size(); i++) {
            User user = entities.get(i);
            if (user.getId().equals(updatedUser.getId())) {
                // Обновляем поля, но сохраняем ID и createdAt
                user.setName(updatedUser.getName());
                user.setEmail(updatedUser.getEmail());
                user.setPassword(updatedUser.getPassword());
                // Не обновляем createdAt - оставляем оригинальное значение
                entities.set(i, user);
                return;
            }
        }
        throw new RuntimeException("User not found with id: " + updatedUser.getId());
    }

}