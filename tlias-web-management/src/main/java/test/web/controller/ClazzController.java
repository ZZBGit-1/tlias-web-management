package test.web.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import test.web.pojo.Clazz;
import test.web.pojo.ClazzQueryParam;
import test.web.pojo.PageResult;
import test.web.pojo.Result;
import test.web.service.ClazzService;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/clazzs")

public class ClazzController {
    @Autowired
    private ClazzService clazzService;
    // 查询班级信息
    @GetMapping
    public Result getClazz(ClazzQueryParam clazzQueryParam){
        log.info("查询班级信息：{}", clazzQueryParam);
        PageResult<Clazz> pageResult = clazzService.getClazz(clazzQueryParam);//
        return Result.success(pageResult);
    }
    //根据Id删除班级
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable("id") Integer id){
        log.info("根据Id删除班级：{}", id);
        clazzService.deleteById(id);
        return Result.success();
    }

    //添加班级
    @PostMapping
    public Result addClazz(@RequestBody Clazz clazz){
        log.info("添加班级：{}", clazz);
        clazzService.addClazz(clazz);
        return Result.success();
    }

    //根据ID查询班级
    @GetMapping("/{id}")
    public Result getClazzById(@PathVariable("id") Integer id){
        log.info("根据ID查询班级：{}", id);
        Clazz clazz = clazzService.getClazzById(id);
        return Result.success(clazz);
    }
    //修改班级
    @PutMapping
    public Result updateClazz(@RequestBody Clazz clazz){
        log.info("修改班级：{}", clazz);
        clazzService.updateClazz(clazz);
        return Result.success();
    }
    //查询所有班级
    @GetMapping("/list")
    public Result getAllClazz(){
        log.info("查询所有班级");
        List<Clazz> clazzList = clazzService.getAllClazz();
        return Result.success(clazzList);
    }
}
