package tech.abite.ice.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public GlobalResult<String> exceptionHandler(Exception e) {
        log.error(e.getMessage());
        e.printStackTrace();
        return GlobalResult.error("服务器异常：" + e.getMessage());
    }
}
