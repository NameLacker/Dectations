package com.ktwlrj.dectation.core;


import lombok.extern.slf4j.Slf4j;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;


/**
 * 系统工具类
 *
 * @author zxiaozhou
 * @date 2020-12-31 12:24
 */
@Slf4j
public class CoreCommonUtils {
    /**
     * 打印系统关键信息
     */
    public static void printSysInfo(ConfigurableApplicationContext application) {
        String ip = "localhost";
        try {
            ip = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        Environment env = application.getEnvironment();
        String port = env.getProperty("server.port");
        String path = env.getProperty("server.servlet.context-path");

        String profilesActive = env.getProperty("spring.profiles.active");
        String version = env.getProperty("spring.application.version");
        String projectName = env.getProperty("spring.application.name");
        log.info("\n------------------------------------------------------------------------------\n"
                + "Application " + projectName + " v" + version + " " + profilesActive + " is running! Access URLs:\n"
                + "\tApi-Url:\t\t\thttp://localhost:8080/\n"
                + "\tSwagger-Ui:\t\t\thttp://localhost:8080/swagger-ui/index.html\n"
                + "------------------------------------------------------------------------------");
    }
}
