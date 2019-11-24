package com.khan.api.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.khan.api.entity.Menus;
import com.khan.api.entity.RoleMenus;
import com.khan.api.entity.vo.RoleTreeVo;
import com.khan.api.mapper.MenusMapper;
import com.khan.api.mapper.RoleMenusMapper;
import com.khan.api.service.IMenusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class MenusServiceImpl extends ServiceImpl<MenusMapper, Menus> implements IMenusService {

    @Autowired
    private RoleMenusMapper roleMenusMapper;
    @Autowired
    private MenusMapper menusMapper;

    @Override
    public List<RoleTreeVo> findAll() {
        List<RoleTreeVo> list = new ArrayList<>();
        List<Menus> menusList = super.list();
        if (CollectionUtil.isNotEmpty(menusList)) {
            menusList.stream().forEach(menus -> {
                RoleTreeVo roleTreeVo = new RoleTreeVo();
                roleTreeVo.setId(menus.getId());
                roleTreeVo.setLabel(menus.getName() + "====" + menus.getUrl());
                list.add(roleTreeVo);
            });
        }
        return list;
    }

    @Override
    public List<Menus> findMenusRole(String roleId) {
        List<RoleMenus> list = roleMenusMapper.selectList(new QueryWrapper<RoleMenus>().eq("role_id", roleId));
        if (CollectionUtil.isNotEmpty(list)) {
            Set<String> ids = list.stream().map(RoleMenus::getMenusId).collect(Collectors.toSet());
            List<Menus> menusList = menusMapper.selectBatchIds(ids);
            return menusList;
        }
        return null;
    }

    @Override
    public IPage findPage(Page page, Menus menus) {
        QueryWrapper wrapper = new QueryWrapper();
        if (StrUtil.isNotEmpty(menus.getName())) {
            wrapper.like("name", menus.getName());
        }

        if (StrUtil.isNotEmpty(menus.getUrl())) {
            wrapper.like("url", menus.getUrl());
        }
        IPage<Menus> iPage = super.page(page, wrapper);
        return iPage;
    }

    @Override
    public void edit(Menus menus) {
        if (StrUtil.isNotEmpty(menus.getId())) {
            super.updateById(menus);
        } else {
            super.save(menus);
        }
    }
}
