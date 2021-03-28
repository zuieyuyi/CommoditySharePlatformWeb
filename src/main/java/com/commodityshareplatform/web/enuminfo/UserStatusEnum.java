package com.commodityshareplatform.web.enuminfo;

public enum UserStatusEnum {
    VIP_1(1,"VIP1"),
    VIP_2(2,"VIP2"),
    VIP_3(3,"VIP3");


    private Integer statusCode;
    private String status;

    UserStatusEnum(Integer statusCode, String status) {
        this.statusCode = statusCode;
        this.status = status;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
