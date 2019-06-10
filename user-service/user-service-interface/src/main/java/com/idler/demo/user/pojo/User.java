package com.idler.demo.user.pojo;

import com.idler.demo.commons.UUIdGenId;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Data
public class User {
  @Id
  @KeySql(genId = UUIdGenId.class)
  private String id;
  private String account;
  private String password;
  private String salt;
  private String name;
  private Integer age;
}
