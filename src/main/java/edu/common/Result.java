package edu.common;

/**
 * Craete with Intellij IDEA
 * Author:wgt
 * Date:17-12-3
 * Description:
 */
public class Result<T> {
    private int code;
    private String mess;
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMess() {
        return mess;
    }

    public void setMess(String mess) {
        this.mess = mess;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
