package org.crystal.qrserviceinventarization.database.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min = 5)
    private String name;

//    @OneToMany(
//            mappedBy = "organization",
//            fetch = FetchType.LAZY,
//            cascade = CascadeType.ALL
//    )
//    private List<Branch> branches;

    //TODO: Add date
}
