package com.fanta.newspriborzhavalyceum.database.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventDTO {
    private Long id;
    private String eventName;
    private Date eventDate;
    private LocalTime eventTime;
    private Long placeId;
    private int numberOfParticipants;
    private String eventDescription;
    private String organizerContactInfo;
    private String accessType;

    }
