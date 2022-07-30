package com.maizi.demo.feign.config;

import feign.Response;
import feign.codec.ErrorDecoder;

/**
 * 重新实现feign的异常处理，捕捉restful接口返回的json格式的异常信息
 */
public class MyErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        Exception exception = null;
        return exception;
    }
}