package com.maizi.demo.module;

import com.maizi.demo.content.CodeEnum;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @version 1.0
 * @author: MaiZi
 * @date: 2022/7/31 02:32
 */


@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class RR<T> implements Serializable {

    private static final long serialVersionUID = -5042143006042883190L;
    private Boolean success;

    private Integer code;

    private String message;

    private T data;

    public static <T> RR<T> succeed() {
        return of(true, CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMsg(), null);
    }

    public static <T> RR<T> succeed(String msg, T model) {
        return of(true, CodeEnum.SUCCESS.getCode(), msg, model);
    }

    public static <T> RR<T> succeed(T model) {
        return of(true, CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMsg(), model);
    }

    public static <T> RR<T> failed(String msg) {
        return of(false, CodeEnum.ERROR.getCode(), msg, null);
    }

    public static <T> RR<T> failed(String msg, T model) {
        return of(false, CodeEnum.ERROR.getCode(), msg, model);
    }

    public static <T> RR<T> of(Boolean success, Integer code, String msg, T data) {
        return new RR<T>(success, code, msg, data);
    }

    /**
     * 布尔判断
     */
    public static <T> RR<T> auto(boolean flag, String message) {
        return flag ? RR.succeed() : RR.failed(message);
    }

    /**
     * 数据判断
     */
    public static <T> RR<T> checkNull(T result, String message) {
        return (result != null) ? RR.succeed(result) : RR.failed(message);
    }
}
