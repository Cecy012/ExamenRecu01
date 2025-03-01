package com.superheros.ingrid.repository;

import com.superheros.ingrid.entity.OrganizerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizerRepository extends JpaRepository<OrganizerEntity, Long> {
    OrganizerEntity findByName(String name);
}
