package com.maizi.modle;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @version 1.0
 * @author: MaiZi
 * @date: 2022/8/4 05:14
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class R<T> implements Serializable {

    private static final long serialVersionUID = -5042143006042883190L;
    //@ApiModelProperty(value = "请求状态标志位 [true | false]")
    private Boolean success;

    //@ApiModelProperty(value = "状态码")
    private Integer code;

    //@ApiModelProperty(value = "消息")
    private String message;

    //@ApiModelProperty(value = "结果集")
    private T data;

    public static <T> R<T> succeed() {
        return of(true, CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMsg(), null);
    }

    public static <T> R<T> succeed(String msg, T model) {
        return of(true, CodeEnum.SUCCESS.getCode(), msg, model);
    }

    public static <T> R<T> succeed(T model) {
        return of(true, CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMsg(), model);
    }

    public static <T> R<T> failed(String msg) {
        return of(false, CodeEnum.ERROR.getCode(), msg, null);
    }

    public static <T> R<T> failed(String msg, T model) {
        return of(false, CodeEnum.ERROR.getCode(), msg, model);
    }

    public static <T> R<T> of(Boolean success, Integer code, String msg, T data) {
        return new R<T>(success, code, msg, data);
    }

    /**
     * 布尔判断
     */
    public static <T> R<T> auto(boolean flag, String message) {
        return flag ? R.succeed() : R.failed(message);
    }

    /**
     * 数据判断
     */
    public static <T> R<T> checkNull(T result, String message) {
        return (result != null) ? R.succeed(result) : R.failed(message);
    }
}
