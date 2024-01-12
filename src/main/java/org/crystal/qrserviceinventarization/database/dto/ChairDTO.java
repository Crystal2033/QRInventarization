/**
 * Author: Kulikov Pavel (Crystal2033)
 * Date: 11.01.2024
 */

package org.crystal.qrserviceinventarization.database.dto;

import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.crystal.qrserviceinventarization.database.model.Cabinet;
import org.crystal.qrserviceinventarization.database.model.Chair;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChairDTO { //it`s more convenient to transfer this class without cabinet, I will get cabinet by id in method
    private Long id;

    @Lob
    private byte[] image;

    @NotNull(message = "Name can not be null")
    @NotBlank
    private String name;

    @NotNull(message = "Inventory number can not be null")
    private String inventoryNumber;

    private Long cabinetId;
}
