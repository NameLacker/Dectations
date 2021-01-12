package com.ktwlrj.dectation;

import com.ktwlrj.dectation.core.CoreCommonUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@MapperScan("com.ktwlrj.dectation.modules.mapper")  // 扫描映射Mapper接口类
@EnableAsync  // 事物
@SpringBootApplication
@EnableTransactionManagement
@ServletComponentScan(basePackages = "com.ktwlrj.dectation.core.filter")
@EnableCaching  // 启动redis
public class Application {

    public static void main(String[] args){
        SpringApplication springApplication = new SpringApplication(Application.class);
        // springApplication.setBannerMode(Banner.Mode.OFF);  // 关闭启动Logo和启动日志的输出
        ConfigurableApplicationContext Application =  springApplication.run(args);
        CoreCommonUtils.printSysInfo(Application);  // 打印系统相关配置信息
    }
}
