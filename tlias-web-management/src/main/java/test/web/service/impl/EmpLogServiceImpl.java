package test.web.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import test.web.mapper.EmpLogMapper;
import test.web.pojo.EmpLog;
import test.web.service.EmpLogService;

@Service
public class EmpLogServiceImpl implements EmpLogService {

    @Autowired
    private EmpLogMapper empLogMapper;

    @Transactional(propagation = Propagation.REQUIRES_NEW)//事务管理 无论怎么样，都会创建新事务，不会被其他事务影响，无论其他事务提交还是回滚，自己都会提交
    @Override
    public void insertLog(EmpLog empLog) {
        empLogMapper.insert(empLog);
    }
}
