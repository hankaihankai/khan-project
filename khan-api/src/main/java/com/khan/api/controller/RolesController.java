package com.khan.api.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.khan.api.Base.BaseController;
import com.khan.api.entity.Roles;
import com.khan.api.entity.vo.RoleTreeVo;
import com.khan.api.service.IRoleMenusService;
import com.khan.api.service.IRolesService;
import com.khan.tool.utils.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author khan
 * @since 2019-07-28
 */
@RestController
@RequestMapping("/roles")
@Api(value = "角色管理", tags = {"角色管理"})
public class RolesController extends BaseController {

    @Autowired
    private IRolesService rolesService;
    @Autowired
    private IRoleMenusService roleMenusService;

    @ApiOperation(value = "分页查询角色列表")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "currentPage", value = "当前页", paramType = "query", dataType = "Long"),
            @ApiImplicitParam(name = "pageSize", value = "每页页数", paramType = "query", dataType = "Long"),
    })
    @GetMapping("list")
    private ResponseResult list(Roles roles) {
        IPage page = rolesService.findPage(this.page(), roles);
        return ResponseResult.ok(page);
    }

    @ApiOperation("查询菜单树形列表")
    @GetMapping("tree")
    public ResponseResult tree() {
        List<RoleTreeVo> list = rolesService.findAll();
        return ResponseResult.ok(list);
    }

    @ApiOperation("根据用户id 查询角色列表")
    @ApiImplicitParam(name = "userId", value = "用户id", paramType = "path")
    @GetMapping("/user/{userId}")
    public ResponseResult user(@PathVariable String userId) {
        List<Roles> list = rolesService.findUserRoles(userId);
        return ResponseResult.ok(list);
    }

    @ApiOperation("删除角色")
    @ApiImplicitParam(name = "roleId", value = "角色id", paramType = "path")
    @DeleteMapping("/delete/{roleId}")
    public ResponseResult delete(@PathVariable String roleId) {
        rolesService.removeById(roleId);
        return ResponseResult.ok();
    }

    @ApiOperation("保存角色")
    @PostMapping("save")
    public ResponseResult save(@RequestBody Roles roles) {
        rolesService.edit(roles);
        return ResponseResult.ok();
    }

    /**
     * 查看详情
     *
     * @param id 用户id
     * @return
     */
    @ApiOperation("查询角色详情")
    @ApiImplicitParam(name = "id", value = "用户id", paramType = "path")
    @GetMapping("/{id}")
    public ResponseResult details(@PathVariable String id) {
        Roles roles = rolesService.getById(id);
        return ResponseResult.ok(roles);
    }

    @ApiOperation("设置角色的菜单")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "id", value = "角色id", paramType = "path"),
            @ApiImplicitParam(name = "menuIds", value = "菜单id列表", paramType = "body", allowMultiple = true, dataType = "String")
    })
    @PostMapping("/menu/edit/{id}")
    public ResponseResult setRoles(@PathVariable String id, @RequestBody List<String> menuIds) {
        roleMenusService.saveMenu(menuIds, id);
        return ResponseResult.ok();
    }
}
