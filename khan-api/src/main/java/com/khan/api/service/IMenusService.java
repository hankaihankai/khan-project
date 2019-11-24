package com.khan.api.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.khan.api.entity.Menus;
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
public interface IMenusService extends IService<Menus> {

    List<RoleTreeVo> findAll();

    List<Menus> findMenusRole(String roleId);

    IPage findPage(Page page, Menus menus);

    void edit(Menus menus);
}
