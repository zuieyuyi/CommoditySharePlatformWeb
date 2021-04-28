package com.commodityshareplatform.web.enuminfo;

public enum OrderStatusEnum {
    PAYMENT(1,"支付中"),
    TAKE_DELIVERY(2,"确认出租"),
    RENT_OUT(3,"出租中"),
    RETURN(4,"返还确认"),
    RETURN_OVER(5,"订单完成"),
    NO_TAKE_DELIVERY(6,"未确认出租"),
    NO_RETURN(7,"未返还"),
    TAKE_RECEIPT(8,"确认收货"),
    NO_TAKE_RECEIPT(9,"未确认收货");


    /* 支付中1 -》 确认出租2（默认购买了就是，卖家）-》 未确认收货9 -》 确认收货8（买家） -》 出租中3 -》 未返还7（到了结束时间）-》 返还确认4（买家） -》 完成订单5（卖家）*/

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
