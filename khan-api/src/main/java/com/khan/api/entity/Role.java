package com.khan.api.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;

@Data
public class Role implements Serializable {
	@TableId
	private Long id;

	private String name;
}
