package com.example.ASYNDM.ASYNDM.service;

import com.example.ASYNDM.ASYNDM.dto.UserRegistrationDto;
import com.example.ASYNDM.ASYNDM.entity.User;
import com.example.ASYNDM.ASYNDM.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Builder
@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository repository;

    public String userRegistration(UserRegistrationDto userRegistrationDto) {

        User user = new User();
        user.setContact(userRegistrationDto.getContact());
        user.setEmail(userRegistrationDto.getEmail());
        user.setName(userRegistrationDto.getName());
        user.setPassword(userRegistrationDto.getPassword());

        repository.save(user);

        return "User Registration Successfully.";
    }

    public String validateUser(String email, String pwd) {
        User users = repository.findByEmailAndPassword(email, pwd);

        if (Objects.isNull(users)) {
            return "Invalid Credentials. Please Try again";
        } else {
            return "Welcome to Site, " + email;
        }
    }
}
