package com.idler.demo.passport.service;

import com.idler.demo.passport.client.UserClient;
import com.idler.demo.passport.exception.PassportException;
import com.idler.demo.passport.exception.PassportExceptionEnum;
import com.idler.demo.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

  @Autowired
  private UserClient userClient;

  public String login(String username, String password) {
    User user = userClient.queryUser(username, password);
    if (user == null) {
      throw new PassportException(PassportExceptionEnum.INVALID_USERNAME_PASSWORD);
    }
    //生成token
    return null;
  }
}
