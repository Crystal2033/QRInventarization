/**
 * Author: Kulikov Pavel (Crystal2033)
 * Date: 11.01.2024
 */

package org.crystal.qrserviceinventarization.database.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.crystal.qrserviceinventarization.database.model.Branch;
import org.crystal.qrserviceinventarization.database.model.Building;

@Data
@AllArgsConstructor
public class BuildingDTO {
    private Long id;

    private String address;

    private Long branchId;

//    public Building toBuilding(Branch branch) {
//        return new Building(
//                id,
//                address,
//                branch
//        );
//    }

}
