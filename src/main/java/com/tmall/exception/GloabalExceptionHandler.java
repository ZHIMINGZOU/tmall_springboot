package com.tmall.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Spring异常处理@ExceptionHandler
 * 将 Controller 层的异常和数据校验的异常进行统一处理,减少模板代码,减少编码量,提升扩展性和可维护性。
 */

@RestController
@ControllerAdvice//定义全局异常处理类
public class GloabalExceptionHandler {
    @ExceptionHandler(value = Exception.class)//声明异常处理方法
    public String defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        e.printStackTrace();
        Class constraintViolationException = Class.forName("org.hibernate.exception.ConstraintViolationException");
        if(null!=e.getCause()  && constraintViolationException==e.getCause().getClass()) {
            return "删除操作违反外键约束";
        }
        return e.getMessage();
    }
}
