package com.maizi.modle;

import lombok.Getter;

import java.util.Arrays;

/**
 * @version 1.0
 * @author: MaiZi
 * @date: 2022/8/4 06:30
 */
@Getter
public enum StatusEnum {

    FINISH(1, "订单完成"), NOTFINISH(0, "订单未完成");


    private Integer code;
    private String msg;

    StatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static StatusEnum ofResult(int code) {
        return Arrays.stream(values()).filter(item -> item.getCode() == code).findFirst().orElse(null);
    }
}
