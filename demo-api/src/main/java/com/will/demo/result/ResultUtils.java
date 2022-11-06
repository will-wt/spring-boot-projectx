package com.will.demo.result;

/**
 * @author Will.WT
 * @date 2022/11/06 23:38
 */
public class ResultUtils {

    public static <T> Result build(T data){
        return new Result(data);
    }

    public static Result build(int code, String message){
        return new Result(code, message, null);
    }

    public static void setProperties(Result<?> result, int code, String message){
        result.setCode(code);
        result.setMessage(message);
    }

    public static void setProperties(Result<?> result, ResultCode resultCode){
        result.setCode(resultCode.getCode());
        result.setMessage(resultCode.getDesc());
    }

}
