package com.zhou.code.util;

import com.zhou.code.enums.ResultMsgEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data  //getter和setter函数
@AllArgsConstructor //全参构造
@NoArgsConstructor   //无参构造
@Accessors(chain = true)//可以链式操作，默认是false
public class Result<T> implements Serializable {

    private static final long serialVersionUID=1L;
    private int code; //状态码

    private String message;  //信息

    private T data;  //数据

    public Result(int code, String message) {
        this.code=code;
        this.message=message;
    }

    /**
     * 成功
     */
    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<T>();
        result.setCode(ResultMsgEnum.SUCCESS.getCode());
        result.setMessage(ResultMsgEnum.SUCCESS.getMessage());
        result.setData(data);
        return result;
    }
    /**
     * 失败
     */
    public static <T> Result<T> error(int code, String message) {
        return new Result(code, message);
    }
}
