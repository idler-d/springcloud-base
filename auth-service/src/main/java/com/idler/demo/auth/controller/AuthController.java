package com.idler.demo.auth.controller;

import com.idler.demo.auth.entity.UserInfo;
import com.idler.demo.auth.properties.AuthProperties;
import com.idler.demo.auth.service.AuthService;
import com.idler.demo.commons.cookies.CookieUtils;
import com.idler.myjwt.core.JwtUtils;
import com.idler.myjwt.properties.JwtProperties;
import com.idler.myjwt.service.JwtService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("auth")
public class AuthController {

  @Autowired
  private AuthService authService;

  @Autowired
  private AuthProperties authProperties;

  @Autowired
  private JwtService jwtService;

  /**
   * 登录授权
   */
  @PostMapping("login")
  public ResponseEntity<Void> login(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletRequest request, HttpServletResponse response) {
    //1.登录校验
    String token = this.authService.login(username, password);
    if (StringUtils.isBlank(token)) {
      return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
    //2.将token写入cookie，并指定httpOnly为true，防止通过js获取和修改
    CookieUtils.setCookie(request, response, authProperties.getCookieName(), token, authProperties.getCookieMaxAge(), true);

    return ResponseEntity.ok().build();
  }

  /**
   * 用户验证
   */
  @GetMapping("verify")
  public ResponseEntity<UserInfo> verifyUser(@CookieValue("DEMO_TOKEN") String token, HttpServletRequest request, HttpServletResponse response) {
    try {
      //1.从token中解析token信息
      UserInfo userInfo = jwtService.parserToken(token, UserInfo.class);
      //2.解析成功要重新刷新token
      token = jwtService.generateToken(userInfo);
      //3.更新Cookie中的token
      CookieUtils.setCookie(request, response, authProperties.getCookieName(), token, authProperties.getCookieMaxAge());
      //4.解析成功返回用户信息
      return ResponseEntity.ok(userInfo);
    } catch (Exception e) {
      e.printStackTrace();
    }
    //5.出现异常,相应401
    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
  }

}