package com.ktwlrj.dectation.modules.controller;


import com.ktwlrj.dectation.core.base.BaseController;
import com.ktwlrj.dectation.core.base.Result;
import com.ktwlrj.dectation.modules.entity.Developer;
import com.ktwlrj.dectation.modules.service.DevelopService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Api(tags = "开发者")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/develop")
@Validated
public class DevelopController extends BaseController {

    private final DevelopService service;

    @ApiOperation(value = "通过id查询信息", notes = "返回信息")
    @GetMapping("/select/{id}")
    public Result<Developer> getById(@PathVariable int id) {
        return ok(service.getDeveloperById(id));
    }


    @ApiOperation(value = "添加数据", notes = "添加")
    @PostMapping("/insert")
    public Result<String> insert(@RequestBody Developer developer) {
        service.insertDeveloper(developer);
        return ok("添加成功");
    }
}
