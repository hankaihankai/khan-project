package com.khan.api.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.khan.api.entity.Roles;
import com.khan.api.entity.UserRole;
import com.khan.api.entity.vo.RoleTreeVo;
import com.khan.api.mapper.RolesMapper;
import com.khan.api.mapper.UserRoleMapper;
import com.khan.api.service.IRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author khan
 * @since 2019-07-28
 */
@Service
public class RolesServiceImpl extends ServiceImpl<RolesMapper, Roles> implements IRolesService {

    @Autowired
    private RolesMapper rolesMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public List<RoleTreeVo> findAll() {
        List<RoleTreeVo> list = new ArrayList<>();

        List<Roles> roles = rolesMapper.selectList(new QueryWrapper<>());
        if (CollectionUtil.isNotEmpty(roles)) {
            roles.stream().forEach(role -> {
                RoleTreeVo roleTreeVo = new RoleTreeVo();
                roleTreeVo.setId(role.getId());
                roleTreeVo.setLabel(role.getRolename());
                list.add(roleTreeVo);
            });
        }
        return list;
    }

    @Override
    public List<Roles> findUserRoles(String userId) {
        List<UserRole> list = userRoleMapper.selectList(new QueryWrapper<UserRole>().eq("user_id", userId));
        if (CollectionUtil.isNotEmpty(list)) {
            Set<String> ids = list.stream().map(UserRole::getRoleId).collect(Collectors.toSet());
            return rolesMapper.selectBatchIds(ids);
        }
        return null;
    }

    @Override
    public IPage findPage(Page page, Roles roles) {
        QueryWrapper wrapper = new QueryWrapper();
        if (!StringUtils.isEmpty(roles.getRolename())) {
            wrapper.like("rolename", roles.getRolename());
        }
        IPage iPage = this.page(page, wrapper);
        return iPage;
    }

    @Override
    public void edit(Roles roles) {
        if (StringUtils.isEmpty(roles.getId())) {
            super.save(roles);
        } else {
            super.updateById(roles);
        }
    }
}
