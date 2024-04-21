# Используем базовый образ с Java 11
FROM openjdk:21

# Устанавливаем рабочую директорию внутри контейнера
WORKDIR /news-priborzhava-lyceum

# Копируем JAR файл приложения в контейнер
COPY target/news-priborzhava-lyceum-0.0.1-SNAPSHOT.jar news-priborzhava-lyceum-0.0.1-SNAPSHOT.jar

# Команда для запуска приложения при старте контейнера
CMD ["java", "-jar", "news-priborzhava-lyceum-0.0.1-SNAPSHOT.jar"]
