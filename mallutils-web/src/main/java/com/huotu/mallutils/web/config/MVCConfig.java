/*
 * 版权所有:杭州火图科技有限公司
 * 地址:浙江省杭州市滨江区西兴街道阡陌路智慧E谷B幢4楼在地图中查看
 *
 * (c) Copyright Hangzhou Hot Technology Co., Ltd.
 * Floor 4,Block B,Wisdom E Valley,Qianmo Road,Binjiang District
 * 2013-2016. All rights reserved.
 */

package com.huotu.mallutils.web.config;

import com.huotu.mallutils.common.SysConstant;
import com.huotu.mallutils.web.interceptor.AuthorityInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import java.util.Arrays;
import java.util.List;

/**
 * Created by allan on 5/16/16.
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.huotu.mallutils.web")
@Import({SysConstant.class})
public class MVCConfig extends WebMvcConfigurerAdapter {
    /**
     * 静态资源处理,加在这里
     */
    private static String[] STATIC_RESOURCE_PATH = {
            "resource"
    };
    @Autowired
    private Environment env;
    @Autowired
    private AuthorityInterceptor authorityInterceptor;

    /**
     * for upload
     */
    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setDefaultEncoding("UTF-8");
        return resolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        super.addResourceHandlers(registry);
        for (String resourcePath : MVCConfig.STATIC_RESOURCE_PATH) {
            registry.addResourceHandler("/" + resourcePath + "/**").addResourceLocations("/" + resourcePath + "/");
        }
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new AttributeArgumentResolver());
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON));
        converters.add(converter);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authorityInterceptor).excludePathPatterns("/dwt/**");
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        super.configureViewResolvers(registry);
        registry.viewResolver(viewResolver());
    }

    public ThymeleafViewResolver viewResolver() {
        ServletContextTemplateResolver rootTemplateResolver = new ServletContextTemplateResolver();
        rootTemplateResolver.setPrefix("/views/");
        rootTemplateResolver.setSuffix(".html");
        rootTemplateResolver.setTemplateMode("HTML5");
        rootTemplateResolver.setCharacterEncoding("UTF-8");
        if (env.acceptsProfiles("container")) {
            rootTemplateResolver.setCacheable(true);
        } else {
            rootTemplateResolver.setCacheable(false);
        }

        SpringTemplateEngine engine = new SpringTemplateEngine();
        engine.setTemplateResolver(rootTemplateResolver);

        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setOrder(1);
        resolver.setCharacterEncoding("UTF-8");
        resolver.setTemplateEngine(engine);
        resolver.setContentType("text/html;charset=utf-8");
        return resolver;
    }
}
