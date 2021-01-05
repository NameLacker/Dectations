package com.ktwlrj.dectation.modules.controller;

import com.ktwlrj.dectation.core.base.Result;
import com.ktwlrj.dectation.modules.entity.User;
import com.ktwlrj.dectation.modules.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.ktwlrj.dectation.core.base.BaseController.ok;

@Api(tags = "日志")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/config")
@Validated
public class ConfigController {

    private final UserService service;

    @ApiOperation(value = "getPerson", notes = "Human")
    @GetMapping("/getperson/{name}")
    public Result<User> getPerson(@PathVariable String name) {
        return ok(service.getUser(name));
    }
}
