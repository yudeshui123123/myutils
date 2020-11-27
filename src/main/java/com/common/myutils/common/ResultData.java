package com.common.myutils.common;

import lombok.Data;

/**
 * TODO
 *
 * @author yds
 * @version 1.0
 * @date 2020/9/8 16:57
 * @description: 返回结果封装类
 */
@Data
public class ResultData<T> {

    //成功状态码
    public static final String CODE_STATE_SUCCESS = "200";
    //失败状态码
    public static final String CODE_STATE_FAILURE = "202";

    private String code;
    private String msg;
    private T data;

    public ResultData() {
    }

    public ResultData(String code) {
        this.code = code;
    }

    public ResultData(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultData(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 返回成功消息状态
     * @return
     */
    public static ResultData success(){
        return new ResultData(CODE_STATE_SUCCESS);
    }

    /**
     * 返回成功消息
     * @return
     */
    public static ResultData successMsg(String msg){
        return new ResultData(CODE_STATE_SUCCESS,msg);
    }

    /**
     * 返回失败状态
     * @return
     */
    public static ResultData failure(){
        return new ResultData(CODE_STATE_FAILURE);
    }

    /**
     * 自己定义消息
     * @return
     */
    public static <T>ResultData build(String code,String msg,T data){
        return new ResultData(code,msg,data);
    }

}
