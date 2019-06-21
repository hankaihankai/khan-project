package com.khan.api.entity.vo;

import com.khan.api.entity.JWT;
import com.khan.api.entity.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
public class UserVo implements Serializable {

	private JWT jwt;

	private User user;
}
