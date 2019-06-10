package com.idler.demo.user.controller;

import com.idler.demo.user.exception.UserException;
import com.idler.demo.user.exception.UserExceptionEnum;
import com.idler.demo.user.pojo.User;
import com.idler.demo.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("users")
public class UserController {

  @Resource
  private UserService userService;

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

  @RequestMapping(value = "query", method = RequestMethod.GET)
  ResponseEntity<User> queryUser(@RequestParam("username")String username, @RequestParam("password")String password) {
    return ResponseEntity.ok(userService.queryUserByUserNameAndPassword(username, password));
  }
}
