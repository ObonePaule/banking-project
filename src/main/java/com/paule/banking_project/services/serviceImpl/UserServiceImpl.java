package com.paule.banking_project.services.serviceImpl;

import com.paule.banking_project.dto.UserDto;
import com.paule.banking_project.models.User;
import com.paule.banking_project.repositories.UserRepository;
import com.paule.banking_project.services.UserService;
import com.paule.banking_project.validators.ObjectsValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ObjectsValidator<UserDto> objectsValidator;

    @Override
    public Integer save(UserDto userDto) {
        objectsValidator.validate(userDto);
        User user = UserDto.toEntity(userDto);
        return userRepository.save(user).getId();
    }

    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll().stream().map(UserDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public UserDto findById(Integer id) {
        return UserDto.fromEntity(userRepository.findById(id).get());
    }

    @Override
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }
}
