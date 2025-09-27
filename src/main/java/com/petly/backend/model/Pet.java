package com.petly.backend.model;

import com.petly.backend.model.enums.PetSize;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "pets")
@Data
public class Pet {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private String species;
    
    private String breed;
    private Integer age;
    
    @Enumerated(EnumType.STRING)
    private PetSize size;
    
    @Column(columnDefinition = "TEXT")
    private String specialNotes;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", nullable = false)
    private User owner;
}