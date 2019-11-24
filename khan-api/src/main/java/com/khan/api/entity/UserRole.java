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
@TableName("user_role")
@ApiModel("用户角色")
public class UserRole implements Serializable {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty("主键")
    private String id;
    @ApiModelProperty("用户id")
    private String userId;
    @ApiModelProperty("角色id")
    private String roleId;


}
