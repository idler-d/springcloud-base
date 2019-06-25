package com.idler.demo.user.controller;

import com.idler.demo.user.exception.UserException;
import com.idler.demo.user.exception.UserExceptionEnum;
import com.idler.demo.user.pojo.User;
import com.idler.demo.user.service.UserService;
import org.apache.commons.lang3.BooleanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("users")
@RefreshScope
public class UserController {

  @Resource
  private UserService userService;
  @Value("${myapp.test}")
  private String test;

  @GetMapping("test")
  public ResponseEntity<String> test() {
    return ResponseEntity.ok(test);
  }

  @GetMapping
  public ResponseEntity<List<User>> users() {
    return ResponseEntity.ok(userService.queryUsers());
  }

  @PostMapping
  public ResponseEntity<User> saveUser(User user) {
    System.out.println(userService.saveUser(user));
    return new ResponseEntity<>(CREATED);
  }

  @GetMapping("/{id}")
  public ResponseEntity<User> user(@PathVariable("id") String id) {
    User user = userService.getUserById(id);
    if (user == null) {
      throw new UserException(UserExceptionEnum.USER_UNKNOWN);
    }
    return ResponseEntity.ok(user);
  }

  @PostMapping("/registry")
  public ResponseEntity<String> reg(User user, String code) {
    Boolean result = this.userService.register(user,code);
    if (BooleanUtils.isFalse(result)) {
      throw new UserException(UserExceptionEnum.CREATE_USER_ERROR);
    }
    return ResponseEntity.status(HttpStatus.CREATED).body("创建成功");
  }

  @GetMapping("/query")
  ResponseEntity<User> queryUser(@RequestParam("username")String username, @RequestParam("password")String password) {
    return ResponseEntity.ok(userService.queryUserByUserNameAndPassword(username, password));
  }
}
