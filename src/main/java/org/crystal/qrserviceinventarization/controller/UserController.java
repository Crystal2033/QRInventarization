/**
 * Author: Kulikov Pavel (Crystal2033)
 * Date: 15.01.2024
 */

package org.crystal.qrserviceinventarization.controller;

import org.crystal.qrserviceinventarization.database.dto.UserDTO;
import org.crystal.qrserviceinventarization.database.dto.UserLoginDTO;
import org.crystal.qrserviceinventarization.database.dto.UserRegisterDTO;
import org.crystal.qrserviceinventarization.service.impl.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/auth")
    public ResponseEntity<UserDTO> tryLogin(UserLoginDTO userLoginDTO) {
        return new ResponseEntity<>(userService.tryLogin(userLoginDTO), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(UserRegisterDTO userRegisterDTO) {
        return new ResponseEntity<>(userService.saveUser(userRegisterDTO), HttpStatus.OK);
    }
}
