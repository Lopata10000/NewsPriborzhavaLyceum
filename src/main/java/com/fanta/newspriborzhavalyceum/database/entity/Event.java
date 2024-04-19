package com.fanta.newspriborzhavalyceum.database.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Time;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "event_name", nullable = false, length = 255)
    private String eventName;

    @Column(name = "event_date", nullable = false)
    private Date eventDate;

    @Column(name = "event_time", nullable = false)
    private Time eventTime;

    @Column(name = "number_of_participants", nullable = false)
    private int numberOfParticipants = 0;

    @Column(name = "event_description", columnDefinition = "TEXT")
    private String eventDescription;
    @Column(name = "place_address", columnDefinition = "TEXT")
    private String placeAddress;

    @Column(name = "organizer_contact_info", length = 255)
    private String organizerContactInfo;

    @Column(name = "access_type", length = 20)
    private String accessType = "public";
}
