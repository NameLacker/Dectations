package com.ktwlrj.dectation.modules.controller;

import com.ktwlrj.dectation.core.base.Result;
import com.ktwlrj.dectation.modules.service.ConfigService;
import com.ktwlrj.dectation.modules.entity.InformationDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.ktwlrj.dectation.core.base.BaseController.ok;

@Api(tags = "日志")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/config")
@Validated
public class ConfigController {

    private final ConfigService service;

    @ApiOperation(value = "获取全部信息", notes = "信息")
    @GetMapping("/getinformations/")
    public Result<List<InformationDto>> getInformations() {
        return ok(service.getAllInformation());
    }

    @ApiOperation(value = "获取单个信息", notes = "信息")
    @GetMapping("/getinformations/{id}")
    public Result<InformationDto> getinformation(@PathVariable int id) {
        return ok(service.getInformationById(id));
    }
}
