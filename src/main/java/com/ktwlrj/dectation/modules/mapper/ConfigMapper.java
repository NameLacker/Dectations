package com.ktwlrj.dectation.modules.mapper;

import com.ktwlrj.dectation.modules.entity.InformationDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConfigMapper {

    InformationDto getInformationById(int id);

    List<InformationDto> getAllInformation();
}
