package com.yoandypv.boot3demo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler ({RuntimeException.class})
    public ProblemDetail onError(RuntimeException ex, HttpServletRequest request) {
        System.out.println(request.getMethod());

        return ProblemDetail.forStatusAndDetail(HttpStatus.valueOf(404), ex.getMessage());
    }

}
