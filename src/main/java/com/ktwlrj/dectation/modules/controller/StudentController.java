package com.ktwlrj.dectation.modules.controller;

import com.ktwlrj.dectation.modules.entity.Student;
import com.ktwlrj.dectation.modules.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "数据库查询")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/Student")
@Validated
public class StudentController {

    private final StudentService service;

    @ApiOperation(value = "getStudent", notes = "Student")
    @GetMapping("/getstudent")
    public List<Student> getStudent(){
        return service.getAll();
    }


    @ApiOperation(value = "getById", notes = "id")
    @GetMapping("/getbyid/{id}")
    public Student getById(@PathVariable int id) {
        return service.getById(id);
    }


    @ApiOperation(value = "添加数据", notes = "添加student")
    @PostMapping(value = "/insert")
    public String insert(@RequestBody Student student) {
        service.add(student);
        return "添加成功";
    }
}
