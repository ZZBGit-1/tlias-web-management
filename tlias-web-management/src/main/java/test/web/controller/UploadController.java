package test.web.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import test.web.pojo.Result;
import test.web.utils.AliyunOSSOperator;

import java.io.IOException;

@Slf4j
@RestController

public class UploadController {
    @Autowired
    private AliyunOSSOperator aliyunOSSOperator;
    @PostMapping("/upload")
        public Result upload(MultipartFile file) throws Exception {
            String url = aliyunOSSOperator.upload(file.getBytes(), file.getOriginalFilename());
            log.info("上传图片成功，图片url：{}", url);
            return Result.success(url);
        }
}
