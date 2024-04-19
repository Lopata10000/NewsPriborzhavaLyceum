package com.fanta.newspriborzhavalyceum.database.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
}
