package com.ktwlrj.dectation.modules.controller;

import com.ktwlrj.dectation.core.base.Result;
import com.ktwlrj.dectation.modules.entity.User;
import com.ktwlrj.dectation.modules.service.UserService;
import com.ktwlrj.dectation.modules.service.dto.CountDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static com.ktwlrj.dectation.core.base.BaseController.ok;

@Slf4j
@Validated
@RequiredArgsConstructor
@RestController
@Api(tags = "用户")
@RequestMapping("/user")
public class UserController {

    private final UserService service;

    @ApiOperation(value = "保存用户信息", notes = "user")
    @PostMapping("/save")
    public Result<String> saveUser(@RequestBody User user) {
        service.saveUser(user);
        return ok("添加成功");
    }


    @ApiOperation(value = "获取用户", notes = "用户")
    @GetMapping("/getuser/{name}")
    public Result<User> getUser(@PathVariable String name) {
        return ok(service.getUser(name));
    }


    @ApiOperation(value = "获取所有用户", notes = "用户")
    @GetMapping("/getalluser")
    public Result<CountDto<User>> getAllUser() {
        return ok(service.getAllUser());
    }


    @ApiOperation(value = "删除数据", notes = "依据id删除数据")
    @DeleteMapping("/delete/{id}")
    public Result<String> delete(@PathVariable int id) {
        service.deleteById(id);
        return ok("删除成功");
    }

    @ApiOperation(value = "更新数据", notes = "更新数据信息")
    @PostMapping("/update")
    public Result<String> update(@RequestBody User user) {
        service.update(user);
        return ok("更新成功");
    }
}
