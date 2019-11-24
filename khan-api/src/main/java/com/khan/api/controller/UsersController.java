package com.khan.api.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.khan.api.Base.BaseController;
import com.khan.api.entity.Users;
import com.khan.api.service.IUserRoleService;
import com.khan.api.service.IUsersService;
import com.khan.tool.utils.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
@Api(value = "用户管理", tags = {"用户操作管理"})
public class UsersController extends BaseController {

    @Autowired
    private IUsersService usersService;
    @Autowired
    private IUserRoleService userRoleService;

    @GetMapping("list")
    public ResponseResult<IPage<Users>> list(Users users) {
        IPage<Users> page = usersService.selectPage(page(), users);
        return ResponseResult.ok(page);
    }

    @PostMapping("save")
    public ResponseResult save(@RequestBody Users users) {
        usersService.edit(users);
        return ResponseResult.ok();
    }

    /**
     * 查看详情
     *
     * @param id 用户id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseResult details(@PathVariable String id) {
        Users users = usersService.getById(id);
        return ResponseResult.ok(users);
    }

    /**
     * 删除用户
     *
     * @param id 用户id
     * @return
     */
    @ApiOperation(value = "删除用户", notes = "删除当前用户")
    @DeleteMapping("delete/{id}")
    public ResponseResult delete(@PathVariable String id) {
        usersService.removeById(id);
        return ResponseResult.ok();
    }

    @PostMapping("/role/edit/{id}")
    public ResponseResult setRoles(@PathVariable String id, @RequestBody List<String> roleIds) {
        userRoleService.saveRole(roleIds, id);
        return ResponseResult.ok();
    }

}
