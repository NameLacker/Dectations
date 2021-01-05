package com.ktwlrj.dectation.core.constant;

/**
 * REST API 状态码接口
 *
 * @author zxiaozhou
 * @date 2020-06-22 16:40
 * @since JDK1.8
 */
interface IStatus {

    /**
     * 状态码
     *
     * @return Integer ${@link Integer} 状态码
     * @author zxiaozhou
     * @date 2020-06-22 16:37
     */
    Integer getCode();


    /**
     * 返回信息
     *
     * @return String ${@link String} 返回信息
     * @author zxiaozhou
     * @date 2020-06-22 16:37
     */
    String getMessage();


    /**
     * http状态码
     *
     * @return Integer ${@link Integer} http状态码
     * @author zxiaozhou
     * @date 2020-06-22 16:37
     */
    Integer getStatus();

}