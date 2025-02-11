package todolist.project.service;

import todolist.project.dto.*;
import todolist.project.model.User;

import java.util.List;

public interface UserService {

    UserResponseDto createUser(UserCreateDto userCreateDto);

    List<UserResponseDto> getAllUsers();

    User getUserById(Long id);

    UserResponseDto updateUser(Long id,UserUpdateDto userUpdateDto);

    void deleteUserById(Long id);
}
