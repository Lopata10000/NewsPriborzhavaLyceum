package com.fanta.newspriborzhavalyceum.database.dto;

import java.time.LocalDate;

public class StatisticsDTO {
    private Long id;
    private LocalDate statDate;
    private int requestCount;
    private int participantCount;
    private int eventTypeCount;

    public StatisticsDTO(Long id, LocalDate statDate, int requestCount, int participantCount, int eventTypeCount) {
        this.id = id;
        this.statDate = statDate;
        this.requestCount = requestCount;
        this.participantCount = participantCount;
        this.eventTypeCount = eventTypeCount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getStatDate() {
        return statDate;
    }

    public void setStatDate(LocalDate statDate) {
        this.statDate = statDate;
    }

    public int getRequestCount() {
        return requestCount;
    }

    public void setRequestCount(int requestCount) {
        this.requestCount = requestCount;
    }

    public int getParticipantCount() {
        return participantCount;
    }

    public void setParticipantCount(int participantCount) {
        this.participantCount = participantCount;
    }

    public int getEventTypeCount() {
        return eventTypeCount;
    }

    public void setEventTypeCount(int eventTypeCount) {
        this.eventTypeCount = eventTypeCount;
    }


}

