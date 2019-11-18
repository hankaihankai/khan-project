package com.khan.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {

    @GetMapping("/")
    public Map<String, Object> page() {
        Map<String, Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("msg", "请登录");
        return map;
    }


    @GetMapping("/main")
    public Map<String, Object> loginMain() {
        Map<String, Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("msg", "主页");
        return map;
    }
}
