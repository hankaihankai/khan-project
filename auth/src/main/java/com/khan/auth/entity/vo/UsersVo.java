package com.khan.auth.entity.vo;

import com.khan.auth.entity.Roles;
import com.khan.auth.entity.Users;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class UsersVo extends Users {

    private List<Roles> roles;


}
