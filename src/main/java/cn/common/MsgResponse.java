package cn.common;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 向前台返回的VO，用于封装结果转换json
 */
public class MsgResponse<T> {

    private int status;//状态
    private String msg;//消息
    private T date;//返回的数据

    private MsgResponse(int status) {
        this.status = status;
    }

    private MsgResponse(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    private MsgResponse(int status, T date) {
        this.status = status;
        this.date = date;
    }

    private MsgResponse(int status, String msg, T date) {
        this.status = status;
        this.msg = msg;
        this.date = date;
    }

    public static <T> MsgResponse<T> createSuccess() {
        return new MsgResponse<>(MsgStatus.SUCCESS.getCode());
    }

    public static <T> MsgResponse<T> createSuccess(String msg) {
        return new MsgResponse<>(MsgStatus.SUCCESS.getCode(), msg);
    }

    public static <T> MsgResponse<T> createSuccess(T data) {
        return new MsgResponse<>(MsgStatus.SUCCESS.getCode(), data);
    }

    public static <T> MsgResponse<T> createSuccess(String msg, T data) {
        return new MsgResponse<>(MsgStatus.SUCCESS.getCode(), msg, data);
    }

    public static <T> MsgResponse<T> createError() {
        return new MsgResponse<>(MsgStatus.ERROR.getCode());
    }

    public static <T> MsgResponse<T> createError(String msg) {
        return new MsgResponse<>(MsgStatus.ERROR.getCode(), msg);
    }

    public static <T> MsgResponse<T> createILLEGAL(String msg) {
        return new MsgResponse<>(MsgStatus.ILLEGAL.getCode(), msg);
    }

    public static <T> MsgResponse<T> createLOGIN(String msg) {
        return new MsgResponse<>(MsgStatus.LOGIN.getCode(), msg);
    }

    public static <T> MsgResponse<T> createError(T data) {
        return new MsgResponse<>(MsgStatus.ERROR.getCode(), data);
    }

    public static <T> MsgResponse<T> createError(String msg, T data) {
        return new MsgResponse<>(MsgStatus.ERROR.getCode(), msg, data);
    }

    @JsonIgnore
    public boolean isSuccess() {
        return this.status == MsgStatus.SUCCESS.getCode();
    }

    public int getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public T getDate() {
        return date;
    }
}
