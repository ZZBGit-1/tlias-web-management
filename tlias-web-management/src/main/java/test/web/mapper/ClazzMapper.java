package test.web.mapper;


import org.apache.ibatis.annotations.Mapper;
import test.web.pojo.Clazz;
import test.web.pojo.ClazzQueryParam;

import java.util.List;

@Mapper
public interface ClazzMapper {
    //分页查询班级信息
    List<Clazz> rows(ClazzQueryParam clazzQueryParam);

    //根据Id删除班级
    void deleteById(Integer id);

    void addClazz(Clazz clazz);

    Clazz getClazzById(Integer id);

    void updateClazz(Clazz clazz);

    List<Clazz> getAllClazz();
}
