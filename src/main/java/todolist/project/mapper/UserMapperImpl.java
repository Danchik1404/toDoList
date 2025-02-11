package todolist.project.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import todolist.project.dto.UserCreateDto;
import todolist.project.dto.UserResponseDto;
import todolist.project.dto.UserUpdateDto;
import todolist.project.model.User;

@Component
@RequiredArgsConstructor
public class UserMapperImpl implements UserMapper {

    private final PasswordEncoder passwordEncoder;

    @Override
    public User mapToEntity(UserCreateDto userCreateDto) {
        return User.builder()
                .username(userCreateDto.getUsername())
                .telegram(userCreateDto.getTelegram())
                .password(userCreateDto.getPassword())
                .build();
    }

    @Override
    public UserResponseDto mapToDto(User user) {
        return UserResponseDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .telegram(user.getTelegram())
                .role(user.getRole().getRole())
                .build();
    }

    @Override
    public void mapToDtoUpdate(UserUpdateDto userUpdateDto, User user) {
        if (userUpdateDto.getUsername() != null) {
            user.setUsername(userUpdateDto.getUsername());
        }
        if (userUpdateDto.getTelegram() != null) {
            user.setTelegram(userUpdateDto.getTelegram());
        }
        if (userUpdateDto.getPassword() != null) {
            passwordEncoder.encode(userUpdateDto.getPassword());
            user.setPassword(userUpdateDto.getPassword());
        }
    }
}
