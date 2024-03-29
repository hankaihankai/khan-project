package com.khan.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.khan.api.entity.RoleMenus;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author khan
 * @since 2019-07-28
 */
public interface IRoleMenusService extends IService<RoleMenus> {

    void saveMenu(List<String> menuIds, String id);
}
