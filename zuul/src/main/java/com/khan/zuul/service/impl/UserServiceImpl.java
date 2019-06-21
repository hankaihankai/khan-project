package com.khan.zuul.service.impl;

import com.khan.zuul.entity.User;
import com.khan.zuul.mapper.UserMapper;
import com.khan.zuul.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author khan
 * @since 2019-06-11
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
