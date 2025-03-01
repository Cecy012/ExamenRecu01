package com.superheros.ingrid.services;

import com.superheros.ingrid.entity.EventEntity;
import com.superheros.ingrid.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public List<EventEntity> getAllEvents() {
        return eventRepository.findAll();
    }

    public Optional<EventEntity> getEventById(Long id) {
        return eventRepository.findById(id);
    }

    public List<EventEntity> getEventByName(String name) {
        return eventRepository.findByName(name);
    }

    public EventEntity saveEvent(EventEntity event) {
        return eventRepository.save(event);
    }

    public EventEntity updateEvent(Long id, EventEntity eventDetails) {
        EventEntity event = eventRepository.findById(id).orElseThrow();
        event.setName(eventDetails.getName());
        event.setDescription(eventDetails.getDescription());
        event.setDate(eventDetails.getDate());
        event.setLocation(eventDetails.getLocation());
        return eventRepository.save(event);
    }

    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }
}
