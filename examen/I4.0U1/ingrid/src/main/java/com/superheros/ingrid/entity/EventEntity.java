package com.superheros.ingrid.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import org.springframework.context.annotation.Lazy;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Lazy
public class EventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  
    private String name;  
    private String description;  
    private Date date;  
    private String location;  
    @ManyToOne  
    private OrganizerEntity organizer;

    @OneToMany(mappedBy = "event")  
    private List<AttendeeEntity> attendeeEntities;
}
