package com.commodityshareplatform.web.user.bean;

import java.math.BigDecimal;
import java.util.Date;

public class User {

    private Integer userId;

    private String userName;

    private String userPw;

    private String userBuy;

    private String userAddr;

    private String userCollect;

    private String userEmail;

    private Integer userStatus;

    private Date userCreateDate;

    private Integer userIsAdmin;

    private BigDecimal userMoney;

    private Integer isValid;

    private String userDetails;

    private String userStatusMsg;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPw() {
        return userPw;
    }

    public void setUserPw(String userPw) {
        this.userPw = userPw == null ? null : userPw.trim();
    }

    public String getUserBuy() {
        return userBuy;
    }

    public void setUserBuy(String userBuy) {
        this.userBuy = userBuy == null ? null : userBuy.trim();
    }

    public String getUserAddr() {
        return userAddr;
    }

    public void setUserAddr(String userAddr) {
        this.userAddr = userAddr == null ? null : userAddr.trim();
    }

    public String getUserCollect() {
        return userCollect;
    }

    public void setUserCollect(String userCollect) {
        this.userCollect = userCollect == null ? null : userCollect.trim();
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public Date getUserCreateDate() {
        return userCreateDate;
    }

    public void setUserCreateDate(Date userCreateDate) {
        this.userCreateDate = userCreateDate;
    }

    public Integer getUserIsAdmin() {
        return userIsAdmin;
    }

    public void setUserIsAdmin(Integer userIsAdmin) {
        this.userIsAdmin = userIsAdmin;
    }

    public BigDecimal getUserMoney() {
        return userMoney;
    }

    public void setUserMoney(BigDecimal userMoney) {
        this.userMoney = userMoney;
    }

    public Integer getIsValid() {
        return isValid;
    }

    public void setIsValid(Integer isValid) {
        this.isValid = isValid;
    }

    public String getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(String userDetails) {
        this.userDetails = userDetails == null ? null : userDetails.trim();
    }

    public String getUserStatusMsg() {
        return userStatusMsg;
    }

    public void setUserStatusMsg(String userStatusMsg) {
        this.userStatusMsg = userStatusMsg;
    }
}