package edu.common;

/**
 * @author wgt
 * @date 17-12-4
 */
public enum  ResultMess {
    SUCCESS(200,"成功"),
    ERROR(400,"失败");

    private int code;
    private String mess;
    private ResultMess(int code,String mess){
        this.code=code;
        this.mess=mess;
    }

    public String getMess() {
        return mess;
    }

    public void setMess(String mess) {
        this.mess = mess;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
