package com.khan.api.entity.vo;

import lombok.Data;

@Data
public class RoleTreeVo {
    private String label;

    private String id;

    private RoleTreeVo children;
}
