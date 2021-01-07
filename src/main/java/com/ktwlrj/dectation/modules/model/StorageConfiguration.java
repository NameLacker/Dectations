package com.ktwlrj.dectation.modules.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Setter
@ToString
@Configuration
@ConfigurationProperties("storage.local")
public class StorageConfiguration {

    private String rootDir;

    private int maxSize;

    private boolean allowEmpty;

    private List<String> allowTypes;
}
