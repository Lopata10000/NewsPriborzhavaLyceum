package com.fanta.newspriborzhavalyceum.database.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fanta.newspriborzhavalyceum.database.entity.EventPlace;
import com.fanta.newspriborzhavalyceum.database.repository.EventPlaceRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class EventPlaceService {

    @Autowired
    private EventPlaceRepository eventPlaceRepository;

    public List<EventPlace> getAllEventPlaces() {
        return eventPlaceRepository.findAll();
    }

    public Optional<EventPlace> getEventPlaceById(Long id) {
        return eventPlaceRepository.findById(id);
    }
    public EventPlace updateEventPlace(EventPlace eventPlace) {
        return eventPlaceRepository.findById(eventPlace.getId())
                .map(existingEventPlace -> {
                    existingEventPlace.setPlaceName(eventPlace.getPlaceName());
                    existingEventPlace.setPlaceAddress(eventPlace.getPlaceAddress());
                    existingEventPlace.setCapacity(eventPlace.getCapacity());
                    existingEventPlace.setAccessibility(eventPlace.getAccessibility());
                    // Інші оновлення для таблиці event_places
                    return eventPlaceRepository.save(existingEventPlace);
                })
                .orElseThrow(() -> new EntityNotFoundException("EventPlace with id " + eventPlace.getId() + " not found"));
    }
    public EventPlace createEventPlace(EventPlace eventPlace) {
        return eventPlaceRepository.save(eventPlace);
    }

    public void deleteEventPlaceById(Long id) {
        eventPlaceRepository.deleteById(id);
    }
}
