package com.ktwlrj.dectation.modules.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Validated
@RequiredArgsConstructor
@RestController
@Api(tags = "用户")
@RequestMapping("/home")
public class UserController {

    @ApiOperation(value = "hello", notes = "test")
    @GetMapping("/hello/{back}")
    public String hello(@PathVariable String back) {
        return back;
    }


}
