package com.idler.demo.passport.exception;

import com.idler.demo.exception.CustomException;
import com.idler.demo.exception.vo.ResponseResult;

public class PassportException extends CustomException {
  public PassportException(PassportExceptionEnum passportExceptionEnum) {
    super(new ResponseResult(passportExceptionEnum.getCode(), passportExceptionEnum.getMsg()));
  }
}
