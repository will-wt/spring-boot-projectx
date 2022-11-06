package com.will.demo.result;

/**
 * 错误码枚举
 * @author Will.WT
 * @date 2022/11/06 23:08
 */
public enum ResultCode {

    /**
     * 成功/success
     */
    SUCCESS(200, "success"),


    REQUEST_ERROR(400, "request error"),
    REQUEST_UNAUTHORIZED(401, "request unauthorized"),
    PERMISSION_EXPIRED(402, "permission expired"),
    REQUEST_FORBIDDEN(403, "request forbidden"),
    NOT_FOUND(404, "not found"),

    TOO_MANY_REQUEST(405, "too many request"),
    PARAMETER_ERROR(406, "parameter error"),
    REQUEST_TIMEOUT(408, "request timeout"),


    SYSTEM_ERROR(500, "system error"),
    UNKNOWN_EXCEPTION(501, "unknown exception"),
    SERVER_UNAVAILABLE(503, "server unavailable"),
    SERVER_TIMEOUT(504, "server timeout"),

    ;

    private int code;
    private String desc;

    ResultCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
