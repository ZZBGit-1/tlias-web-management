package test.web.mapper;


import org.apache.ibatis.annotations.Mapper;
import test.web.pojo.Student;
import test.web.pojo.StudentQueryParam;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {
    List<Student> getStudentByPage(StudentQueryParam studentQueryParam);

    void deleteStudents(List<Integer> ids);

    void addStudent(Student student);

    Student getStudentById(Integer id);

    void updateStudent(Student student);

    void updateViolation(Integer id, Integer score);


    List<Map<String, Object>> getDegreeReport();

    List<Map<String, Object>> getStudentCountReport();
}
