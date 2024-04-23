package com.fanta.newspriborzhavalyceum.database.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "applications")
public class Applications {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "event_id", nullable = false, length = 255)
    private Long eventId;

    @Column(name = "user_id", nullable = false, length = 255)
    private Long userId;


    @Column(name = "status", nullable = false, length = 255)
    private String status = "сonsidered";

    @Column(name = "applicant_name", nullable = false, length = 255)
    private String applicantName;

    @Column(name = "note", length = 255)
    private String note;


}
