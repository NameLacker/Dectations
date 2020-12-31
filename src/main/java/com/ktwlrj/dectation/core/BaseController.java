package com.ktwlrj.dectation.core;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpSession;


/**
 * Controller基类
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

    public void setBaseController(HttpSession session) {
        this.session = session;
    }
}
