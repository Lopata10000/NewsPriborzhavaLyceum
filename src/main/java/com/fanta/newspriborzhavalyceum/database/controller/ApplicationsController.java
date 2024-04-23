package com.fanta.newspriborzhavalyceum.database.controller;

import com.fanta.newspriborzhavalyceum.database.entity.Applications;
import com.fanta.newspriborzhavalyceum.database.service.ApplicationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/applications")
public class ApplicationsController {

    private final ApplicationsService applicationsService;

    @Autowired
    public ApplicationsController(ApplicationsService applicationsService) {
        this.applicationsService = applicationsService;
    }

    @PostMapping("/create")
    public ResponseEntity<Applications> createApplications(@RequestBody Applications applications) {

        Applications createdApplications = applicationsService.createApplications(applications);
        return new ResponseEntity<>(createdApplications, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Applications> getApplicationsById(@PathVariable Long id) {
        Optional<Applications> applications = applicationsService.getApplicationsById(id);
        return applications.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<Applications>> getAllApplicationss() {
        List<Applications> applicationss = applicationsService.getAllApplicationss();
        return new ResponseEntity<>(applicationss, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Applications> updateApplications(@PathVariable Long id, @RequestBody Applications applications) {
        applications.setId(id);
        Applications updatedApplications = applicationsService.updateApplications(applications);
        return new ResponseEntity<>(updatedApplications, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApplications(@PathVariable Long id) {
        applicationsService.deleteApplicationsById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
