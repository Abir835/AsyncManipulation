package com.example.ASYNDM.ASYNDM.service.impl;

import com.example.ASYNDM.ASYNDM.entity.User;
import com.example.ASYNDM.ASYNDM.repository.UserRepository;
import com.example.ASYNDM.ASYNDM.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

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
}
