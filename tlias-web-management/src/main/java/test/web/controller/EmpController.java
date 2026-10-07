package test.web.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import test.web.pojo.Emp;
import test.web.pojo.EmpQueryParam;
import test.web.pojo.PageResult;
import test.web.pojo.Result;
import test.web.service.EmpService;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {

    @Autowired
    private EmpService empService;
    @GetMapping
    public Result page(EmpQueryParam empQueryParam) {
        log.info("分页查询员工信息", empQueryParam);
        PageResult<Emp> pageResult = empService.page(empQueryParam);
     return Result.success(pageResult);
    }

    @PostMapping
    public Result save(@RequestBody Emp emp){
        log.info("保存员工信息", emp);
        empService.save(emp);
        return Result.success();
    }
    //批量删除员工信息
    @DeleteMapping
    public Result delete(@RequestParam List<Integer> ids){
        log.info("删除员工信息", ids);
        empService.deleteByIds(ids);
        return Result.success();
    }
    //修改员工信息时先查询回显
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
        log.info("查询员工信息", id);
        Emp emp = empService.getById(id);
        return Result.success(emp);

    }
    //修改员工信息
    @PutMapping
    public Result update(@RequestBody Emp emp){
        log.info("修改员工信息", emp);
        empService.update(emp);
        return Result.success();
    }

    //查询所有员工信息
    @GetMapping("/list")
    public Result listAll(){
        log.info("查询所有员工信息");
        List<Emp> emps = empService.listAll();
        return Result.success(emps);
    }
}
