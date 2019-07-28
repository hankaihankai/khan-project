package com.khan.auth.service.impl;

import com.khan.auth.entity.UserRole;
import com.khan.auth.mapper.UserRoleMapper;
import com.khan.auth.service.IUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
