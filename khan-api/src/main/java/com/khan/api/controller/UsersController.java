package com.khan.api.controller;


import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.khan.api.Base.BaseController;
import com.khan.api.entity.Users;
import com.khan.api.service.IUsersService;
import com.khan.tool.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author khan
 * @since 2019-07-28
 */
@RestController
@RequestMapping("/users")
public class UsersController extends BaseController {

    @Autowired
    private IUsersService usersService;

    @GetMapping("list")
    public ResponseResult<IPage<Users>> list(Users users) {
        QueryWrapper<Users> wrapper = new QueryWrapper<>();
        if (StrUtil.isNotEmpty(users.getUsername())) {
            wrapper.like("username", users.getUsername());
        }

        IPage<Users> page = usersService.page(page(), wrapper);
        return ResponseResult.ok(page);
    }

    @PostMapping("save")
    public ResponseResult save(Users users) {
        usersService.save(users);
        return ResponseResult.ok();
    }
}
