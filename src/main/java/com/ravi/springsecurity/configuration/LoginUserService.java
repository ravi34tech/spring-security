package com.ravi.springsecurity.configuration;

import com.ravi.springsecurity.dto.LoginUser;
import com.ravi.springsecurity.model.UserInfo;
import com.ravi.springsecurity.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginUserService implements UserDetailsService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserInfo> userInfo = userInfoRepository.findByUserName(username);
        userInfo.orElseThrow(() -> new UsernameNotFoundException("Invalid username: "+username));
        LoginUser loginUser = new LoginUser(userInfo.get());

        loginUser.setPassword(new BCryptPasswordEncoder().encode(loginUser.getPassword()));
        // here in DB not storing password as encrypted that's why we're encoding and setting in user details
        System.out.println(loginUser);
        return loginUser;
    }
}
