package test.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.web.mapper.EmpMapper;
import test.web.pojo.ClazzOption;
import test.web.pojo.JobOption;
import test.web.pojo.Result;
import test.web.service.ReportService;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
   private ReportService reportService;
    @Autowired
    private EmpMapper empMapper;
    // 员工职位数据
    @GetMapping("/empJobData")
    public Result getReport() {
        log.info("getReport");
        JobOption jobOption = reportService.getReport();
        return Result.success(jobOption);
    }

    // 员工性别数据
    @GetMapping("/empGenderData")
    public Result getGenderReport(){
        log.info("获取性别统计信息");
        List<Map<String, Object>> list = reportService.getGenderReport();
        return Result.success(list);
    }
    //学员学历统计
    @GetMapping("/studentDegreeData")
    public Result getDegreeReport(){
        log.info("获取学员学历统计信息");
        List<Map<String, Object>> degreeOption = reportService.getDegreeReport();
        return Result.success(degreeOption);
    }
    //班级人数统计
    @GetMapping("/studentCountData")
    public Result getStudentCountReport(){
        log.info("获取班级人数统计信息");
        ClazzOption studentCountOption = reportService.getStudentCountReport();
        return Result.success(studentCountOption);
    }

}
