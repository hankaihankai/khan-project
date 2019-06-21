package com.khan.zuul.mapper;

import com.khan.zuul.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.khan.zuul.entity.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author khan
 * @since 2019-06-11
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

	User selectByUserName(@Param("username") String username);
}
