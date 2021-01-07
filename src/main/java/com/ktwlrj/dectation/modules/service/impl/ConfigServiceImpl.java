package com.ktwlrj.dectation.modules.service.impl;

import com.ktwlrj.dectation.core.constant.Status;
import com.ktwlrj.dectation.core.exception.ResponseException;
import com.ktwlrj.dectation.modules.mapper.ConfigMapper;
import com.ktwlrj.dectation.modules.service.ConfigService;
import com.ktwlrj.dectation.modules.entity.InformationDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


@Slf4j
@Service
@RequiredArgsConstructor
public class ConfigServiceImpl implements ConfigService {

    private final ConfigMapper configMapper;

    @Override
    public InformationDto getInformationById(int id) {
        try {
            InformationDto information = configMapper.getInformationById(id);
            if (Objects.isNull(information)) {
                throw new ResponseException(Status.DATABASE_BASE_ERROR, "未查询到相关信息");
            }
            return information;
        } catch (Exception e) {
            log.error("-------------ConfigServiceImpl-----查询失败-----getInformationById--->\n异常信息:{}", e.getMessage());
            throw new ResponseException(Status.DATABASE_BASE_ERROR, "数据库操作异常，可能是没有此id对应数据");
        }
    }

    @Override
    public List<InformationDto> getAllInformation() {
        try {
            List<InformationDto> informations = configMapper.getAllInformation();
            if (Objects.isNull(informations)) {
                throw new ResponseException(Status.DATABASE_BASE_ERROR, "未查询到相关信息");
            }
            return informations;
        } catch (Exception e) {
            log.error("-------------ConfigServiceImpl-----查询失败-----getInformationById--->\n异常信息:{}", e.getMessage());
            throw new ResponseException(Status.DATABASE_BASE_ERROR, "数据库操作异常，可能是没有此id对应数据");
        }
    }
}
