package com.khan.api.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.khan.api.entity.UserRole;
import com.khan.api.mapper.UserRoleMapper;
import com.khan.api.service.IUserRoleService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author khan
 * @since 2019-07-28
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

}
