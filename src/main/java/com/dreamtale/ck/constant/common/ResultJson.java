package com.dreamtale.ck.constant.common;

import org.apache.commons.lang3.StringUtils;

public class ResultJson<T> {

    private int code = 200;

    /**
     * 返回正常，状态 0
     */
    public static final int RESULT_OK = 200;

    /**
     * 返回错误，状态400
     */
    private static final int RESULT_ERROR = 400;

    private String message = "ok";

    private String detail;

    private T data;

    private long timestamp;

    public ResultJson(){

    }

    public ResultJson(int code, String message, T data, String detail) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.detail = detail;
        this.timestamp = System.currentTimeMillis();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
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

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public static <T> ResultJson<T> ok(T data){
        ResultJson<T> resultJson = new ResultJson<>();
        resultJson.code = RESULT_OK;
        resultJson.message = "ok";
        resultJson.timestamp = System.currentTimeMillis();
        resultJson.data = data;
        return resultJson;
    }
    public static <T> ResultJson<T> ok(T data,String msg){
        ResultJson<T> resultJson = new ResultJson<>();
        resultJson.code = RESULT_OK;
        resultJson.message = msg;
        resultJson.timestamp = System.currentTimeMillis();
        resultJson.data = data;
        return resultJson;
    }
    /**
     * 构造正常对象
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ResultJson<T> success(T data){
        ResultJson<T> resultJson = new ResultJson<>();
        resultJson.code = RESULT_OK;
        resultJson.message = "success";
        resultJson.timestamp = System.currentTimeMillis();
        resultJson.data = data;
        return resultJson;
    }

    /**
     * 重载无参正常返回对象
     * @param <T>
     * @return
     */
    public static <T> ResultJson<T> ok(){
        return ok(null);
    }

    /**
     * 构造错误对象
     * @param code
     * @return
     */
    public static <T> ResultJson<T> badRequest(int code){
        ResultJson<T> resultJson = new ResultJson<>();
        resultJson.code = code;
        resultJson.message = "发生错误!";
        resultJson.timestamp = System.currentTimeMillis();
        return resultJson;
    }
    /**
     * 构造错误对象，默认code=400
     * @param message
     * @return
     */
    public static <T> ResultJson<T> badRequest(String message){
        ResultJson<T> resultJson = new ResultJson<>();
        resultJson.code = RESULT_ERROR;
        resultJson.message = StringUtils.defaultIfEmpty(message,"发生错误!");
        resultJson.timestamp = System.currentTimeMillis();
        return resultJson;
    }
    /**
     * 构造错误对象，默认code=400
     * @param message
     * @return
     */
    public static <T> ResultJson<T> badRequest(String message, String detail){
        ResultJson<T> resultJson = new ResultJson<>();
        resultJson.code = RESULT_ERROR;
        resultJson.message = StringUtils.defaultIfEmpty(message,"发生错误!");
        resultJson.detail = StringUtils.defaultIfEmpty(detail,"发生错误!");
        resultJson.timestamp = System.currentTimeMillis();
        return resultJson;
    }
    /**
     * 构造错误对象
     * @param code
     * @param message
     * @return
     */
    public static <T> ResultJson<T> badRequest(int code, String message){
        ResultJson<T> resultJson = new ResultJson<>();
        resultJson.code = code;
        resultJson.message = StringUtils.defaultIfEmpty(message,"发生错误!");
        resultJson.timestamp = System.currentTimeMillis();
        return resultJson;
    }

    public static <T> ResultJson<T> getBadRequest() {
        return ResultJson.badRequest(400, "业务异常");
    }

    public static <T> ResultJson<T> getOKRequest(int code, String message){
        ResultJson<T> resultJson = new ResultJson<>();
        resultJson.code = code;
        resultJson.message = message;
        resultJson.timestamp = System.currentTimeMillis();
        resultJson.data = null;
        return resultJson;
    }

    public static <T> ResultJson<T> getOKRequest(){
        ResultJson<T> resultJson = new ResultJson<>();
        resultJson.code = 0;
        resultJson.message = "OK";
        resultJson.timestamp = System.currentTimeMillis();
        resultJson.data = null;
        return resultJson;
    }

    public static <T> ResultJson<T> getOKRequest(int code, String message, T data){
        ResultJson<T> resultJson = new ResultJson<>();
        resultJson.code = code;
        resultJson.message = message;
        resultJson.timestamp = System.currentTimeMillis();
        resultJson.data = data;
        return resultJson;
    }

    /**
     * 构造错误对象
     * @param code
     * @param message
     * @return
     */
    public static <T> ResultJson<T> badRequest(int code, String message, String detail){
        ResultJson<T> resultJson = badRequest(message, detail);
        resultJson.code = code;
        return resultJson;
    }
    /**
     * 构造错误对象，默认code=400
     * @param message
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ResultJson<T> badRequest(String message, T data){
        ResultJson<T> resultJson = new ResultJson<>();
        resultJson.code = RESULT_ERROR;
        resultJson.message = StringUtils.defaultIfEmpty(message,"发生错误!");
        resultJson.timestamp = System.currentTimeMillis();
        resultJson.data = data;
        return resultJson;
    }

}
