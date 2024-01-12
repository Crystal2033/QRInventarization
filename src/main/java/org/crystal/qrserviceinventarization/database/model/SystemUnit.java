package org.crystal.qrserviceinventarization.database.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class SystemUnit extends AbstractInventarizedEntity {
    @Builder
    public SystemUnit(Long id, byte[] image, String inventoryNumber, String name, Cabinet cabinet) {
        super(id, image, inventoryNumber, name, cabinet);
    }
}
