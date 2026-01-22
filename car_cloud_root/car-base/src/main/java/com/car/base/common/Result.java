package com.car.base.common;

/**
 * 统一返回结果类
 * @param <T> 数据类型
 */
public class Result<T> {
    
    /**
     * 状态码
     */
    private Integer code;
    
    /**
     * 是否成功
     */
    private Boolean success;
    
    /**
     * 返回消息
     */
    private String message;
    
    /**
     * 返回数据
     */
    private T data;

    public Result() {
    }

    public Result(Integer code, Boolean success, String message, T data) {
        this.code = code;
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public static <T> Result<T> success(T data) {
        return new Result<>(200, true, "操作成功", data);
    }
    
    public static <T> Result<T> success(T data, String message) {
        return new Result<>(200, true, message, data);
    }

    public static <T> Result<T> error(String message) {
        return new Result<>(500, false, message, null);
    }
    
    public static <T> Result<T> error(Integer code, String message) {
        return new Result<>(code, false, message, null);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
