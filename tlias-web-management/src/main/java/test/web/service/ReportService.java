package test.web.service;

import test.web.pojo.ClazzOption;
import test.web.pojo.JobOption;

import java.util.List;
import java.util.Map;

public interface ReportService {
    JobOption getReport();

    List<Map<String, Object>> getGenderReport();


    List<Map<String, Object>> getDegreeReport();

    ClazzOption getStudentCountReport();
}
