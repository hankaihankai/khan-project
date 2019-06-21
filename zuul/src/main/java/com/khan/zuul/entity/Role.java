package com.khan.zuul.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("test_role")
public class Role implements GrantedAuthority, Serializable {
	private static final long serialVersionUID = 1L;
	@TableId
	private Long id;

	private String name;

	@Override
	public String getAuthority() {
		return name;
	}
}
