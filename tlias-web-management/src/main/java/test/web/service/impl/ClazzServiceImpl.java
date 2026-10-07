package test.web.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.web.mapper.ClazzMapper;
import test.web.pojo.Clazz;
import test.web.pojo.ClazzQueryParam;
import test.web.pojo.PageResult;
import test.web.service.ClazzService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClazzServiceImpl implements ClazzService {
    @Autowired
    private ClazzMapper clazzMapper;
    @Override
    public PageResult<Clazz> getClazz(ClazzQueryParam clazzQueryParam) {
        PageHelper.startPage(clazzQueryParam.getPage(), clazzQueryParam.getPageSize());
        List<Clazz> rows = clazzMapper.rows(clazzQueryParam);
        LocalDate now = LocalDate.now();
        for (Clazz clazz : rows) {
            LocalDate beginDate = clazz.getBeginDate();
            LocalDate endDate = clazz.getEndDate();
            if (now.isAfter(endDate)) {
                clazz.setStatus("已结课");
            } else if (now.isBefore(beginDate)) {
                clazz.setStatus("未开班");
            } else {
                clazz.setStatus("在读");
            }
        }

        Page<Clazz> page = (Page<Clazz>) rows;
        return new PageResult<>(page.getTotal(), page.getResult());//
    }

    @Override
    public void deleteById(Integer id) {
        clazzMapper.deleteById(id);
    }

    @Override
    public void addClazz(Clazz clazz) {
        clazz.setCreateTime(LocalDateTime.now());
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.addClazz(clazz);
    }

    @Override
    public Clazz getClazzById(Integer id) {
        return clazzMapper.getClazzById(id);
    }

    @Override
    public void updateClazz(Clazz clazz) {
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.updateClazz(clazz);
    }

    @Override
    public List<Clazz> getAllClazz() {
        return clazzMapper.getAllClazz();
    }
}
