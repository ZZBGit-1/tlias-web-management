package test.web.service;

import test.web.pojo.Clazz;
import test.web.pojo.ClazzQueryParam;
import test.web.pojo.PageResult;

import java.util.List;

public interface ClazzService {
    /**
     * 根据查询条件分页查询班级信息
     *
     * @param clazzQueryParam 查询条件
     * @return 班级信息
     */
    PageResult<Clazz> getClazz(ClazzQueryParam clazzQueryParam);

    /**
     * 根据Id删除班级
     *
     * @param id 班级Id
     */
    void deleteById(Integer id);

    void addClazz(Clazz clazz);

    Clazz getClazzById(Integer id);

    void updateClazz(Clazz clazz);

    List<Clazz> getAllClazz();
}
