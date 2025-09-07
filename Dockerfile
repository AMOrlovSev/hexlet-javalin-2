FROM gradle:8.12.1-jdk21

WORKDIR /app

COPY . .

# Даем права на выполнение для gradlew
RUN chmod +x gradlew

EXPOSE 7070

CMD ["./gradlew", "run"]