/**
 * Author: Kulikov Pavel (Crystal2033)
 * Date: 12.01.2024
 */

package org.crystal.qrserviceinventarization.database.dto;

import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AbstractInventarizedDTO {
    protected Long id;

    @Lob
    protected byte[] image;

    @NotNull(message = "Name can not be null")
    @NotBlank
    protected String name;

    @NotNull(message = "Inventory number can not be null")
    protected String inventoryNumber;

    protected Long cabinetId;
}
