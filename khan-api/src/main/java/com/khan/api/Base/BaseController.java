package com.khan.api.Base;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class BaseController {

    @Autowired
    private HttpServletRequest request;

    protected Page page() {
        long currentPage = 0;
        long pageSize = 10;

        if (StrUtil.isNotEmpty(request.getParameter("currentPage"))) {
            currentPage = Long.parseLong(request.getParameter("currentPage"));
        }

        if (StrUtil.isNotEmpty(request.getParameter("pageSize"))) {
            pageSize = Long.parseLong(request.getParameter("pageSize"));
        }

        return new Page<>(currentPage, pageSize);
    }
}
