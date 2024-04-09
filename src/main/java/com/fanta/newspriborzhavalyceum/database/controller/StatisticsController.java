package com.fanta.newspriborzhavalyceum.database.controller;

import com.fanta.newspriborzhavalyceum.database.entity.Statistics;
import com.fanta.newspriborzhavalyceum.database.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/statistics")
public class StatisticsController {

    private final StatisticsService statisticsService;

    @Autowired
    public StatisticsController(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @PostMapping
    public ResponseEntity<Statistics> createStatistics(@RequestBody Statistics statistics) {
        Statistics createdStatistics = statisticsService.saveStatistics(statistics);
        return new ResponseEntity<>(createdStatistics, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Statistics> getStatisticsById(@PathVariable Long id) {
        Optional<Statistics> statistics = statisticsService.getStatisticsById(id);
        return statistics.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<Statistics>> getAllStatistics() {
        List<Statistics> statistics = statisticsService.getAllStatistics();
        return new ResponseEntity<>(statistics, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Statistics> updateStatistics(@PathVariable Long id, @RequestBody Statistics statistics) {
        statistics.setId(id);
        Statistics updatedStatistics = statisticsService.updateStatistics(statistics);
        return new ResponseEntity<>(updatedStatistics, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStatistics(@PathVariable Long id) {
        statisticsService.deleteStatisticsById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
