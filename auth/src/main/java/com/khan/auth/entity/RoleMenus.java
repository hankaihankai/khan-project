package com.khan.auth.entity;

    import com.baomidou.mybatisplus.annotation.TableName;
    import java.io.Serializable;
    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.experimental.Accessors;

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
    @TableName("role_menus")
    public class RoleMenus implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String roleId;

    private String menusId;


}
