FROM gradle:8.12.1-jdk21 as builder

WORKDIR /app

# Копируем только необходимые файлы для сборки
COPY gradle gradle
COPY build.gradle.kts .
COPY settings.gradle.kts .
COPY gradlew .
COPY Makefile .
COPY src src

RUN ["./gradlew", "clean", "build"]

CMD ["./gradlew", "run"]