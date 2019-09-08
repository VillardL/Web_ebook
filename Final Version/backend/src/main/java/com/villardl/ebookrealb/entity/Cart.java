package com.villardl.ebookrealb.entity;
import javax.persistence.*;

@Table(name="cart")
@Entity

public class Cart {
    @Id
    private String ubname;
    private String busername;
    private String bbookname;
    private Integer bprice;
    private Integer bnum;
    public String getUbname(){return ubname;}
    public String getBusername(){return  busername;}
    public String getBbookname(){return bbookname;}
    public Integer getBprice(){return bprice;}
    public Integer getBnum(){return bnum;}

    public void setUbname(String ubname) {
        this.ubname = ubname;
    }

    public void setBbookname(String bbookname) {
        this.bbookname = bbookname;
    }
    public void setBnum(Integer bnum) {
        this.bnum = bnum;
    }
    public void setBusername(String busername) {
        this.busername = busername;
    }
    public void setBprice(Integer bprice) {
        this.bprice = bprice;
    }
}

