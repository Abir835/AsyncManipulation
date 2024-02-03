package com.example.ASYNDM.ASYNDM.mapper;

import com.example.ASYNDM.ASYNDM.dto.UserListDto;
import com.example.ASYNDM.ASYNDM.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserListDto entityToDto(User user);
}
