package test.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.web.mapper.EmpMapper;
import test.web.mapper.StudentMapper;
import test.web.pojo.ClazzOption;
import test.web.pojo.JobOption;
import test.web.service.ReportService;

import java.util.List;
import java.util.Map;


@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public JobOption getReport() {
        //调用mapper接口获取数据
        List<Map<String, Object>> empJobData = empMapper.countEmpJobData();
        //把数据封装成JobOption对象
        List<Object> jobList = empJobData.stream().map(datamap -> datamap.get("pos")).toList();
        List<Object> dataList = empJobData.stream().map(datamap -> datamap.get("num")).toList();
        return new JobOption(jobList, dataList);
    }

    @Override
    public List<Map<String, Object>> getGenderReport() {
        return empMapper.getGenderReport();
    }

    @Override
    public List<Map<String, Object>> getDegreeReport() {
        return studentMapper.getDegreeReport();
    }

    @Override
    public ClazzOption getStudentCountReport() {
        List<Map<String,Object>> list = studentMapper.getStudentCountReport();
        List<Object> clazzList = list.stream().map(cName -> cName.get("name")).toList();
        List<Object> clazzCount = list.stream().map(cValue -> cValue.get("value")).toList();
        return new ClazzOption(clazzList, clazzCount);
    }


}
