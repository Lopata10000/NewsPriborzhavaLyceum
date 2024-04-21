FROM openjdk:21

WORKDIR /news-priborzhava-lyceum

COPY target/news-priborzhava-lyceum-0.0.1-SNAPSHOT.jar .

CMD ["java", "-jar", "news-priborzhava-lyceum-0.0.1-SNAPSHOT.jar"]
