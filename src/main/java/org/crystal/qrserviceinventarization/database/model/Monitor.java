package org.crystal.qrserviceinventarization.database.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class Monitor extends AbstractInventarizedEntity {
    @Builder
    public Monitor(Long id, byte[] image, String inventoryNumber, String name, Cabinet cabinet) {
        super(id, image, inventoryNumber, name, cabinet);
    }
}
