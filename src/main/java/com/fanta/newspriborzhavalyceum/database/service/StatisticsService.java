package com.fanta.newspriborzhavalyceum.database.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fanta.newspriborzhavalyceum.database.entity.Statistics;
import com.fanta.newspriborzhavalyceum.database.repository.StatisticsRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class StatisticsService {

    @Autowired
    private StatisticsRepository statisticsRepository;

    public List<Statistics> getAllStatistics() {
        return statisticsRepository.findAll();
    }

    public Optional<Statistics> getStatisticsById(Long id) {
        return statisticsRepository.findById(id);
    }

    public Statistics saveStatistics(Statistics statistics) {
        return statisticsRepository.save(statistics);
    }

    public Statistics updateStatistics(Statistics statistics) {
        return statisticsRepository.findById(statistics.getId())
                .map(existingStatistics -> {
                    existingStatistics.setStatDate(statistics.getStatDate());
                    existingStatistics.setRequestCount(statistics.getRequestCount());
                    existingStatistics.setParticipantCount(statistics.getParticipantCount());
                    existingStatistics.setEventTypeCount(statistics.getEventTypeCount());
                    // Інші оновлення для таблиці statistics
                    return statisticsRepository.save(existingStatistics);
                })
                .orElseThrow(() -> new EntityNotFoundException("Statistics with id " + statistics.getId() + " not found"));
    }
    public void deleteStatisticsById(Long id) {
        statisticsRepository.deleteById(id);
    }
}
