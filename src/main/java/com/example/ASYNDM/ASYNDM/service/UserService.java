package com.example.ASYNDM.ASYNDM.service;

import com.example.ASYNDM.ASYNDM.dto.UserListDto;
import com.example.ASYNDM.ASYNDM.entity.User;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;


@Service
public interface UserService {
    public User createUser(User user);

    public boolean checkedEmail(String email);

    List<UserListDto> findAll();

}
