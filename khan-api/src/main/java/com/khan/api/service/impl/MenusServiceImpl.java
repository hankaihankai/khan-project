package com.khan.api.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.khan.api.entity.Menus;
import com.khan.api.mapper.MenusMapper;
import com.khan.api.service.IMenusService;
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
public class MenusServiceImpl extends ServiceImpl<MenusMapper, Menus> implements IMenusService {

}
