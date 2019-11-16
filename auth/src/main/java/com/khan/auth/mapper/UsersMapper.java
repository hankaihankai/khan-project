package com.khan.auth.mapper;

import com.khan.auth.entity.Users;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.khan.auth.entity.vo.UsersVo;
import org.apache.ibatis.annotations.Mapper;import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author khan
 * @since 2019-07-28
 */
@Mapper
@Repository
public interface UsersMapper extends BaseMapper<Users> {

    UsersVo selectByUsername(@Param("username") String username);
}
