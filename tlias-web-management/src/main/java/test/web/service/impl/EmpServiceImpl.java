package test.web.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import test.web.mapper.EmpExprMapper;
import test.web.mapper.EmpMapper;
import test.web.pojo.*;
import test.web.service.EmpLogService;
import test.web.service.EmpService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private EmpExprMapper empExprMapper;
    @Autowired
    private EmpLogService empLogService;



    //原始分页查询方法
//    @Override
//    public PageResult<Emp> page(Integer page, Integer pageSize) {
//        long total = empMapper.count();
//        List<Emp> rows = empMapper.rows((page - 1) * pageSize, pageSize);
//        return new PageResult<Emp>(total, rows);
//    }
    //pageHelper分页查询方法
    @Override
    public PageResult<Emp> page(EmpQueryParam empQueryParam) {
        PageHelper.startPage(empQueryParam.getPage(), empQueryParam.getPageSize());
        List<Emp> rows = empMapper.rows(empQueryParam);
        Page<Emp> p = (Page<Emp>) rows;//rows已经转换为Page<Emp>类型
        return new PageResult<Emp>(p.getTotal(), p.getResult());
    }
    @Transactional(rollbackFor = {Exception.class})//事务管理
    @Override
    public void save(Emp emp) {
        //保存员工信息
        try {
            emp.setCreateTime(LocalDateTime.now());
            emp.setUpdateTime(LocalDateTime.now());
            empMapper.save(emp);

            //员工经历信息
            List<EmpExpr> empExprList = emp.getEmplist();
            if(!CollectionUtils.isEmpty(empExprList)){
                empExprList.forEach(empExpr -> {
                    empExpr.setEmpId(emp.getId());

                });
                empExprMapper.insertBatch(empExprList);
            }
        } finally {
            EmpLog empLog = new EmpLog(null, LocalDateTime.now(), "保存员工信息"+emp);
            empLogService.insertLog(empLog);
        }
    }

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void deleteByIds(List<Integer> ids) {
        //批量删除员工信息
        empMapper.deleteByIds(ids);
        //批量删除员工经历信息
        empExprMapper.deleteByEmpIds(ids);
    }

    @Override
    public Emp getById(Integer id) {

        return empMapper.getInfo(id);
    }
    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void update(Emp emp) {
        //更新员工信息
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.updateById(emp);

        //更新员工经历信息
        //删除原本的员工经历信息
        empExprMapper.deleteByEmpIds(Arrays.asList(emp.getId()));

        //更新新的员工经历信息

        List<EmpExpr> empEmplist = emp.getEmplist();
        if(!CollectionUtils.isEmpty(empEmplist)){
            empEmplist.forEach(empExpr -> {
                empExpr.setEmpId(emp.getId());
            });
            empExprMapper.insertBatch(empEmplist);
        }
    }

    @Override
    public List<Emp> listAll() {
        return empMapper.listAll();
    }

}
