package com.commodityshareplatform.web.enuminfo;

public enum OrderStatusEnum {
    PAYMENT(1,"支付中"),
    TAKE_DELIVERY(2,"确认出租"),
    RENT_OUT(3,"出租中"),
    RETURN(4,"返还确认"),
    RETURN_OVER(5,"订单完成");



    private Integer statusCode;
    private String status;

    OrderStatusEnum(Integer statusCode, String status) {
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
