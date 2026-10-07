package test.web.mapper;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import test.web.pojo.Emp;
import test.web.pojo.EmpQueryParam;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

//员工信息
@Mapper
public interface EmpMapper {
   //
    //原始分页查询方法
//
//    //查询员工总数
//    @Select("select count(*) from emp left join dept on emp.dept_id = dept.id")
//    public long count();
//
//    //查询员工列表
//    @Select("select emp.*,dept.name deptName from emp left join dept on emp.dept_id = dept.id order by update_time desc limit #{start},#{pageSize}")
//    public List<Emp> rows(Integer start, Integer pageSize);

    //pageHelper分页查询方法
   // @Select("select emp.*,dept.name deptName from emp left join dept on emp.dept_id = dept.id order by update_time desc")
    public List<Emp> rows(EmpQueryParam empQueryParam);



    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into emp (username,name,gender,phone,job,salary,image,entry_date,dept_id,create_time,update_time) values" +
            "(#{username},#{name},#{gender},#{phone},#{job},#{salary},#{image},#{entryDate},#{deptId},#{createTime},#{updateTime})")
    void save(Emp emp);

    void deleteByIds(List<Integer> ids);

    Emp getInfo(Integer id);

    void updateById(Emp emp);

    //统计员工职位信息
    List<Map<String,Object>>countEmpJobData();

    List<Map<String, Object>> getGenderReport();

    List<Emp> listAll();
}
