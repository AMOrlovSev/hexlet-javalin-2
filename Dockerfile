FROM gradle:8.12.1-jdk21 as builder

WORKDIR /app

# Копируем только необходимые файлы для сборки
COPY build.gradle .
COPY settings.gradle .
COPY src ./src

RUN ["./gradlew", "clean", "build"]

FROM openjdk:21-jdk-slim

WORKDIR /app

# Копируем только собранный JAR файл
COPY --from=builder /app/build/libs/*.jar app.jar

EXPOSE 7070

CMD ["java", "-jar", "app.jar"]