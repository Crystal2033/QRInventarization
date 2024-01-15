/**
 * Author: Kulikov Pavel (Crystal2033)
 * Date: 15.01.2024
 */

package org.crystal.qrserviceinventarization.exception;

public class WrongDataException extends RuntimeException {
    public WrongDataException(String reason) {
        super(reason);
    }
}
