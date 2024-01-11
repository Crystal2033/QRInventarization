/**
 * Author: Kulikov Pavel (Crystal2033)
 * Date: 11.01.2024
 */

package org.crystal.qrserviceinventarization.database.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.crystal.qrserviceinventarization.database.model.Organization;

@Data
@AllArgsConstructor
public class OrganizationDTO { //for future if we don`t want to share secret data about org
    private Long id;

    @NotNull
    private String name;

//    public Organization toOrganization(){
//        return new Organization(id, name);
//    }
}
