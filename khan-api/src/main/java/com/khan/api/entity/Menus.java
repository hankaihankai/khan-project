package com.khan.api.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 *
 * @author khan
 * @since 2019-07-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("menus")
@ApiModel("菜单")
public class Menus implements Serializable {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty("主键")
    private String id;
    @ApiModelProperty("菜单名")
    private String name;
    @ApiModelProperty("菜单路径")
    private String url;
    @ApiModelProperty("菜单图片")
    private String icon;
    @ApiModelProperty("状态")
    private Integer state;

}
