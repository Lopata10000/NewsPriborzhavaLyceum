package com.fanta.newspriborzhavalyceum.database.dto;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class EventDTO {
    private Long id;
    private String eventName;
    private Date eventDate;
    private Time eventTime;
    private Long placeId;
    private int numberOfParticipants;
    private String eventDescription;
    private String organizerContactInfo;
    private String accessType;

    public EventDTO(Long id, String eventName, java.sql.Date eventDate, Time eventTime, Long placeId, int numberOfParticipants, String eventDescription, String organizerContactInfo, String accessType) {
        this.id = id;
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
        this.placeId = placeId;
        this.numberOfParticipants = numberOfParticipants;
        this.eventDescription = eventDescription;
        this.organizerContactInfo = organizerContactInfo;
        this.accessType = accessType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(java.sql.Date eventDate) {
        this.eventDate = eventDate;
    }

    public Time getEventTime() {
        return eventTime;
    }

    public void setEventTime(Time eventTime) {
        this.eventTime = eventTime;
    }

    public Long getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Long placeId) {
        this.placeId = placeId;
    }

    public int getNumberOfParticipants() {
        return numberOfParticipants;
    }

    public void setNumberOfParticipants(int numberOfParticipants) {
        this.numberOfParticipants = numberOfParticipants;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getOrganizerContactInfo() {
        return organizerContactInfo;
    }

    public void setOrganizerContactInfo(String organizerContactInfo) {
        this.organizerContactInfo = organizerContactInfo;
    }

    public String getAccessType() {
        return accessType;
    }

    public void setAccessType(String accessType) {
        this.accessType = accessType;
    }
}
