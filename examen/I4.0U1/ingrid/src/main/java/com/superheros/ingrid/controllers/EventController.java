package com.superheros.ingrid.controllers;

import com.superheros.ingrid.entity.EventEntity;
import com.superheros.ingrid.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

@RequestMapping("/api/event")
@Lazy
public class EventController {

    @Autowired
    private EventController eventController;

    @GetMapping("/getAll")
    public List<EventEntity> getAllEvents() {
        return eventController.getAllEvents();
    }

    @GetMapping("/getById/{id}")
    public Optional<EventEntity> getEventById(@PathVariable Long id) {
        return eventController.getEventById(id);
    }

    @GetMapping("/findByName/{name}")
    public List<EventEntity> getEventByName(@PathVariable String name) {
        return eventController.getEventByName(name);
    }

    @PostMapping("/save")
    public EventEntity saveEvent(@RequestBody EventEntity event) {
        return eventController.saveEvent(event);
    }

    @PutMapping("/update/{id}")
    public EventEntity updateEvent(@PathVariable Long id, @RequestBody EventEntity event) {
        return eventController.updateEvent(id, event);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteEvent(@PathVariable Long id) {
        eventController.deleteEvent(id);
    }
}
