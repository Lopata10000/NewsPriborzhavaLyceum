package com.fanta.newspriborzhavalyceum.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.Random;

public class Faker {
    public static void main(String[] args) {
        com.github.javafaker.Faker faker = new com.github.javafaker.Faker();
        Random random = new Random();

        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/news-priborzhava-lyceum", "postgres", "45435")) {
            // Заповнення таблиці "Користувачі"
            String insertUserSql = "INSERT INTO users (name, email, password, user_role, date_of_birth) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement userStatement = connection.prepareStatement(insertUserSql)) {
                for (int i = 0; i < 10; i++) {
                    userStatement.setString(1, faker.name().fullName());
                    userStatement.setString(2, faker.internet().emailAddress());
                    userStatement.setString(3, faker.internet().password());
                    userStatement.setInt(4, faker.number().numberBetween(0, 2));
                    userStatement.setObject(5, faker.date().birthday().toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate());
                    userStatement.addBatch();
                }
                userStatement.executeBatch();
            }

            // Заповнення таблиці "Заходи"
            String insertEventSql = "INSERT INTO events (event_name, event_date, event_time, place_address, number_of_participants, event_description, organizer_contact_info, access_type) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement eventStatement = connection.prepareStatement(insertEventSql)) {
                for (int i = 0; i < 10; i++) {
                    eventStatement.setString(1, faker.company().name());
                    eventStatement.setObject(2, faker.date().future(365, java.util.concurrent.TimeUnit.DAYS).toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate());
                    eventStatement.setObject(3, LocalTime.of(random.nextInt(24), random.nextInt(60)));
                    eventStatement.setString(4, faker.address().fullAddress());
                    eventStatement.setInt(5, random.nextInt(100));
                    eventStatement.setString(6, faker.lorem().paragraph());
                    eventStatement.setString(7, faker.phoneNumber().phoneNumber());
                    eventStatement.setString(8, random.nextBoolean() ? "Public" : "Private");
                    eventStatement.addBatch();
                }
                eventStatement.executeBatch();
            }

            // Заповнення таблиці "Заявки"
            String insertApplicationSql = "INSERT INTO applications (event_id, user_id, applicant_name, status, note) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement applicationStatement = connection.prepareStatement(insertApplicationSql)) {
                for (int i = 0; i < 10; i++) {
                    applicationStatement.setInt(1, random.nextInt(10) + 1); // Випадково обране event_id
                    applicationStatement.setInt(2, random.nextInt(10) + 1); // Випадково обране user_id
                    applicationStatement.setString(3, faker.name().fullName());
                    applicationStatement.setString(4, random.nextBoolean() ? "Approved" : "Pending");
                    applicationStatement.setString(5, faker.lorem().sentence());
                    applicationStatement.addBatch();
                }
                applicationStatement.executeBatch();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
