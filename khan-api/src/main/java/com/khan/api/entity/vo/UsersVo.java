package com.khan.api.entity.vo;

import com.khan.api.entity.Roles;
import com.khan.api.entity.Users;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class UsersVo extends Users {

    private List<Roles> roles;


}
