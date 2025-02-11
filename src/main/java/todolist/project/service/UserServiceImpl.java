package todolist.project.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import todolist.project.dto.*;
import todolist.project.enums.ExceptionMessage;
import todolist.project.enums.Role;
import todolist.project.exception.NotFoundException;
import todolist.project.mapper.UserMapper;
import todolist.project.model.User;
import todolist.project.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserResponseDto createUser(UserCreateDto userCreateDto) {
        User user = userMapper.mapToEntity(userCreateDto);
        passwordEncoder.encode(user.getPassword());
        assignAnonRole(user);
        userRepository.save(user);
        return userMapper.mapToDto(user);
    }

    @Override
    public List<UserResponseDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(userMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public User getUserById(Long id) {
        return findUserById(id);
    }

    @Override
    public UserResponseDto updateUser(Long id, UserUpdateDto userUpdateDto) {
        User user = findUserById(id);
        userMapper.mapToDtoUpdate(userUpdateDto, user);
        userRepository.save(user);
        return userMapper.mapToDto(user);
    }

    @Override
    public void deleteUserById(Long id) {
        User user = findUserById(id);
        userRepository.deleteById(user.getId());
    }

    private User findUserById(Long id) {
        return userRepository.findById(id)
                        .orElseThrow(() -> new NotFoundException(ExceptionMessage.USER_NOT_FOUND.getMessage()));
    }

    private void assignAnonRole(User user) {
        user.setRole(Role.ANON);
    }
}
