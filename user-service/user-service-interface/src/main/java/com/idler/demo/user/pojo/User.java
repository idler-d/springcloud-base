package com.idler.demo.user.pojo;

import com.idler.demo.commons.uuid.UUIdGenId;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "users")
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
  private Date createTime;
}
