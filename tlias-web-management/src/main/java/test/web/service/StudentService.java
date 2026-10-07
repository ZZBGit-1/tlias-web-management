package test.web.service;

import test.web.pojo.*;

import java.util.List;

public interface StudentService {

    PageResult<Student> getStudentByPage(StudentQueryParam studentQueryParam);

    void deleteStudents(List<Integer> ids);

    void addStudent(Student student);

    Student getStudentById(Integer id);

    void updateStudent(Student student);

    void updateViolation(Integer id, Integer score);
}
