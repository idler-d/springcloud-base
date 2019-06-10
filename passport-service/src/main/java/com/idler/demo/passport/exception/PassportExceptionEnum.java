package com.idler.demo.passport.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum PassportExceptionEnum {

  INVALID_USERNAME_PASSWORD(400, "用户名或者密码错误"),
  ;
  private int code;
  private String msg;
}
