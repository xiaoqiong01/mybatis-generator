package com.github.flying.cattle.mdg.gonggongwenjian;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * @author xiaoqiong
 * @Date : 2020年10月31日 15:19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    private String code;

    private String message;

    private Boolean status;

    private T data;


    /**
     * 成功
     *
     * @return
     */
    public static CommonResult success() {
        return success(null);
    }

    /**
     * 成功
     *
     * @param data
     * @return
     */
    public static CommonResult success(Object data) {
        CommonResult commonResult = new CommonResult();
        commonResult.setCode(CommonEnum.SUCCESS.getCode());
        commonResult.setMessage(CommonEnum.SUCCESS.getMsg());
        commonResult.setStatus(true);
        commonResult.setData(data);
        return commonResult;
    }


    /**
     * 失败
     */
    public static CommonResult error() {
        return error(null);
    }

    /**
     * 失败
     */
    public static CommonResult error(String code,String message) {
        CommonResult commonResult = new CommonResult();
        commonResult.setCode(code);
        commonResult.setMessage(message);
        commonResult.setStatus(false);
        return commonResult;
    }

    /**
     * 失败
     */
    public static CommonResult error(Object data) {
        CommonResult commonResult = new CommonResult();
        commonResult.setCode(CommonEnum.ERROR.getCode());
        commonResult.setMessage(CommonEnum.ERROR.getMsg());
        commonResult.setStatus(false);
        commonResult.setData(data);
        return commonResult;
    }

    /**
     * 失败
     */
    public static CommonResult error(String message) {
        CommonResult commonResult = new CommonResult();
        commonResult.setCode(CommonEnum.ERROR.getCode());
        commonResult.setMessage(message);
        commonResult.setStatus(false);
        return commonResult;
    }

    /**
     * 失败
     */
    public static CommonResult error(String message, Object data) {
        CommonResult commonResult = new CommonResult();
        commonResult.setCode(CommonEnum.ERROR.getCode());
        commonResult.setMessage(message);
        commonResult.setStatus(false);
        commonResult.setData(data);
        return commonResult;
    }



    /**
     * 失败
     */
    public static CommonResult error(String code, String message, Object data) {
        CommonResult commonResult = new CommonResult();
        commonResult.setCode(code);
        commonResult.setMessage(message);
        commonResult.setStatus(false);
        commonResult.setData(data);
        return commonResult;
    }


}
