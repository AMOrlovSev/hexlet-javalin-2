FROM gradle:8.12.1-jdk21 as builder

WORKDIR /app

COPY /app .

RUN ["./gradlew", "clean", "build"]

CMD ["./gradlew", "run"]