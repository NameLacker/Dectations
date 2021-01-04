package com.ktwlrj.dectation.core;


import lombok.extern.slf4j.Slf4j;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DecimalFormat;


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
        if (StringUtils.isBlank(port)) {
            port = "8080";
        }
        if (StringUtils.isBlank(path)) {
            path = "";
        }
        String profilesActive = env.getProperty("spring.profiles.active");
        String version = env.getProperty("spring.application.version");
        String projectName = env.getProperty("spring.application.name");
        log.info("\n------------------------------------------------------------------------------\n"
                + "Application " + projectName + " v" + version + " " + profilesActive + " is running! Access URLs:\n"
                + "\tApi-Url:\t\t\thttp://" + ip + ":" + port + path + "\n"
                + "\tSwagger-Ui:\t\t\thttp://" + ip + ":" + port + path + "/swagger-ui/index.html\n"
                + "------------------------------------------------------------------------------");
    }


    /**
     * 文件大小格式化
     *
     * @param size ${@link Long} 文件大小
     * @return String ${@link String} 返回格式化的文件大小
     * @author zxiaozhou
     * @date 2020-10-23 14:47
     */
    public static String getFormatFileSize(long size) {
        String fileSize;
        String unit;
        DecimalFormat df = new DecimalFormat("#.00");
        if (size < (1 << 10)) {
            fileSize = df.format((double) size);
            unit = "B";
        } else if (size < (1 << 20)) {
            fileSize = df.format((double) size / (1 << 10));
            unit = "KB";
        } else if (size < (1 << 30)) {
            fileSize = df.format((double) size / (1 << 20));
            unit = "MB";
        } else {
            fileSize = df.format((double) size / (1 << 30));
            unit = "GB";
        }
        return fileSize + unit;
    }


    /**
     * 获取文件md5值
     *
     * @param inputStream ${@link InputStream}
     * @return String ${@link String}
     * @author zxiaozhou
     * @date 2020-10-23 14:50
     */
    public static String getFileMd5Hex(InputStream inputStream) {
        String md5 = "";
        try {
            md5 = DigestUtils.md5Hex(inputStream);
        } catch (IOException e) {
            log.error("------------CoreCommonUtils------------>getFileMd5Hex:{}", "获取文件md5值失败");
        }
        return md5;
    }
}
