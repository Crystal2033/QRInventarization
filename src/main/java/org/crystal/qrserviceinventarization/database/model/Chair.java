package org.crystal.qrserviceinventarization.database.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class Chair extends AbstractInventarizedEntity {

    @Builder
    public Chair(Long id, byte[] image, String inventoryNumber, String name, Cabinet cabinet) {
        super(id, image, inventoryNumber, name, cabinet);
    }
}
