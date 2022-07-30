package com.maizi.demo.content;

import lombok.Getter;

/**
 * @version 1.0
 * @author: MaiZi
 * @date: 2022/7/31 02:34
 */
@Getter
public enum CodeEnum {

    SUCCESS(10000, "成功"), ERROR(10001, "失败"), SYSTEM_ERROR(10004, "系统繁忙，请稍后重试！");


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