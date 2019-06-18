package com.idler.demo.auth.service;

public interface AuthService {
  /**
   * 用户登录
   */
  String login(String username, String password);
}