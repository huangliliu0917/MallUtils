package com.huotu.mallutils.web.config;

import com.huotu.mallutils.common.annotation.RequestAttribute;
import org.springframework.core.MethodParameter;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * Created by allan on 5/16/16.
 */
public class AttributeArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.getParameterAnnotation(RequestAttribute.class) != null;
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        String attributeName = methodParameter.getParameterAnnotation(RequestAttribute.class).value();
        if (StringUtils.isEmpty(attributeName)) {
            attributeName = methodParameter.getParameterName();
        }
        return nativeWebRequest.getAttribute(attributeName, RequestAttributes.SCOPE_REQUEST);
    }
}
