package com.ktwlrj.dectation;

import com.ktwlrj.dectation.core.CoreCommonUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@MapperScan({"com.ktwlrj.dectation.modules.mapper"})  // 扫描映射Mapper接口类
@EnableAsync  // 事物
@SpringBootApplication
@EnableTransactionManagement
public class Application {

    public static void main(String[] args){
        ConfigurableApplicationContext Application = SpringApplication.run(Application.class, args);
        CoreCommonUtils.printSysInfo(Application);  // 打印系统相关配置信息
    }
}
