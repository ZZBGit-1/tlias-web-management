package test.web.exception;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.yaml.snakeyaml.constructor.DuplicateKeyException;
import test.web.pojo.Result;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public Result HandleException(Exception e) {
        log.error("Exception:", e);
        return Result.error("程序或服务器出现错误，请联系管理员");
    }
    @ExceptionHandler
    public Result handleDuplicateKeyException(DuplicateKeyException e) {
        log.error("Exception:", e);
        String message = e.getMessage();
        int i = message.indexOf("Duplicate entry");
        String errMsg = message.substring(i );
        String[] arr = errMsg.split(" ");
        return Result.error(arr[2]+"数据重复");
    }
}
