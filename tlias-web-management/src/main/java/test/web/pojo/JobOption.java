package test.web.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.Options;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobOption {
    private List jobList;
    private List dataList;

}
