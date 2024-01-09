package org.crystal.qrserviceinventarization.database.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Building {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String address; //TODO: make class Address, now don`t wanna waste time on it

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "branch_id") //shows that parent is branch, add column branch_id in building, bidirectional
    private Branch branch;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "building") //shows that parent of Cabinet is building
    private List<Cabinet> cabinets;
}
