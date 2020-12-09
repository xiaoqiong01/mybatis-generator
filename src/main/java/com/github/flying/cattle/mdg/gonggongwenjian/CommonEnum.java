package com.github.flying.cattle.mdg.gonggongwenjian;

/*
 * @author xiaoqiong
 * @Date : 2020年10月31日 15:32
 */
public enum CommonEnum {

    // 数据操作错误定义
    SUCCESS("200", "请求成功!"),
    ERROR("400","请求失败!"),
    SIGNATURE_NOT_MATCH("401","请求的数字签名不匹配!"),
    NOT_FOUND("404", "未找到该资源!"),
    INTERNAL_SERVER_ERROR("500", "服务器内部错误!"),
    SERVER_BUSY("503","服务器正忙，请稍后再试!");

    private String code;

    private String msg;

    CommonEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }


    public String getMsg() {
        return msg;
    }


}
