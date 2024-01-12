package org.crystal.qrserviceinventarization.database.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class Projector extends AbstractInventarizedEntity {
    @Builder
    public Projector(Long id, byte[] image, String inventoryNumber, String name, Cabinet cabinet) {
        super(id, image, inventoryNumber, name, cabinet);
    }
}
