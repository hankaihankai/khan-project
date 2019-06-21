package com.khan.zuul.service.impl;

import com.khan.zuul.entity.Role;
import com.khan.zuul.mapper.RoleMapper;
import com.khan.zuul.service.IRoleService;
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
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
