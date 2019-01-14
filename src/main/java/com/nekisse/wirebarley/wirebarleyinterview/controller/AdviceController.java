package com.nekisse.wirebarley.wirebarleyinterview.controller;

import com.nekisse.wirebarley.wirebarleyinterview.controller.dto.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;
import java.util.Optional;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;


@RestControllerAdvice
public class AdviceController {


  Logger log = LoggerFactory.getLogger(Controller.class);

  @ResponseStatus(INTERNAL_SERVER_ERROR)
  @ExceptionHandler(Exception.class)
  public ErrorResponse handleException(Exception e) {
    log.error("[서버 에러]", e);
    return new ErrorResponse("잠시 후 다시 시도해주세요.");
  }

  @ResponseStatus(BAD_REQUEST)
  @ExceptionHandler(BindException.class)
  public ErrorResponse handleException(BindException e) {
    BindingResult bindingResult = e.getBindingResult();
    if (bindingResult == null) {
      return new ErrorResponse("잘못된 요청입니다.");
    }
    return new ErrorResponse(Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
  }

}
