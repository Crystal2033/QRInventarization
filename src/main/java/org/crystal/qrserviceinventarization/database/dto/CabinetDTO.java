/**
 * Author: Kulikov Pavel (Crystal2033)
 * Date: 11.01.2024
 */

package org.crystal.qrserviceinventarization.database.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CabinetDTO {
    private Long id;

    @NotNull(message = "Name can not be null")
    @NotBlank
    private String name;

    private Long buildingId;
}
