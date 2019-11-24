package com.khan.api.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.khan.api.Base.BaseController;
import com.khan.api.entity.Menus;
import com.khan.api.entity.vo.RoleTreeVo;
import com.khan.api.service.IMenusService;
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
@RequestMapping("/menus")
@Api(value = "菜单管理", tags = {"菜单管理"})
public class MenusController extends BaseController {

    @Autowired
    private IMenusService menusService;

    @ApiOperation(value = "获取菜单树形列表")
    @GetMapping("tree")
    public ResponseResult tree() {
        List<RoleTreeVo> list = menusService.findAll();
        return ResponseResult.ok(list);
    }

    @ApiOperation(value = "根据角色id查询菜单")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "roleId", value = "角色id", paramType = "path")
    })
    @GetMapping("/role/{roleId}")
    public ResponseResult user(@PathVariable String roleId) {
        List<Menus> list = menusService.findMenusRole(roleId);
        return ResponseResult.ok(list);
    }

    @ApiOperation(value = "分页查询菜单列表")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "currentPage", value = "当前页", paramType = "query", dataType = "Long"),
            @ApiImplicitParam(name = "pageSize", value = "每页页数", paramType = "query", dataType = "Long"),
    })
    @GetMapping("list")
    private ResponseResult list(Menus menus) {
        IPage page = menusService.findPage(this.page(), menus);
        return ResponseResult.ok(page);
    }

    @ApiOperation("删除菜单")
    @ApiImplicitParam(name = "menuId", value = "菜单id", paramType = "path")
    @DeleteMapping("/delete/{menuId}")
    public ResponseResult delete(@PathVariable String menuId) {
        menusService.removeById(menuId);
        return ResponseResult.ok();
    }

    @ApiOperation("保存菜单")
    @PostMapping("save")
    public ResponseResult save(@RequestBody Menus menus) {
        menusService.edit(menus);
        return ResponseResult.ok();
    }

    /**
     * 查看详情
     *
     * @param id 用户id
     * @return
     */
    @ApiOperation("查询菜单详情")
    @ApiImplicitParam(name = "id", value = "菜单id", paramType = "path")
    @GetMapping("/{id}")
    public ResponseResult details(@PathVariable String id) {
        Menus menus = menusService.getById(id);
        return ResponseResult.ok(menus);
    }
}
