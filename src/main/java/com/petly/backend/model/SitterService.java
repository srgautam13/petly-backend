package com.petly.backend.model;

import com.petly.backend.model.enums.ServiceType;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "sitter_services")
@Data
public class SitterService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "sitter_profile_id", nullable = false)
    private SitterProfile sitterProfile;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ServiceType serviceType;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal basePrice;

    @Column(nullable = false)
    private String unit; // "per night", "per walk", etc.

    private Boolean active = true;
}
