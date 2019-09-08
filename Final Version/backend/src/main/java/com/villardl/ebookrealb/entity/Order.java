package com.villardl.ebookrealb.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "allorder")
@Entity
public class Order {
  @Id
  private Integer orderi;
  private String ouser;
  private String obook;
  private Integer onum;
  private String otime;
  private String ostate;
  public Integer getOrderi() {
    return orderi;
  } public String getOuser() {
    return ouser;
  } public String getObook() {
    return obook;
  }  public Integer getOnum() {
    return onum;
  }
  public String getOtime() {
    return otime;
  }
  public String getOstate() {
    return ostate;
  }

  public void setObook(String obook) {
    this.obook = obook;
  }
  public void setOnum(Integer onum) {
    this.onum = onum;
  }
  public void setOrderi(Integer orderi) {
    this.orderi = orderi;
  }
  public void setOstate(String ostate) {
    this.ostate = ostate;
  }
  public void setOtime(String otime) {
    this.otime = otime;
  }
  public void setOuser(String ouser) {
    this.ouser = ouser;
  }
}
