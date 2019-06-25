package com.idler.demo.user.service;

import com.idler.demo.commons.codec.CodecUtils;
import com.idler.demo.user.exception.UserException;
import com.idler.demo.user.exception.UserExceptionEnum;
import com.idler.demo.user.mapper.UserMapper;
import com.idler.demo.user.pojo.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class UserService {

  @Resource
  private UserMapper userMapper;
  @Autowired
  private StringRedisTemplate stringRedisTemplate;

  public List<User> queryUsers() {
    return userMapper.selectAll();
  }

  public User saveUser(User user) {
    userMapper.insert(user);
    return user;
  }

  public User getUserById(String id) {
    return userMapper.selectByPrimaryKey(id);
  }

  public User queryUserByUserNameAndPassword(String username, String password) {
    User record = new User();
    record.setAccount(username);
    User user = userMapper.selectOne(record);
    //用户名不存在
    if (user == null) {
      throw new UserException(UserExceptionEnum.INVALID_USERNAME_PASSWORD);
    }
    //密码摘要
    String passwordMD5;
    try {
      passwordMD5 = CodecUtils.md5Hex(password, user.getSalt());
    } catch (Exception e) {
      throw new UserException(UserExceptionEnum.INVALID_USERNAME_PASSWORD);
    }
    //数据库和密码摘要对比
    if (!StringUtils.equals(user.getPassword(), passwordMD5)) {
      throw new UserException(UserExceptionEnum.INVALID_USERNAME_PASSWORD);
    }

    return user;
  }

  public String generateCode(String account) {
    String code = "2343434";
    stringRedisTemplate.opsForValue().set("USER_REGISTER_CODE" + account, code, 5, TimeUnit.MINUTES);
    return code;
  }

  public Boolean register(User user, String code) {
    user.setId(null);
    user.setCreateTime(new Date());
    user.setSalt(CodecUtils.createSalt());
    //密码加密
    try {
      user.setPassword(CodecUtils.md5Hex(user.getPassword().trim(), user.getSalt()));
    } catch (Exception e) {
      throw new UserException(UserExceptionEnum.CREATE_USER_ERROR);
    }

    //写入数据库
    boolean result = userMapper.insertSelective(user) == 1;
    return result;
  }


}
