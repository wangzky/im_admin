package com.wangzk.im.dto;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @Title: Resp
 * @ProjectName: im
 * @PackageName: com.wangzk.im.dto
 * @Description: TODO
 * @author: wangzk
 * @date: 2019-08-28 17:19
 */
public class Resp implements Serializable {
    private String code;
    private String msg;
    private Object data;

    public Resp(){}
    public Resp(String code , String msg , Object data){
        this.code = code ;
        this.msg = msg;
        this.data = data;
    }
    public Resp success(){
        this.code = "200";
        this.msg = "请求成功！";
        return this;
    }
    public Resp success(Object data){
        this.code = "200";
        this.msg = "请求成功！";
        this.data = data;
        return this;
    }
    public Resp file(String msg){
        this.code = "9999";
        this.msg = "请求失败 "+msg;
        return this;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
