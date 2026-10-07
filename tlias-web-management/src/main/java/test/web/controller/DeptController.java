package test.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import test.web.pojo.Dept;
import test.web.pojo.Result;
import test.web.service.DeptService;

import java.util.List;
@RequestMapping("/depts")
@RestController
@Slf4j
public class DeptController {
    //自动注入service层的deptService，用于调用service层的方法
    @Autowired
    private DeptService deptService;
//    @RequestMapping(value = "/depts",method = RequestMethod.GET)
    //查询部门信息
    @GetMapping
    public Result list(){
        List<Dept> list = deptService.findAll();//用list集合接受findAll()方法的返回值
        log.info("查询成功");
        return Result.success(list);//调用Result的success方法，返回list集合
    }

    //删除部门信息
    @DeleteMapping
    public Result delete(Integer id){
        deptService.deleteById(id);
        log.info("删除成功");
        return Result.success();
    }
    //添加部门信息
    @PostMapping
    public Result add(@RequestBody Dept dept){
        deptService.add(dept);
        log.info("添加成功");
        return Result.success();
    }
    //根据id查询部门信息
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        Dept dept = deptService.getById(id);
        log.info("查询成功");
        return Result.success(dept);
    }
    //修改部门信息
    @PutMapping
    public Result update(@RequestBody Dept dept){
        deptService.update(dept);
        log.info("修改成功");
        return Result.success();
    }
}
