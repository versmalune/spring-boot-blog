package com.example.demo1.user.mapper;

import com.example.demo1.user.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    void saveUser(UserDto userDto);
    UserDto getUserAccount(String userId);
}
