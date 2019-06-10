package com.idler.demo.user.api;

import com.idler.demo.user.pojo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface UserApi {
  @GetMapping("/users/query")
  User queryUser(@RequestParam("username")String username, @RequestParam("password")String password);

}
