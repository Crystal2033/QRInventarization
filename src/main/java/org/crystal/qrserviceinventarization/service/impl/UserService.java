/**
 * Author: Kulikov Pavel (Crystal2033)
 * Date: 15.01.2024
 */

package org.crystal.qrserviceinventarization.service.impl;

import org.crystal.qrserviceinventarization.database.dto.UserDTO;
import org.crystal.qrserviceinventarization.database.dto.UserLoginDTO;
import org.crystal.qrserviceinventarization.database.dto.UserRegisterDTO;
import org.crystal.qrserviceinventarization.database.mapper.UserMapper;
import org.crystal.qrserviceinventarization.database.mapper.UserRegisterMapper;
import org.crystal.qrserviceinventarization.exception.AlreadyExistsException;
import org.crystal.qrserviceinventarization.exception.ResourceNotFoundException;
import org.crystal.qrserviceinventarization.exception.WrongDataException;
import org.crystal.qrserviceinventarization.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserRegisterMapper userRegisterMapper;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserRegisterMapper userRegisterMapper, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userRegisterMapper = userRegisterMapper;
        this.userMapper = userMapper;
    }


    public UserDTO saveUser(UserRegisterDTO userRegisterDTO) {
        userRepository.findUserByLogin(userRegisterDTO.getLogin()).ifPresent(
                (existingUser) -> {
                    throw new AlreadyExistsException(STR."User with login = \{userRegisterDTO.getLogin()} already exists.");
                }
        );
        var savedUser = userRepository.save(userRegisterMapper.toEntity(userRegisterDTO));
        return userMapper.toDto(savedUser);
    }

    public UserDTO tryLogin(UserLoginDTO userLoginDTO) {
        var user = userRepository.findUserByLogin(userLoginDTO.getLogin()).orElseThrow(
                () -> new ResourceNotFoundException(STR."User with login = \{userLoginDTO.getLogin()} not found.")
        );

        if (user.getPassword().contentEquals(userLoginDTO.getPassword())) {
            return userMapper.toDto(user);
        } else {
            throw new WrongDataException("Password is incorrect.");
        }
    }
}
