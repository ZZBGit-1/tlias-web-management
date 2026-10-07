package test.web.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.web.mapper.ClazzMapper;
import test.web.mapper.StudentMapper;
import test.web.pojo.*;
import test.web.service.StudentService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public PageResult<Student> getStudentByPage(StudentQueryParam studentQueryParam) {
        PageHelper.startPage(studentQueryParam.getPage(), studentQueryParam.getPageSize());
        List<Student> students = studentMapper.getStudentByPage(studentQueryParam);
        Page<Student> page = (Page<Student>) students;
        return new PageResult<>(page.getTotal(), page.getResult());
    }
    //批量删除学生信息
    @Override
    public void deleteStudents(List<Integer> ids) {
        studentMapper.deleteStudents(ids);
    }

    @Override
    public void addStudent(Student student) {
        student.setCreateTime(LocalDateTime.now ());
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.addStudent(student);
    }

    @Override
    public Student getStudentById(Integer id) {
        return studentMapper.getStudentById(id);
    }

    @Override
    public void updateStudent(Student student) {
        studentMapper.updateStudent(student);
    }

    @Override
    public void updateViolation(Integer id, Integer score) {
        studentMapper.updateViolation(id, score);
    }
}
