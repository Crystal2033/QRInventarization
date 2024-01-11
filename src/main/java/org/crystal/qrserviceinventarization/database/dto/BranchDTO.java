/**
 * Author: Kulikov Pavel (Crystal2033)
 * Date: 11.01.2024
 */

package org.crystal.qrserviceinventarization.database.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.crystal.qrserviceinventarization.database.model.Branch;
import org.crystal.qrserviceinventarization.database.model.City;
import org.crystal.qrserviceinventarization.database.model.Organization;

@Data
@AllArgsConstructor
public class BranchDTO {

    private Long id;

    @NotNull
    private String name;

    private String cityName;

    private Long organizationId;

    private Long cityId;

//    public Branch toBranch(Organization organization, City city) {
//        return new Branch(
//                id,
//                name,
//                organization,
//                city
//        );
//    }
}
