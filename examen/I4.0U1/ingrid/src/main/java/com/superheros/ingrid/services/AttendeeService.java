package com.superheros.ingrid.services;

import com.superheros.ingrid.entity.AttendeeEntity;
import com.superheros.ingrid.repository.AttendeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttendeeService {
    @Autowired
    private AttendeeRepository attendeeRepository;

    public Optional<AttendeeEntity> getAttendeeByEmail(String email) {
        return attendeeRepository.findByEmail(email);
    }

    public AttendeeEntity saveAttendee(AttendeeEntity attendee) {

        if (attendeeRepository.findByEmail(attendee.getEmail()).isPresent()) {
            throw new RuntimeException("Ya existe un asistente con este correo");
        }
        return attendeeRepository.save(attendee);
    }

    public void deleteAttendee(Long id) {
        attendeeRepository.deleteById(id);
    }

    public List<AttendeeEntity> getAllAttendees() {
        return attendeeRepository.findAll();
    }
}
