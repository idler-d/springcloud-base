package com.idler.demo.user.controller;

import com.idler.demo.user.pojo.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("reg")
public class RegistryController {

  @PostMapping
  public ResponseEntity<String> reg(User user, String code) {
    return ResponseEntity.status(HttpStatus.CREATED).body("创建成功");
  }
}
