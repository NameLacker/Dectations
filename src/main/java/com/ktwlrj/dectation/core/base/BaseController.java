package com.ktwlrj.dectation.core.base;

import com.ktwlrj.dectation.core.constant.Status;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;


/**
 * Controller基类
 *
 * @author zxiaozhou
 * @date 2020-06-22 17:19
 * @since JDK1.8
 */
@Slf4j
@ApiResponses({
        @ApiResponse(code = 401, message = "未授权"),
        @ApiResponse(code = 200, message = "成功"),
        @ApiResponse(code = 403, message = "拒绝访问"),
        @ApiResponse(code = 404, message = "请求路径不存在"),
        @ApiResponse(code = 500, message = "服务器内部错误")
})
public class BaseController {
    public HttpSession session;


    @Autowired
    public void setBaseController(HttpSession session) {
        this.session = session;
    }


    /**
     * 成功响应
     *
     * @return Result<T> ${@link Result <T>} 响应信息
     * @author zxiaozhou
     * @date 2020-06-22 17:16
     */
    public static <T> Result<T> ok() {
        return new Result<>(Status.SUCCESS);
    }

    /**
     * 成功响应
     *
     * @return Result<String> ${@link Result<String>} 响应信息
     * @author zxiaozhou
     * @date 2020-06-22 17:16
     */
    public static Result<String> ok(String message) {
        return new Result<>(Status.SUCCESS, message);
    }


    /**
     * 成功响应
     *
     * @param data ${@link Object} 成功响应数据
     * @return Result<T> ${@link Result<T>} 响应信息
     * @author zxiaozhou
     * @date 2020-06-22 17:16
     */
    public static <T> Result<T> ok(T data) {
        return new Result<>(Status.SUCCESS, data);
    }

    /**
     * 成功响应
     *
     * @param status ${@link Object} 成功响应数据
     * @return Result<T> ${@link Result<T>} 响应信息
     * @author zxiaozhou
     * @date 2020-06-22 17:16
     */
    public static Result<Object> ok(Status status) {
        return new Result<>(status);
    }


    /**
     * 成功响应
     *
     * @param data    ${@link Object} 成功响应数据
     * @param message ${@link String} 成功响应消息
     * @return Result<T> ${@link Result<T>} 响应信息
     * @author zxiaozhou
     * @date 2020-06-22 17:16
     */
    public static <T> Result<T> ok(T data, String message) {
        Result<T> result = new Result<>(Status.SUCCESS, data);
        result.setMessage(message);
        return result;
    }


    /**
     * 响应失败
     *
     * @return Result<T> ${@link Result<T>} 响应信息
     * @author zxiaozhou
     * @date 2020-06-22 17:17
     */
    public static <T> Result<T> fail() {
        return new Result<>(Status.ERROR);
    }


    /**
     * 响应失败
     *
     * @param status ${@link Status} 失败状态
     * @return Result<T> ${@link Result<T>} 响应信息
     * @author zxiaozhou
     * @date 2020-06-22 17:17
     */
    public static <T> Result<T> fail(Status status) {
        return new Result<>(status);
    }

    /**
     * 响应失败
     *
     * @param message ${@link String} 失败消息
     * @return Result<T> ${@link Result<T>} 响应信息
     * @author zxiaozhou
     * @date 2020-06-22 17:17
     */
    public static <T> Result<T> fail(String message) {
        return new Result<>(Status.ERROR, message);
    }


    /**
     * 响应失败
     *
     * @param status  ${@link Status} 失败状态
     * @param message ${@link String} 失败消息
     * @return Result<T> ${@link Result<T>} 响应信息
     * @author zxiaozhou
     * @date 2020-06-22 17:17
     */
    public static <T> Result<T> fail(Status status, String message) {
        Result<T> result = new Result<>(status);
        result.setMessage(message);
        return result;
    }


    /**
     * 响应失败
     *
     * @param code    ${@link Integer} 失败状态码
     * @param message ${@link String} 失败消息
     * @return Result<T> ${@link Result<T>} 响应信息
     * @author zxiaozhou
     * @date 2020-06-22 17:17
     */
    public static <T> Result<T> fail(Integer code, String message) {
        return new Result<>(code, message);
    }
}
