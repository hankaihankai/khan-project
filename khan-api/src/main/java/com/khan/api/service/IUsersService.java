package com.khan.api.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.khan.api.entity.Users;

import java.util.List;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author khan
 * @since 2019-07-28
 */
public interface IUsersService extends IService<Users> {
    void edit(Users users);

    IPage<Users> selectPage(Page page, Users users);
}
