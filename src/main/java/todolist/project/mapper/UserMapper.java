package todolist.project.mapper;

import todolist.project.dto.UserCreateDto;
import todolist.project.dto.UserResponseDto;
import todolist.project.dto.UserUpdateDto;
import todolist.project.model.User;

public interface UserMapper {

    User mapToEntity(UserCreateDto userCreateDto);

    UserResponseDto mapToDto(User user);

    void mapToDtoUpdate(UserUpdateDto userUpdateDto, User user);
}
