package com.idler.demo.passport.controller;

import com.idler.demo.commons.CookiesUtils;
import com.idler.demo.passport.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("auth")
public class AuthController {
  @Autowired
  private AuthService authService;

  @PostMapping("login")
  public ResponseEntity<Void> login(String username, String password,
                                    HttpServletRequest request, HttpServletResponse response) {
    //登录
    String token = authService.login(username, password);
    //设置cookies
    CookiesUtils.newBuilder(response).httpOnly().build("DEMO_TOKEN", token);

    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }

}
