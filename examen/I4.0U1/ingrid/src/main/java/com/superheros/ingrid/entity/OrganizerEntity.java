package com.superheros.ingrid.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.context.annotation.Lazy;

import java.util.List;
@Data
@Entity
@Lazy
public class OrganizerEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String name;
        private String email;
        private String phoneNumber;
        @OneToMany(mappedBy = "organizer")
        private List<EventEntity> events;
}
