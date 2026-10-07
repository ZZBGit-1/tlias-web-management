package test.web.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import test.web.pojo.*;
import test.web.service.StudentService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;
    // 获取分页数据
    @GetMapping
    public Result getStudentByPage(StudentQueryParam studentQueryParam){
        log.info("getStudentByPage: {}", studentQueryParam);
       PageResult<Student> pageResult = studentService.getStudentByPage(studentQueryParam);
       return Result.success(pageResult);
    }
    //批量删除学员信息
    @DeleteMapping("/{ids}")
    public Result deleteStudents(@PathVariable("ids") List<Integer> ids){
        log.info("deleteStudents: {}", ids);
        studentService.deleteStudents(ids);
        return Result.success();
    }
    //添加学员信息
    @PostMapping
    public Result addStudent(@RequestBody Student student){
        log.info("addStudent: {}", student);
        studentService.addStudent(student);
        return Result.success();
    }
    //根据id查询学员信息
    @GetMapping("/{id}")
    public Result getStudentById(@PathVariable("id") Integer id){
        log.info("getStudentById: {}", id);
        Student student = studentService.getStudentById(id);
        return Result.success(student);
    }
    //修改学员信息
    @PutMapping
    public Result updateStudent(@RequestBody Student student){
        log.info("updateStudent: {}", student);
        studentService.updateStudent(student);
        return Result.success();
    }
    //更新学员违纪信息
    @PutMapping("/violation/{id}/{score}")
    public Result updateViolation(@PathVariable("id") Integer id, @PathVariable("score") Integer score){
        log.info("updateViolation: {}, {}", id, score);
        studentService.updateViolation(id, score);
        return Result.success();
    }
}
