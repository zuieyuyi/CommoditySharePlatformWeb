package com.commodityshareplatform.web.commodity.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Commodity {

    private Integer commodityId;

    private String commodityName;

    private Integer commodityStatus;

    private Integer commodityNum;

    private Integer commodityUserId;

    private String commodityImgSrc;

    private String commodityTag;

    private String commodityQuality;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone="GMT+8")
    private Date commodityCreateDate;

    private Integer isValid;

    private String commodityDetails;

    private String commodityStatusMsg;

    private String commodityUserName;

    public Integer getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Integer commodityId) {
        this.commodityId = commodityId;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName == null ? null : commodityName.trim();
    }

    public Integer getCommodityStatus() {
        return commodityStatus;
    }

    public void setCommodityStatus(Integer commodityStatus) {
        this.commodityStatus = commodityStatus;
    }

    public Integer getCommodityNum() {
        return commodityNum;
    }

    public void setCommodityNum(Integer commodityNum) {
        this.commodityNum = commodityNum;
    }

    public Integer getCommodityUserId() {
        return commodityUserId;
    }

    public void setCommodityUserId(Integer commodityUserId) {
        this.commodityUserId = commodityUserId;
    }

    public String getCommodityImgSrc() {
        return commodityImgSrc;
    }

    public void setCommodityImgSrc(String commodityImgSrc) {
        this.commodityImgSrc = commodityImgSrc == null ? null : commodityImgSrc.trim();
    }

    public String getCommodityTag() {
        return commodityTag;
    }

    public void setCommodityTag(String commodityTag) {
        this.commodityTag = commodityTag == null ? null : commodityTag.trim();
    }

    public String getCommodityQuality() {
        return commodityQuality;
    }

    public void setCommodityQuality(String commodityQuality) {
        this.commodityQuality = commodityQuality == null ? null : commodityQuality.trim();
    }

    public Date getCommodityCreateDate() {
        return commodityCreateDate;
    }

    public void setCommodityCreateDate(Date commodityCreateDate) {
        this.commodityCreateDate = commodityCreateDate;
    }

    public Integer getIsValid() {
        return isValid;
    }

    public void setIsValid(Integer isValid) {
        this.isValid = isValid;
    }

    public String getCommodityDetails() {
        return commodityDetails;
    }

    public void setCommodityDetails(String commodityDetails) {
        this.commodityDetails = commodityDetails == null ? null : commodityDetails.trim();
    }

    public String getCommodityStatusMsg() {
        return commodityStatusMsg;
    }

    public void setCommodityStatusMsg(String commodityStatusMsg) {
        this.commodityStatusMsg = commodityStatusMsg;
    }

    public String getCommodityUserName() {
        return commodityUserName;
    }

    public void setCommodityUserName(String commodityUserName) {
        this.commodityUserName = commodityUserName;
    }
}