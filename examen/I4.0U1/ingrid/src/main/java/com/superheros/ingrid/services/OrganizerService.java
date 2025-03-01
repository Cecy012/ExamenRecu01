package com.superheros.ingrid.services;

import com.superheros.ingrid.entity.OrganizerEntity;
import com.superheros.ingrid.repository.OrganizerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrganizerService {

    @Autowired
    private OrganizerRepository organizerRepository;

    public OrganizerEntity getOrganizerByName(String name) {
        return organizerRepository.findByName(name);
    }

    public OrganizerEntity saveOrganizer(OrganizerEntity organizer) {
        return organizerRepository.save(organizer);
    }
}
