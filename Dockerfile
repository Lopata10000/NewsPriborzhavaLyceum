FROM maven:3.9.6-amazoncorretto-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn package

FROM amazoncorretto:17
COPY --from=build /app/target/news-priborzhava-lyceum-0.0.1-SNAPSHOT.jar lyceum.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "lyceum.jar"]