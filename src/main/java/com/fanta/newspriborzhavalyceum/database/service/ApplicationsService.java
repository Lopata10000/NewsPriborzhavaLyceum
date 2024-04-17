package com.fanta.newspriborzhavalyceum.database.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fanta.newspriborzhavalyceum.database.entity.Applications;
import com.fanta.newspriborzhavalyceum.database.repository.ApplicationsRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ApplicationsService {

    @Autowired
    private ApplicationsRepository applicationsRepository;

    public List<Applications> getAllApplicationss() {
        return applicationsRepository.findAll();
    }

    public Optional<Applications> getApplicationsById(Long id) {
        return applicationsRepository.findById(id);
    }
    public Applications updateApplications(Applications applications) {
        return applicationsRepository.findById(applications.getId())
                .map(existingApplications -> {
                    existingApplications.setApplicantName(applications.getApplicantName());
                    existingApplications.setStatus(applications.getStatus());
                    existingApplications.setEventId(applications.getEventId());
                    existingApplications.setUserId(applications.getUserId());
                    existingApplications.setNote(applications.getNote());
                    // Інші оновлення для таблиці event_places
                    return applicationsRepository.save(existingApplications);
                })
                .orElseThrow(() -> new EntityNotFoundException("Applications with id " + applications.getId() + " not found"));
    }
    public Applications createApplications(Applications applications) {
        return applicationsRepository.save(applications);
    }

    public void deleteApplicationsById(Long id) {
        applicationsRepository.deleteById(id);
    }
}
