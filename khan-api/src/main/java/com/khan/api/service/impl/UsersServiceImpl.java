package com.khan.api.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.khan.api.entity.Users;
import com.khan.api.mapper.UsersMapper;
import com.khan.api.service.IUsersService;
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
