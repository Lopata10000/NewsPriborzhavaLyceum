package com.fanta.newspriborzhavalyceum.database.controller;

import com.fanta.newspriborzhavalyceum.database.entity.EventPlace;
import com.fanta.newspriborzhavalyceum.database.service.EventPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/event-places")
public class EventPlaceController {

    private final EventPlaceService eventPlaceService;

    @Autowired
    public EventPlaceController(EventPlaceService eventPlaceService) {
        this.eventPlaceService = eventPlaceService;
    }

    @PostMapping
    public ResponseEntity<EventPlace> createEventPlace(@RequestBody EventPlace eventPlace) {
        EventPlace createdEventPlace = eventPlaceService.createEventPlace(eventPlace);
        return new ResponseEntity<>(createdEventPlace, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventPlace> getEventPlaceById(@PathVariable Long id) {
        Optional<EventPlace> eventPlace = eventPlaceService.getEventPlaceById(id);
        return eventPlace.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<EventPlace>> getAllEventPlaces() {
        List<EventPlace> eventPlaces = eventPlaceService.getAllEventPlaces();
        return new ResponseEntity<>(eventPlaces, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventPlace> updateEventPlace(@PathVariable Long id, @RequestBody EventPlace eventPlace) {
        eventPlace.setId(id);
        EventPlace updatedEventPlace = eventPlaceService.updateEventPlace(eventPlace);
        return new ResponseEntity<>(updatedEventPlace, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEventPlace(@PathVariable Long id) {
        eventPlaceService.deleteEventPlaceById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
