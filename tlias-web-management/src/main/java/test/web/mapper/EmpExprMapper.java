package test.web.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import test.web.pojo.EmpExpr;

import java.util.List;

//员工工作经历
@Mapper
public interface EmpExprMapper {

   // @Insert("INSERT INTO emp_expr (emp_id, company, position, duty, start_time, end_time) " +
            //"VALUES (#{empId}, #{company}, #{position}, #{duty}, #{startTime}, #{endTime})")
    void insertBatch(@Param("empExprList") List<EmpExpr> empExprList);

    void deleteByEmpIds(@Param("empIds") List<Integer> empIds);
}
