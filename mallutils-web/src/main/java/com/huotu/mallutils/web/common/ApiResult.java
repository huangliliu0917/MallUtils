/*
 * 版权所有:杭州火图科技有限公司
 * 地址:浙江省杭州市滨江区西兴街道阡陌路智慧E谷B幢4楼在地图中查看
 *
 * (c) Copyright Hangzhou Hot Technology Co., Ltd.
 * Floor 4,Block B,Wisdom E Valley,Qianmo Road,Binjiang District
 * 2013-2016. All rights reserved.
 */

package com.huotu.mallutils.web.common;

import com.huotu.mallutils.common.ienum.ResultCode;
import lombok.Data;

/**
 * Created by allan on 5/16/16.
 */
@Data
public class ApiResult {
    private int code;
    private String msg;
    private Object data;

    public static ApiResult resultWith(ResultCode resultCode, Object data) {
        ApiResult apiResult = new ApiResult();
        apiResult.msg = resultCode.getValue();
        apiResult.code = resultCode.getCode();
        apiResult.data = data;
        return apiResult;
    }

    public static ApiResult resultWith(ResultCode resultCode) {
        ApiResult apiResult = new ApiResult();
        apiResult.msg = resultCode.getValue();
        apiResult.code = resultCode.getCode();
        return apiResult;
    }

    public static ApiResult resultWith(ResultCode resultCode, String msg, Object data) {
        ApiResult apiResult = new ApiResult();
        apiResult.code = resultCode.getCode();
        apiResult.msg = msg;
        return apiResult;
    }
}
