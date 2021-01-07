package com.ktwlrj.dectation.modules.service;

import com.ktwlrj.dectation.modules.service.dto.InformationDto;

import java.util.List;


public interface ConfigService {
    InformationDto getInformationById(int id);

    List<InformationDto> getAllInformation();
}
