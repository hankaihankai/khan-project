package com.khan.api.service.oauth;

import com.google.common.collect.Lists;
import com.khan.api.entity.Roles;
import com.khan.api.entity.vo.UsersVo;
import com.khan.api.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserDetailsService, Serializable {

    @Autowired
    private UsersMapper usersMapper;

    public static void main(String[] args) {
        System.out.println(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("123456"));
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsersVo usersVo = usersMapper.selectByUsername(username);
        if (usersVo == null) {
            throw new RuntimeException("没有这个用户");
        }
        List<Roles> roles = usersVo.getRoles();
        List<GrantedAuthority> grantedAuthorityList = Lists.newArrayList();
        if (!CollectionUtils.isEmpty(roles)) {
            grantedAuthorityList = roles.stream().map(role -> (GrantedAuthority) () -> role.getRoleKey()).collect(Collectors.toList());
        }

        return new User(usersVo.getUsername(), usersVo.getPassword(), grantedAuthorityList);
    }
}
