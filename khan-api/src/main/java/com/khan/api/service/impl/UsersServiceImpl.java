package com.khan.api.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.khan.api.entity.Roles;
import com.khan.api.entity.UserRole;
import com.khan.api.entity.Users;
import com.khan.api.mapper.RolesMapper;
import com.khan.api.mapper.UserRoleMapper;
import com.khan.api.mapper.UsersMapper;
import com.khan.api.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author khan
 * @since 2019-07-28
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements IUsersService {

    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Autowired
    private RolesMapper rolesMapper;

    @Override
    public void edit(Users users) {
        if (StrUtil.isNotEmpty(users.getId())) {
            usersMapper.updateById(users);
        } else {
            users.setCreateTime(new Date());
            usersMapper.insert(users);
        }
    }

    @Override
    public IPage<Users> selectPage(Page page, Users users) {
        QueryWrapper<Users> wrapper = new QueryWrapper<>();
        if (StrUtil.isNotEmpty(users.getUsername())) {
            wrapper.like("username", users.getUsername());
        }
        IPage iPage = usersMapper.selectPage(page, wrapper);
        List<Users> records = iPage.getRecords();
        if (CollectionUtil.isNotEmpty(records)) {
            records.forEach(item -> {
                List<UserRole> userRoleList = userRoleMapper.selectList(new QueryWrapper<UserRole>().eq("user_id", item.getId()));
                if (CollectionUtil.isNotEmpty(userRoleList)) {
                    Set<String> ids = userRoleList.stream().map(UserRole::getRoleId).collect(Collectors.toSet());
                    List<Roles> roles = rolesMapper.selectBatchIds(ids);
                    if (CollectionUtil.isNotEmpty(roles)) {
                        String collect = roles.stream().map(Roles::getRolename).collect(Collectors.joining(","));
                        item.setRoleName(collect);
                    }
                }
            });
        }
        return iPage;
    }


}
