package cn.common;

/**
 * 消息状态枚举
 */
public enum MsgStatus {

    SUCCESS(0, "success"),    //成功
    ERROR(1, "error"),    //错误

    ILLEGAL(2, "illegal args"),    //参数非法
    LOGIN(10, "need login");    //未登录

    private final int code;
    private final String desc;

    MsgStatus(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
