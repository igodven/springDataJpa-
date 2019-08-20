package com.m520it.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cst_linkman")
public class LinkMan implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lkm_id")
    private Integer lkmId;
    @Column(name = "lkm_name")
    private String  lkmName;
    @Column(name = "lkm_gender")
    private String  lkmGender;
    @Column(name = "lkm_position")
    private String  lkmPosition;
    @Column(name = "lkm_email")
    private String  lkmEmail;
    @Column(name = "lkm_memo")
    private String  lkmMemo;
    @Column(name = "lkm_mobile")
    private String  lkmMobile;
    @Column(name = "lkm_phone")
    private String  lkmPhone;

    @ManyToOne(targetEntity = Customer.class)
    @JoinColumn(name = "lkm_cust_id",referencedColumnName = "cust_id")
    private Customer customer;

    public String getLkmName() {
        return lkmName;
    }

    public void setLkmName(String lkmName) {
        this.lkmName = lkmName;
    }

    public String getLkmGender() {
        return lkmGender;
    }

    public void setLkmGender(String lkmGender) {
        this.lkmGender = lkmGender;
    }

    public String getLkmPosition() {
        return lkmPosition;
    }

    public void setLkmPosition(String lkmPosition) {
        this.lkmPosition = lkmPosition;
    }

    public String getLkmEmail() {
        return lkmEmail;
    }

    public void setLkmEmail(String lkmEmail) {
        this.lkmEmail = lkmEmail;
    }

    public String getLkmMemo() {
        return lkmMemo;
    }

    public void setLkmMemo(String lkmMemo) {
        this.lkmMemo = lkmMemo;
    }

    public String getLkmMobile() {
        return lkmMobile;
    }

    public void setLkmMobile(String lkmMobile) {
        this.lkmMobile = lkmMobile;
    }

    public String getLkmPhone() {
        return lkmPhone;
    }

    public void setLkmPhone(String lkmPhone) {
        this.lkmPhone = lkmPhone;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "LinkMan{" +
                "lkmId=" + lkmId +
                ", lkmName='" + lkmName + '\'' +
                ", lkmGender='" + lkmGender + '\'' +
                ", lkmPosition='" + lkmPosition + '\'' +
                ", lkmEmail='" + lkmEmail + '\'' +
                ", lkmMemo='" + lkmMemo + '\'' +
                ", lkmMobile='" + lkmMobile + '\'' +
                ", lkmPhone='" + lkmPhone + '\'' +
                '}';
    }
}
