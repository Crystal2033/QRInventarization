package org.crystal.qrserviceinventarization.database.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min = 5)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_id")
    private Organization organization;

    @OneToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private City city;

    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "branch",
            cascade = CascadeType.ALL)
    private List<Building> buildings;
}
