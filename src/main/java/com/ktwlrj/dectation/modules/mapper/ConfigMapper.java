package com.ktwlrj.dectation.modules.mapper;

import com.ktwlrj.dectation.modules.service.dto.InformationDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ConfigMapper {

    InformationDto getInformationById(int id);

    List<InformationDto> getAllInformation();
}
