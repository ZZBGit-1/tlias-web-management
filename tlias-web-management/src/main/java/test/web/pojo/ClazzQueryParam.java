package test.web.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClazzQueryParam {
    private Integer page =1;//查询页
    private Integer pageSize =10;//每页大小
    private String name;//查询名称
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate begin;//开始时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate end;//结束时间
}
