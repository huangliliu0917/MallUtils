package com.huotu.mallutils.web.common;

import com.huotu.mallutils.common.ienum.ResultCode;

/**
 * Created by allan on 5/16/16.
 */
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
