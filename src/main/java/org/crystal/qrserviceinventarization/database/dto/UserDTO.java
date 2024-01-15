/**
 * Author: Kulikov Pavel (Crystal2033)
 * Date: 15.01.2024
 */

package org.crystal.qrserviceinventarization.database.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Long id;

    private String login;

    private String firstName;

    private String secondName;

    private Long organizationId;
}
