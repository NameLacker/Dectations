package com.ktwlrj.dectation.modules.controller;

import com.ktwlrj.dectation.core.base.Result;
import com.ktwlrj.dectation.modules.entity.Student;
import com.ktwlrj.dectation.modules.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import static com.ktwlrj.dectation.core.base.BaseController.ok;

@Api(tags = "数据库查询")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/student")
@Validated
public class StudentController {

    private final StudentService service;

    @ApiOperation(value = "getAllStudent", notes = "Student")
    @GetMapping("/getallstudent")
    public Result<List<Student>> getStudent(){
        return ok(service.getAll());
    }


    @ApiOperation(value = "getById", notes = "id")
    @GetMapping("/getbyid/{id}")
    public Result<Student> getById(@PathVariable int id) {
        return ok(service.getById(id));
    }


    @ApiOperation(value = "添加数据", notes = "添加student")
    @PostMapping(value = "/insert")
    public Result<String> insert(@RequestBody Student student) {
        service.add(student);
        return ok("添加成功");
    }
}
