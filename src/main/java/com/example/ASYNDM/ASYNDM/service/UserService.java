package com.example.ASYNDM.ASYNDM.service;

import com.example.ASYNDM.ASYNDM.dto.UserListDto;
import com.example.ASYNDM.ASYNDM.dto.UserRegistrationDto;
import com.example.ASYNDM.ASYNDM.entity.User;
import com.example.ASYNDM.ASYNDM.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


@Service
public interface UserService {
    public User createUser(User user);

    public boolean checkedEmail(String email);

    List<UserListDto> findAll();

}
