package com.liqingitt.exam_system.exceptionHandler;

import com.liqingitt.exam_system.exceptions.BusinessException;
import com.liqingitt.exam_system.utils.Results;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.HandlerMethodValidationException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.Objects;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public Results<Void> handleBusinessException(BusinessException e) {

        return Results.error(e.getCode(), e.getMessage());
    }
   @ExceptionHandler(HandlerMethodValidationException.class)
    public Results<Void> handleHandlerMethodValidationException(HandlerMethodValidationException e) {
       String message = e.getAllErrors().stream()
               .map(error -> {
                   String field = error.getArguments() != null && error.getArguments().length > 0 ? 
                           ((DefaultMessageSourceResolvable)error.getArguments()[0]).getDefaultMessage() : "";
                   return field + ":" + error.getDefaultMessage();
               })
               .filter(Objects::nonNull)
               .collect(Collectors.joining("，"));  // 使用中文逗号拼接
       return Results.error(400, message.isEmpty() ? "参数验证失败" : message);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Results<Void> handleHandlerMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        String message = e.getBindingResult().getFieldErrors().stream()
                .map(error -> error.getField() + ":" + error.getDefaultMessage())
                .filter(Objects::nonNull)
                .collect(Collectors.joining("，"));  // 使用中文逗号拼接
        return Results.error(400, message.isEmpty() ? "参数验证失败" : message);
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public Results<Void> handleNoResourceFoundException(NoResourceFoundException e) {
        return Results.error(404, "请求的资源不存在");
    }

    @ExceptionHandler(Exception.class)
    public Results<Void> handleException(Exception e) {
        System.out.println(e);
        return Results.error(500, "系统内部错误");
    }
}