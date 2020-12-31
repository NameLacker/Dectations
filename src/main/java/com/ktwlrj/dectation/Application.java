package com.ktwlrj.dectation;

import com.ktwlrj.dectation.core.CoreCommonUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class Application {

    public static void main(String[] args) throws Exception{
        ConfigurableApplicationContext Application = SpringApplication.run(Application.class, args);
        CoreCommonUtils.printSysInfo(Application);
    }
}
