/*
 * 版权所有:杭州火图科技有限公司
 * 地址:浙江省杭州市滨江区西兴街道阡陌路智慧E谷B幢4楼在地图中查看
 *
 * (c) Copyright Hangzhou Hot Technology Co., Ltd.
 * Floor 4,Block B,Wisdom E Valley,Qianmo Road,Binjiang District
 * 2013-2016. All rights reserved.
 */

package com.huotu.mallutils.web.interceptor;

import com.huotu.mallutils.common.SysConstant;
import com.huotu.mallutils.common.utils.CookieHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by allan on 5/16/16.
 */
@Component
public class AuthorityInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private Environment environment;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String customerIdStr = CookieHelper.getCookieVal(request, "UserID");
        if (customerIdStr == null && environment.acceptsProfiles("development")) {
            customerIdStr = "296";
        }
        if (StringUtils.isEmpty(customerIdStr)) {
            response.sendRedirect(SysConstant.HUOBANMALL_LOGIN);
            return false;
        }
        request.setAttribute("customerId", customerIdStr);
        return true;
    }
}
