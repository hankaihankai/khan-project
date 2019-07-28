package com.khan.auth.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.khan.auth.entity.Users;
import com.khan.auth.mapper.UsersMapper;
import com.khan.auth.service.IUsersService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author khan
 * @since 2019-07-28
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements IUsersService {


}
