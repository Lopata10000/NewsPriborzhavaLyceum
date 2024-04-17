package com.fanta.newspriborzhavalyceum.database.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fanta.newspriborzhavalyceum.database.entity.Event;
import com.fanta.newspriborzhavalyceum.database.repository.EventRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Optional<Event> getEventById(Long id) {
        return eventRepository.findById(id);
    }

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }
    public Event updateEvent(Event event) {
        return eventRepository.findById(event.getId())
                .map(existingEvent -> {
                    existingEvent.setEventName(event.getEventName());
                    existingEvent.setEventDate(event.getEventDate());
                    existingEvent.setEventTime(event.getEventTime());
                    existingEvent.setAccessType(event.getAccessType());
                    existingEvent.setNumberOfParticipants(event.getNumberOfParticipants());
                    existingEvent.setPlaceAddress(event.getPlaceAddress());

                    return eventRepository.save(existingEvent);
                })
                .orElseThrow(() -> new EntityNotFoundException("Event with id " + event.getId() + " not found"));
    }
    public void deleteEventById(Long id) {
        eventRepository.deleteById(id);
    }
}

