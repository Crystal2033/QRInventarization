package org.crystal.qrserviceinventarization.database.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.crystal.qrserviceinventarization.database.dto.BranchDTO;
import org.springframework.context.annotation.Bean;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "organization_id")
    private Organization organization;

    @OneToOne(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private City city;

//    public BranchDTO toBranchDTO(){
//        return new BranchDTO(
//                id,
//                name,
//                city.getName()
//        );
//    }
//    @OneToMany(fetch = FetchType.LAZY,
//            mappedBy = "branch",
//            cascade = CascadeType.ALL)
//    private List<Building> buildings;
}
