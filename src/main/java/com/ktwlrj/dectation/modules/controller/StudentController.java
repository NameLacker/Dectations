package com.ktwlrj.dectation.modules.controller;

import com.ktwlrj.dectation.core.base.Result;
import com.ktwlrj.dectation.modules.entity.Student;
import com.ktwlrj.dectation.modules.service.StudentService;
import com.ktwlrj.dectation.modules.service.dto.CountDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static com.ktwlrj.dectation.core.base.BaseController.ok;

@Api(tags = "学生")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/student")
@Validated
public class StudentController {

    private final StudentService service;

    @ApiOperation(value = "获取所有学生信息", notes = "Student")
    @GetMapping("/getallstudent")
    public Result<CountDto<Student>> getStudent(){
        return ok(service.getAll());
    }


    @ApiOperation(value = "通过id获取信息", notes = "id")
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

    @ApiOperation(value = "删除数据", notes = "依据id删除数据")
    @DeleteMapping(value = "/delete/{id}")
    public Result<String> delete(@PathVariable int id) {
        service.deleteById(id);
        return ok("删除成功");
    }

    @ApiOperation(value = "更新数据", notes = "数据信息")
    @PostMapping(value = "/update")
    public Result<String> update(@RequestBody Student student) {
        service.update(student);
        return ok("更新成功");
    }
}
