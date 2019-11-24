package com.khan.api.service;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.khan.api.entity.Roles;
import com.khan.api.entity.vo.RoleTreeVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author khan
 * @since 2019-07-28
 */
public interface IRolesService extends IService<Roles> {

    List<RoleTreeVo> findAll();

    List<Roles> findUserRoles(String userId);

    IPage findPage(Page page, Roles objectUpdateWrapper);

    void edit(Roles roles);
}
