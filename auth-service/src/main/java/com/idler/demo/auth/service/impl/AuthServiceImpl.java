package com.idler.demo.auth.service.impl;

import com.idler.demo.auth.client.UserClient;
import com.idler.demo.auth.entity.UserInfo;
import com.idler.demo.auth.exception.PassportException;
import com.idler.demo.auth.exception.PassportExceptionEnum;
import com.idler.demo.auth.service.AuthService;
import com.idler.demo.user.pojo.User;
import com.idler.myjwt.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

  @Autowired
  private UserClient userClient;

  @Autowired
  private JwtService jwtService;


  /**
   * 用户登录
   */
  @Override
  public String login(String username, String password) {

    try {
      //1.调用微服务查询用户信息
      User user = userClient.queryUser(username, password);
      //2.查询结果为空，则直接返回null
      if (user == null) {
        throw new PassportException(PassportExceptionEnum.INVALID_USERNAME_PASSWORD);
      }
      //3.查询结果不为空，则生成token
      return jwtService.generateToken(new UserInfo(user.getId(), user.getAccount()));

    } catch (Exception e) {
      e.printStackTrace();
      throw new PassportException(PassportExceptionEnum.INVALID_USERNAME_PASSWORD);
    }
  }
}