package com.petly.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Entity
@Table(name = "sitter_profiles")
@Data
public class SitterProfile {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    
    private String headline;
    
    @Column(columnDefinition = "TEXT")
    private String bio;
    
    private String city;
    private String zipCode;
    private BigDecimal latitude;
    private BigDecimal longitude;
    
    private Boolean verified = false;
    private BigDecimal averageRating;
    private Integer totalReviews = 0;
}