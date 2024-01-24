/**
 * Author: Kulikov Pavel (Crystal2033)
 * Date: 16.01.2024
 */

package org.crystal.qrserviceinventarization.exception;

public class AlreadyExistsException extends RuntimeException {
    public AlreadyExistsException(String reason) {
        super(reason);
    }
}
