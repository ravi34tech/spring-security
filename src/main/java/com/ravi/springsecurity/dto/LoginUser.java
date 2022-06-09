package com.ravi.springsecurity.dto;

import com.ravi.springsecurity.model.UserInfo;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class LoginUser implements UserDetails {

    private String userName;
    private String password;
    private boolean accountNonLocked;
    private String roles;
    private List<GrantedAuthority> authorities;

    public LoginUser(){

    }

    public LoginUser(UserInfo info){
        this.userName = info.getUserName();
        this.password = info.getPassword();
        this.accountNonLocked = info.isAccountNonLocked();
        if("admin".equalsIgnoreCase(this.getUsername())){
            roles = "ADMIN";
        } else if("test".equalsIgnoreCase(this.getUsername())){
            roles = "TEST";
        } else {
            roles = "USER";
        }
        this.authorities = Arrays.stream(roles.split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        //TODO: need to modify later
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
