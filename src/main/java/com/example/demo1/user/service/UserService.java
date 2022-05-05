package com.example.demo1.user.service;

import com.example.demo1.user.dto.UserDto;
import com.example.demo1.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserMapper userMapper;
    @Transactional
    public void joinUser(UserDto userDto){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        userDto.setUserPw(passwordEncoder.encode(userDto.getPassword()));
        userDto.setUserAuth("USER");
        userMapper.saveUser(userDto);
    }
    @Override
    public UserDto loadUserByUsername(String userId) throws UsernameNotFoundException {
        UserDto userDto = userMapper.getUserAccount(userId);
        if (userDto == null) {
            throw new UsernameNotFoundException("User Not Authorized");
        }
        return userDto;
    }
}