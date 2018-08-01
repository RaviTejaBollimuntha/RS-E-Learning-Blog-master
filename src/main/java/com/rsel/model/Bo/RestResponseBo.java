package com.rsel.model.Bo;

/**
 * rest returns the object
 *
 * @param <T>
 */
public class RestResponseBo<T> {

	/**
	     * Server response data
	     */
    private T payload;

    /**
         * Whether the request was successful
         */
    private boolean success;

    /**
         * Error message
         */
    private String msg;

    /**
    * Server response time
    */
    private int code = -1;

    /**
         * Server response time
         */
    private long timestamp;

    public RestResponseBo() {
        this.timestamp = System.currentTimeMillis() / 1000;
    }

    public RestResponseBo(boolean success) {
        this.timestamp = System.currentTimeMillis() / 1000;
        this.success = success;
    }

    public RestResponseBo(boolean success, T payload) {
        this.timestamp = System.currentTimeMillis() / 1000;
        this.success = success;
        this.payload = payload;
    }

    public RestResponseBo(boolean success, T payload, int code) {
        this.timestamp = System.currentTimeMillis() / 1000;
        this.success = success;
        this.payload = payload;
        this.code = code;
    }

    public RestResponseBo(boolean success, String msg) {
        this.timestamp = System.currentTimeMillis() / 1000;
        this.success = success;
        this.msg = msg;
    }

    public RestResponseBo(boolean success, String msg, int code) {
        this.timestamp = System.currentTimeMillis() / 1000;
        this.success = success;
        this.msg = msg;
        this.code = code;
    }

    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public static RestResponseBo ok() {
        return new RestResponseBo(true);
    }

    public static <T> RestResponseBo ok(T payload) {
        return new RestResponseBo(true, payload);
    }

    public static <T> RestResponseBo ok(int code) {
        return new RestResponseBo(true, null, code);
    }

    public static <T> RestResponseBo ok(T payload, int code) {
        return new RestResponseBo(true, payload, code);
    }

    public static RestResponseBo fail() {
        return new RestResponseBo(false);
    }

    public static RestResponseBo fail(String msg) {
        return new RestResponseBo(false, msg);
    }

    public static RestResponseBo fail(int code) {
        return new RestResponseBo(false, null, code);
    }

    public static RestResponseBo fail(int code, String msg) {
        return new RestResponseBo(false, msg, code);
    }

}