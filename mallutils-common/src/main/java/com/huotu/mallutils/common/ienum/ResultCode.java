package com.huotu.mallutils.common.ienum;

/**
 * Created by allan on 5/16/16.
 */
public enum ResultCode implements ICommonEnum {
    SUCCESS(2000, "请求成功"),
    ERROR(5000, "系统请求失败");

    private Integer code;
    private String value;

    ResultCode(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
