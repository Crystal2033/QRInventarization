package org.crystal.qrserviceinventarization.database.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Building {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String address; //TODO: make class Address, now don`t wanna waste time on it

    @ManyToOne(fetch = FetchType.LAZY)
    private Branch branch;
}
