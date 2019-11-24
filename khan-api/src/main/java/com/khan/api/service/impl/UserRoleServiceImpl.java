package com.khan.api.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.khan.api.entity.UserRole;
import com.khan.api.mapper.UserRoleMapper;
import com.khan.api.service.IUserRoleService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author khan
 * @since 2019-07-28
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

    @Override
    public void saveRole(List<String> roleIds, String userId) {
        super.remove(new UpdateWrapper<UserRole>().eq("user_id", userId));
        List<UserRole> userRoleList = roleIds.stream().map(roleId -> {
            UserRole userRole = new UserRole();
            userRole.setRoleId(roleId);
            userRole.setUserId(userId);
            return userRole;
        }).collect(Collectors.toList());
        super.saveBatch(userRoleList);
    }
}
