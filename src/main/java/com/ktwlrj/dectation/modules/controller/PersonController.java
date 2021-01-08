package com.ktwlrj.dectation.modules.controller;

import com.ktwlrj.dectation.core.base.BaseController;
import com.ktwlrj.dectation.core.base.Result;
import com.ktwlrj.dectation.modules.entity.Person;
import com.ktwlrj.dectation.modules.service.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Api(tags = "个人")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/person")
@Validated
public class PersonController extends BaseController {

    private final PersonService service;

    @ApiOperation(value = "通过id查询信息", notes = "返回信息")
    @GetMapping("/select/{id}")
    public Result<Person> getById(@PathVariable int id) {
        return ok(service.getPersonById(id));
    }


    @ApiOperation(value = "添加数据", notes = "添加")
    @PostMapping("/insert")
    public Result<String> insert(@RequestBody Person person) {
        service.insert(person);
        return ok("添加成功");
    }
}
