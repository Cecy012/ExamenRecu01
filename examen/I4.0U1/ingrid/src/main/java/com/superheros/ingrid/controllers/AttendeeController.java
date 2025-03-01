package com.superheros.ingrid.controllers;

import com.superheros.ingrid.entity.AttendeeEntity;
import com.superheros.ingrid.services.AttendeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attendee")
@Lazy
public class AttendeeController {
    @Autowired
    private AttendeeService attendeeService;
    @GetMapping("/getAll")
    public List<AttendeeEntity> getAllAttendees() {
        return attendeeService.getAllAttendees();
    }
    @GetMapping("/getAttendeesByEmail/{email}")
    public AttendeeEntity getAttendeeByEmail(@PathVariable String email) {
        return attendeeService.getAttendeeByEmail(email).orElseThrow(() -> new RuntimeException("No se encontro el asistente") );
    }
    @PostMapping("/save")
    public AttendeeEntity saveAttendee(@RequestBody AttendeeEntity attendee) {
        return attendeeService.saveAttendee(attendee);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteAttendee(@PathVariable Long id) {
        attendeeService.deleteAttendee(id);
    }
}
