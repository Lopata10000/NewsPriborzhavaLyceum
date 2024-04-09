package com.fanta.newspriborzhavalyceum.database.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "statistics")
public class Statistics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "stat_date", nullable = false)
    private Date statDate;

    @Column(name = "request_count")
    private Integer requestCount;

    @Column(name = "participant_count")
    private Integer participantCount;

    @Column(name = "event_type_count")
    private Integer eventTypeCount;

    // Додаткові поля та методи

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStatDate() {
        return statDate;
    }

    public void setStatDate(Date statDate) {
        this.statDate = statDate;
    }

    public Integer getRequestCount() {
        return requestCount;
    }

    public void setRequestCount(Integer requestCount) {
        this.requestCount = requestCount;
    }

    public Integer getParticipantCount() {
        return participantCount;
    }

    public void setParticipantCount(Integer participantCount) {
        this.participantCount = participantCount;
    }

    public Integer getEventTypeCount() {
        return eventTypeCount;
    }

    public void setEventTypeCount(Integer eventTypeCount) {
        this.eventTypeCount = eventTypeCount;
    }
}
