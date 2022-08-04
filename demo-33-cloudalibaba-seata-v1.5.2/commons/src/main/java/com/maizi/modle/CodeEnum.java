package com.maizi.modle;

import lombok.Getter;

/**
 * <p>Title: CodeEnum</p>
 * <p>Description: 状态枚举</p>
 *
 * @version 1.0
 * @date 2022/02/10 17:02
 */
@Getter
public enum CodeEnum {

    SUCCESS(10000, "成功"),
    ERROR(10001, "失败"),
    SYSTEM_ERROR(10004, "系统繁忙，请稍后重试！"),
    TOKEN_INVALID(10010, "无效的登录信息"),
    CODE_INVALID(10011, "code被使用"),
    USER_INVALID(10100, "用户不存在"),
    USER_INFO(10102, "用户信息异常");

    private Integer code;
    private String msg;

    CodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static CodeEnum ofResultType(int code) {
        for (CodeEnum value : values()) {
            if (value.getCode().intValue() == code) {
                return value;
            }
        }

        return ERROR;
    }
}