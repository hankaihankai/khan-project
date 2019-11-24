package com.khan.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.khan.api.entity.UserRole;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author khan
 * @since 2019-07-28
 */
public interface IUserRoleService extends IService<UserRole> {

    void saveRole(List<String> roleIds, String id);
}
