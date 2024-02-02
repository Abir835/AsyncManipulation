package com.example.ASYNDM.ASYNDM.service.impl;

import com.example.ASYNDM.ASYNDM.dto.UserListDto;
import com.example.ASYNDM.ASYNDM.entity.User;
import com.example.ASYNDM.ASYNDM.repository.UserRepository;
import com.example.ASYNDM.ASYNDM.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Builder
@Setter
@Getter
@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder encoderPassword;
    @Override
    public User createUser(User user) {
        user.setPassword(encoderPassword.encode(user.getPassword()));
        user.setRole("ROLE_USER");
        return userRepository.save(user);
    }

    @Override
    public boolean checkedEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public List<UserListDto> findAll() {
        List<User> users = userRepository.findAll();
        List<UserListDto> userListDto = new ArrayList<>();

        for (User user : users) {
            UserListDto userDto = new UserListDto();
            userDto.setId(user.getId());
            userDto.setName(user.getName());
            userDto.setEmail(user.getEmail());
            userDto.setContact(user.getContact());
            userListDto.add(userDto);
        }
        return userListDto;
    }

}
