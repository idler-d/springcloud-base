package com.idler.demo.user.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum UserExceptionEnum {

  USER_UNKNOWN(404, "找不到该用户"),
  INVALID_USERNAME_PASSWORD(400, "用户名或者密码错误"),
  CREATE_USER_ERROR(500, "创建用户失败"),
  ;
  private int code;
  private String msg;
}
