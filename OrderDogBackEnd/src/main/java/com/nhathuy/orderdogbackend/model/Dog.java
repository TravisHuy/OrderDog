package com.nhathuy.orderdogbackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.ZonedDateTime;

@Entity
@Data
public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String name;
    private String description;
    private String imageUrl;
    private Gender gender;
    private float weight;
    private String location;
    private ZonedDateTime dateOfBirth;
    private PetLabel label;
}
