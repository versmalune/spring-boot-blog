package com.example.demo1.user.mapper;

import com.example.demo1.user.model.UserVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    void saveUser(UserVO userVO);
    UserVO getUserAccount(String userName);
}
