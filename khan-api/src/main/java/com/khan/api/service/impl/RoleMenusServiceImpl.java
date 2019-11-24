package com.khan.api.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.khan.api.entity.RoleMenus;
import com.khan.api.entity.UserRole;
import com.khan.api.mapper.RoleMenusMapper;
import com.khan.api.service.IRoleMenusService;
import org.springframework.stereotype.Service;

import java.util.List;
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
public class RoleMenusServiceImpl extends ServiceImpl<RoleMenusMapper, RoleMenus> implements IRoleMenusService {

    @Override
    public void saveMenu(List<String> menuIds, String roleId) {
        super.remove(new UpdateWrapper<RoleMenus>().eq("role_id", roleId));
        List<RoleMenus> roleMenusList = menuIds.stream().map(menuId -> {
            RoleMenus roleMenus = new RoleMenus();
            roleMenus.setRoleId(roleId);
            roleMenus.setMenusId(menuId);
            return roleMenus;
        }).collect(Collectors.toList());
        super.saveBatch(roleMenusList);
    }
}
