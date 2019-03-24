package com.hcq.sso.bean;

/**
 * fileName:LoginResp
 * description:
 * author:hcq
 * createTime:2019-03-23 10:34
 */

public class LoginResp {
    private Integer code;//状态码
    private String massage;//提示信息
    private String token;//Token
    private Object data;//用户信息
    private LoginResp(Integer code, String massage, Object data){
        this.code=code;
        this.massage=massage;
        this.data=data;
    }
    public static LoginResp build(int code, String massage, Object data){
        return new LoginResp(code,massage,data);
    }
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public String getToken() {
        return token;
    }

    public LoginResp setToken(String token) {
        this.token = token;
        return this;
    }

    public Object getData() {
        return data;
    }
}
