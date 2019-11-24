package com.khan.api.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author khan
 * @since 2019-07-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("roles")
@ApiModel("角色")
public class Roles implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
    @ApiModelProperty("主键")
    private String id;
    /**
     * 角色名
     */
    @ApiModelProperty("角色名")
    private String rolename;
    /**
     * 角色key
     */
    @ApiModelProperty("角色key")
    private String roleKey;


}
