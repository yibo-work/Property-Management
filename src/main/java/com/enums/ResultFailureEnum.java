package com.enums;

import lombok.Getter;

/**
 * @author Clrvn
 */

@Getter
public enum ResultFailureEnum {
    /**
     * 返回错误信息枚举类
     */
    LOGIN_ERROR(1, "登录失败"),
    ADD_PROP_ERROR(2, "添加属性失败"),
    UPDATE_PROP_ERROR(3, "修改属性失败"),
    REMOVE_PROP_ERROR(4, "删除属性失败"),
    ;

    private Integer code;

    private String msg;

    ResultFailureEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
