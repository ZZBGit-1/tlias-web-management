package test.web.mapper;

import org.apache.ibatis.annotations.*;
import test.web.pojo.Dept;

import java.util.List;

@Mapper
public interface DeptMapper {
    // 查询所有部门
    @Select("select * from dept order by update_time desc ")
   List<Dept> findAll();
    // 根据id删除部门
    @Delete("delete from dept where id = #{id}")
    void deleteById(Integer id);
    // 添加部门
    @Insert("insert into dept (name, create_time, update_time) values (#{name}, #{createTime}, #{updateTime})")
    void add(Dept dept);
    // 根据id查询部门
    @Select("select * from dept where id = #{id}")
    Dept getById(Integer id);
    // 修改部门
    @Update("update dept set name = #{name}, update_time = #{updateTime} where id = #{id}")
    void update(Dept dept);
}
