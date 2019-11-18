package com.khan.api.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.khan.api.entity.Users;
import com.khan.api.entity.vo.UsersVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author khan
 * @since 2019-07-28
 */
@Mapper
public interface UsersMapper extends BaseMapper<Users> {

    UsersVo selectByUsername(@Param("username") String username);
}
