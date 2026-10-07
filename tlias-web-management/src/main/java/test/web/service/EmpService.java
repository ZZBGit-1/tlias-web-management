package test.web.service;

import test.web.pojo.Emp;
import test.web.pojo.EmpQueryParam;
import test.web.pojo.PageResult;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {
    PageResult<Emp> page(EmpQueryParam empQueryParam);

    void save(Emp emp);

    void deleteByIds(List<Integer> ids);

    Emp getById(Integer id);

    void update(Emp emp);

    List<Emp> listAll();
}
