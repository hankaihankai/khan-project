package com.khan.api.entity;

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
    @TableName("roles")
    public class Roles implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String rolename;

    private String roleKey;


}
