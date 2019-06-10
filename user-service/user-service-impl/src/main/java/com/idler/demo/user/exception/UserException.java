package com.idler.demo.user.exception;

import com.idler.demo.exception.CustomException;
import com.idler.demo.exception.vo.ResponseResult;

public class UserException extends CustomException {

  public UserException(UserExceptionEnum userExceptionEnum) {
    super(new ResponseResult(userExceptionEnum.getCode(), userExceptionEnum.getMsg()));
  }
}
