package com.superheros.ingrid.controllers;

import com.superheros.ingrid.entity.OrganizerEntity;
import com.superheros.ingrid.services.OrganizerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/organizer")
@Lazy
public class OrganizerController {

    @Autowired
    private OrganizerService organizerService;

    @GetMapping("/findByName/{name}")
    public OrganizerEntity getOrganizerByName(@PathVariable String name) {
        return organizerService.getOrganizerByName(name);
    }

    @PostMapping("/save")
    public OrganizerEntity saveOrganizer(@RequestBody OrganizerEntity organizer) {
        return organizerService.saveOrganizer(organizer);
    }
}
