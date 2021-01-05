package com.ktwlrj.dectation.core.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ktwlrj.dectation.core.constant.Status;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 响应结果封装
 *
 * @author zxiaozhou
 * @date 2020-06-22 16:29
 * @since JDK1.8
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 2824340746431686918L;

    @JsonInclude
    @ApiModelProperty(value = "响应状态码")
    private int code;

    @JsonInclude
    @ApiModelProperty(value = "成功标识")
    private boolean success;

    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    @ApiModelProperty(value = "响应消息")
    private String message;

    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    @ApiModelProperty(value = "响应数据")
    private T data;

    @ApiModelProperty(value = "响应时间")
    private long timestamp;

    public Result() {
    }

    public Result(Status status) {
        this.setSuccess(status.getCode() == 0);
        this.setCode(status.getCode());
        this.setMessage(status.getMessage());
        this.timestamp = System.currentTimeMillis();
    }

    public Result(Status status, T data) {
        this.setSuccess(status.getCode() == 0);
        this.setCode(status.getCode());
        this.setMessage(status.getMessage());
        this.setData(data);
        this.timestamp = System.currentTimeMillis();
    }

    public Result(Status status, String message) {
        this.setSuccess(status.getCode() == 0);
        this.setCode(status.getCode());
        this.setMessage(message);
        this.setData(data);
        this.timestamp = System.currentTimeMillis();
    }

    public Result(int code, T data) {
        this.setSuccess(code == 0);
        this.setCode(code);
        this.setData(data);
        this.timestamp = System.currentTimeMillis();
    }

    public Result(int code, String message) {
        this.setSuccess(code == 0);
        this.setCode(code);
        this.setMessage(message);
        this.timestamp = System.currentTimeMillis();
    }

    public Result(int code, String message, T data) {
        this.setSuccess(code == 0);
        this.setCode(code);
        this.setData(data);
        this.setMessage(message);
        this.timestamp = System.currentTimeMillis();
    }
}