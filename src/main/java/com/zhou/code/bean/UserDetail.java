package com.zhou.code.bean;

import com.zhou.code.enums.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.*;

public class UserDetail implements UserDetails {
    private final String username;
    private final String password;
    private List<Role> roles;
    private Set<SimpleGrantedAuthority> authorities = Collections.emptySet();
    public UserDetail(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public UserDetail(String username, String password, Set<SimpleGrantedAuthority> authorities) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<Role> roles = new ArrayList<>();
        roles.add(Role.ADMIN);
        roles.add(Role.DOCTOR);
        roles.add(Role.COMMON);
        List<GrantedAuthority> list  = new ArrayList<>();
        if(!roles.isEmpty()){
            for (Role role:roles){
                list.add(new SimpleGrantedAuthority(role.name()));
            }

        }


        return list;
    }
    @Override
    public String getPassword() {
        return password;
    }
    @Override
    public String getUsername() {
        return username;
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
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
